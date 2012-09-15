package problems21to30

//A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. 
//For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
//A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
//As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, 
//the smallest number that can be written as the sum of two abundant numbers is 24. 
//By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. 
//However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number 
//that cannot be expressed as the sum of two abundant numbers is less than this limit.
//Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.

import numbers._
import scala.collection.mutable.HashSet

object Problem23 
{
	def main(args: Array[String]) 
	{
		val upperLimit = 28123
		val multiSet = multiSetComposite((1 to upperLimit).filter(isAbundant))
		println("sum " + (1 to upperLimit).filterNot(multiSet.contains).sum)
	}
	
	def multiSetComposite(composite : Seq[Int]) = 
	{
		val hashRet = new HashSet[Int]
		val limit = composite.size
		var i = 0
		var j = 0
		
		while (i < limit)
		{
			hashRet += composite(i) + composite(i)
			j = i + 1
			while (j < limit)
			{
				hashRet += composite(i) + composite(j)
				j += 1
			}
			i += 1
		}
		hashRet
	}
	
	def isAbundant(x : Int) : Boolean = 
	{
		var curSum = 0
		var index = x / 2
		
		while(index > 0)
		{
			if (x % index == 0)
			{
				curSum += index
				if (curSum > x) return true
			}
			index -= 1
		}
		false
	}
}