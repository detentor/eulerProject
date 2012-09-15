package problems141to150

import scala.collection.mutable.BitSet

//The smallest positive integer n for which the numbers n2+1, n2+3, 
//n2+7, n2+9, n2+13, and n2+27 are consecutive primes is 10. 
//The sum of all such integers n below one-million is 1242490.
//
//What is the sum of all such integers n below 150 million?
object Problem146 
{
	def main(args: Array[String]) 
	{
		val bSet = new BitSet
		val maxVal = math.ceil(math.sqrt(150000000)).toInt
		
		bSet ++= (2 to 150000000)
		bSet --= (4 to maxVal by 2)
		for (i <- 3 to maxVal by 2) bSet --= ((i + i) to maxVal by i)
		
		println(bSet)
		
//		
//		
//		val primeSet = primes.takeWhile(_ < 150000000).toSet
//		def isPrime(x : Int) = primeSet.contains(x)
//		
//		val mList = List(1, 3, 7, 9, 13, 27) 
//		
//		val startTime = System.currentTimeMillis
//		
//		val resp = (2 until 150000000 by 2).filter(k => { if (k % 10000 == 0)println(k) ; val t = k * k; mList.forall(y => isPrime(t + y)) } )
//		
//		println(resp.map(k => mList.map(y => k * k + y).sum).sum)
//		
//		println("tempo : " + (System.currentTimeMillis - startTime))
//		
//		println(resp mkString(" "))
  
	}

}