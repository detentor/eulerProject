package problems41to50

//The prime 41, can be written as the sum of six consecutive primes:
//41 = 2 + 3 + 5 + 7 + 11 + 13
//
//This is the longest sum of consecutive primes that adds to a prime below one-hundred.
//
//The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.
//
//Which prime, below one-million, can be written as the sum of the most consecutive primes?
import numbers._
import scala.annotation.tailrec
import scala.collection.immutable.HashSet

object Problem50
{
	def main(args: Array[String]) 
	{
		val sumLimit = 1000000
		val allPrimes = primes.takeWhile(_ <= sumLimit)
		
		@tailrec
		def findSum(inStream : Stream[Long], curSum : Long) : Long = if (inStream.contains(curSum)) curSum 
																	 else findSum(inStream.tail, curSum - inStream.head)
																	 
		println(findSum(allPrimes, 
						allPrimes.scanLeft(0L)(_+_).takeWhile(_ <= sumLimit).force.last))
		
	}
	
}