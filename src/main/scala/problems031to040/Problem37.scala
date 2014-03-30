package problems031to040

import scala.collection.immutable.Stream.consWrapper

//The number 3797 has an interesting property. Being prime itself, 
//it is possible to continuously remove digits from left to right, 
//and remain prime at each stage: 3797, 797, 97, and 7. 
//Similarly we can work from right to left: 3797, 379, 37, and 3.
//
//Find the sum of the only eleven primes that are 
//both truncatable from left to right and right to left.
//
//NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
object Problem37 
{
	def main(args: Array[String]) 
	{
		lazy val primes : Stream[Int] = 
			2 #:: Stream.from(3).filter(k => primes.takeWhile(i => i*i <= k).forall(k % _ > 0))

		def isPrime(x : Int) = x > 1 && primes.takeWhile(k => k * k <= x).forall(x % _ > 0)
		
		def isTruncable(x : String) = isTruncableLeft(x.toString) && isTruncableRight(x.toString)
		def isTruncableLeft(x : String) = (0 until x.size).forall(k => isPrime(x.drop(k).toInt))
		def isTruncableRight(x : String) = (0 until x.size).forall(k => isPrime(x.dropRight(k).toInt))
	
		val results = primes.dropWhile(_ < 10).scanLeft(List.empty[Int])(
			(x, y) =>  if (isTruncable(y.toString)) y :: x else x).dropWhile(_.size < 11).take(1) 

		println(results.head.sum)
	}

}