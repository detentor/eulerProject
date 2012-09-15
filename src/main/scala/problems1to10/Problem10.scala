package problems1to10


//The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
//Find the sum of all the primes below two million.

object Problem10
{
	def main(args: Array[String]) 
	{
		val startTime = System.currentTimeMillis;
		val primos = primes
		println("sum : " + primos.takeWhile( _ < 2000000L).sum)
		println(System.currentTimeMillis - startTime)
	}
	
	lazy val primes: Stream[Long] = 2L #:: from(3).filter(i => primes.takeWhile(j => j * j <= i).forall(i % _> 0))
	def from(n : Long) : Stream[Long] = n #:: from(n + 1)
}