package problems91to100

import scala.collection.mutable.Set
import scala.annotation.tailrec

//The proper divisors of a number are all the divisors excluding the number itself. 
//For example, the proper divisors of 28 are 1, 2, 4, 7, and 14. 
//As the sum of these divisors is equal to 28, we call it a perfect number.
//
//Interestingly the sum of the proper divisors of 220 is 284 and the sum of the proper 
//divisors of 284 is 220, forming a chain of two numbers. For this reason, 220 and 284 are called an amicable pair.
//
//Perhaps less well known are longer chains. For example, starting with 12496, we form a chain of five numbers:
//
//12496 -> 14288 -> 15472 -> 14536 -> 14264 (12496  ...)
//
//Since this chain returns to its starting point, it is called an amicable chain.
//
//Find the smallest member of the longest amicable chain with no element exceeding one million.
object Problem95 
{
	def main(args: Array[String]) 
	{
		def getDivisorsSum(x : Int) = (1 to x/2).filter(x % _ == 0).sum
		
		@tailrec
		def getDivisorChain(x : Int, prevSeen : Set[Int]) : Int = 
		{
			val newNum = getDivisorsSum(x)
			if (newNum > 1000000) -1 
			else
			{
				if (prevSeen.contains(newNum)) prevSeen.size
				else getDivisorChain(newNum, prevSeen += newNum)
			}
		}
		
		def from(n : Int) : Stream[Int] = n #:: from(n + 1)
		
		val k = from(1).takeWhile(_ < 1000000)
					   .map(k =>
					  	 {
					  		 println(k)
					  		(k, getDivisorChain(k, Set(k))) 
					  	 })
				  	 	.maxBy(_._2)
//		(203034,103)
		println(k)
  
	}

}