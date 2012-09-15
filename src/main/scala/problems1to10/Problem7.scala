package problems1to10

import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Buffer

//By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
//What is the 10 001st prime number?
object Problem7
{
	def main(args: Array[String]) 
	{
		val primos = 2L #:: 3 #:: primes((2L :: 3L :: Nil).toStream)
		primos take 10001 foreach println
	}
	
	def from(n : Long) : Stream[Long] = n #:: from(n + 1)
	
	def primes(lPrimos : Stream[Long]) : Stream[Long] = 
	{
		val newValue = from(lPrimos.head + 1).find(k => lPrimos.forall(x => k % x != 0)).get
		Stream.cons(newValue, primes(newValue #:: lPrimos))
	}
}