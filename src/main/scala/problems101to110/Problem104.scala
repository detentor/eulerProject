package problems101to110

//The Fibonacci sequence is defined by the recurrence relation:
//Fn = Fn1 + Fn2, where F1 = 1 and F2 = 1.
//
//It turns out that F541, which contains 113 digits, is the first 
//Fibonacci number for which the last nine digits are 1-9 pandigital 
//(contain all the digits 1 to 9, but not necessarily in order). 
//And F2749, which contains 575 digits, is the first Fibonacci 
//number for which the first nine digits are 1-9 pandigital.
//
//Given that Fk is the first Fibonacci number for which 
//the first nine digits AND the last nine digits are 1-9 pandigital, find k.
object Problem104 
{
	def main(args: Array[String]) 
	{
		def fibb(n : BigInt, prevList : List[BigInt]) =
		{
			val curFib = prevList.head + prevList.tail.head
			(curFib, curFib :: prevList.dropRight(1))
		}

		var curN = BigInt(3)
		var theList = BigInt(1) :: BigInt(1) :: Nil
		var stop = false
		
		while (! stop)
		{
			val curFib = fibb(curN, theList)
			
			theList = curFib._2
			
			if (curN % 5000 == 0) println(curN)
			
			val test = curFib._1.toByteArray
			
			val m = new java.math.BigInteger(test.take(512))
			val n = new java.math.BigInteger(test.takeRight(512))
			
			val firstD = m.toString.take(9)
			val lastD = m.toString.takeRight(9)
			
			stop = (1 to 9).forall(i => firstD.contains(i.toString) && lastD.contains(i.toString))
			if (! stop) curN += 1
		}
		
		println(curN)
	}
	
	
	//		def fib:Stream[BigInt]=
//		{
//			def fibInner(f0:BigInt, f1:BigInt) : Stream[BigInt] = Stream.cons(f0, fibInner(f1, f0 + f1))
//			fibInner(1, 2)
//		}
		
//		val t = fib.zipWithIndex.dropWhile(_._1 < 987654321).find(k =>
//		{
//			if (k._2 % 5000 == 0) println(k._2)
//			
//			val test = k._1.toByteArray
//			
//			val m = new java.math.BigInteger(test.take(512))
//			val n = new java.math.BigInteger(test.takeRight(512))
//			
//			val firstD = m.toString.take(9)
//			val lastD = m.toString.takeRight(9)
//			
//			(1 to 9).forall(i => firstD.contains(i.toString) && lastD.contains(i.toString))
//		})
		

}