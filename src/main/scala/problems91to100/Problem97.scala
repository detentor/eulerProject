package problems91to100

import scala.collection.mutable.BitSet

//The first known prime found to exceed one million digits
//was discovered in 1999, and is a Mersenne prime of the form 269725931; 
//it contains exactly 2,098,960 digits. Subsequently other Mersenne primes, 
//of the form 2^p - 1, have been found which contain more digits.
//
//However, in 2004 there was found a massive non-Mersenne prime which contains 2,357,207 digits: 28433 * 2 ^7830457 +1.
//
//Find the last ten digits of this prime number.
object Problem97 
{
	def main(args: Array[String]) 
	{
		val cleaner = 100000000000L
		var curNum = 2L
		
		for (i <- 1 until 7830457) 
			curNum = (curNum * 2) % cleaner
		
		curNum *= 28433
		curNum += 1
		
		println(curNum.toString.takeRight(10))
//		8.739.992.577 63 sec
	}

}