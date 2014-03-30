package problems021to030

//Euler published the remarkable quadratic formula:
//
//n² + n + 41
//
//It turns out that the formula will produce 40 primes for the consecutive values n = 0 to 39. 
//However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41 is divisible by 41, 
//and certainly when n = 41, 41² + 41 + 41 is clearly divisible by 41.
//
//Using computers, the incredible formula  n² - 79n + 1601 was discovered, which produces 80 primes 
//for the consecutive values n = 0 to 79. The product of the coefficients, 79 and 1601, is 126479.
//
//Considering quadratics of the form:
//n² + an + b, where |a|  1000 and |b|  1000
//
//where |n| is the modulus/absolute value of n
//e.g. |11| = 11 and |-4| = 4
//
//Find the product of the coefficients, a and b, for the quadratic expression 
//that produces the maximum number of primes for consecutive values of n, starting with n = 0.

object Problem27 
{
	def main(args: Array[String]) 
	{
		def isPrime(x : Int) = if (x < 2) false 
							   else if (x == 2) true 
							   else (2 to math.ceil(math.sqrt(x)).toInt).forall(x % _ > 0)

		val result = (-1000 to 1000).map(i => 
					     (-1000 to 1000).map(j => 
					    	 (Stream.from(0).takeWhile(
				    			 x => isPrime(x * x + x * i + j)).size, i, j))
					     .maxBy(_._1))
					.maxBy(_._1)

		println(result._2 * result._3)
	}

}