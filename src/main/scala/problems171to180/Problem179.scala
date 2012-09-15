package problems171to180

//Find the number of integers 1 < n < 10 ^7, for which n and n + 1 have the same number of positive divisors. 
//For example, 14 has the positive divisors 1, 2, 7, 14 while 15 has 1, 3, 5, 15.

import numbers._

object Problem179 
{
	def main(args: Array[String]) 
	{
		var prevDivisor = 2
		val answer = (2L to BigInt(10).pow(7).toLong)
							.count(k => 
								{ 
									if (k % 10000 == 0) println(k)
									val prevP = prevDivisor
									prevDivisor = getProperDivisors(k + 1).size; 
									prevDivisor == prevP
								})
		println(answer)
	}

}