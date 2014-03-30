package problems041to050

import scala.collection.mutable.BitSet

//We shall say that an n-digit number is pandigital if it makes 
//use of all the digits 1 to n exactly once. 
//For example, 2143 is a 4-digit pandigital and is also prime.
//
//What is the largest n-digit pandigital prime that exists?
object Problem41 
{
	def main(args: Array[String]) 
	{
		def isPrime(x : Int) = 
		{
			if (x < 2) false
			else if (x == 2) true
			else (2 to math.ceil(math.sqrt(x)).toInt).forall(x % _ > 0)
		}

		var cont = true
		var curHigh = 9
		var result = -1

		while (cont)
		{
			val per = (1 to curHigh).permutations.filter(k => isPrime(k.mkString.toInt))
			cont = per.isEmpty
			curHigh -= 1
			if (per.isEmpty) curHigh -= 1 else result = per.map(_.mkString.toInt).max
		}
		println(result)
	}

}