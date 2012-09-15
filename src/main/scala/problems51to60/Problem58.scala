package problems51to60

//Starting with 1 and spiralling anticlockwise in the following way, a square spiral with side length 7 is formed.
//
							// 37 36 35 34 33 32 31
							// 38 17 16 15 14 13 30
							// 39 18  5  4  3 12 29
							// 40 19  6  1  2 11 28
							// 41 20  7  8  9 10 27
							// 42 21 22 23 24 25 26
							// 43 44 45 46 47 48 49
//
//It is interesting to note that the odd squares lie along the bottom right diagonal, 
//but what is more interesting is that 8 out of the 13 numbers lying along 
//both diagonals are prime; that is, a ratio of 8/13  62%.
//
//If one complete new layer is wrapped around the spiral above, a square spiral with side 
//length 9 will be formed. If this process is continued, what is the side length of the 
//square spiral for which the ratio of primes along both diagonals first falls below 10%?
object Problem58 
{
	def main(args: Array[String]) 
	{
		lazy val odds = oddFrom(3)
		
		def oddFrom(x : Long) : Stream[Long] = x #:: oddFrom(x + 2) 
		def isPrime(x : Long) = (2 #:: odds).takeWhile(k => k * k <= x).forall(x % _ > 0)
		
		def spiralNums(n : Int = 3, lastNum : Long = 1) : Stream[Seq[Long]] = 
		{
			val resp = (1 to 4).map(k => lastNum + k * (n - 1)).toArray
			resp #:: spiralNums(n + 2, resp.last)
		}
		
		val startTime = System.currentTimeMillis
		
		val resp = spiralNums().zipWithIndex.scanLeft((0, 1d, 0))((x, y) => 
				{
					val nextCount = x._1 + y._1.count(isPrime)
					val curProb = nextCount / ( (y._2 + 1) * 4d + 1)
					(nextCount, curProb, x._3 + 1)
				})
				.dropWhile(_._2 > 0.10).take(1).head
		
		println(System.currentTimeMillis - startTime)
		println(resp._3 * 2 + 1) //26241
	}

}