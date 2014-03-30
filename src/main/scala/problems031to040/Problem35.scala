package problems031to040

import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Buffer
import scala.collection.immutable.HashSet

//The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
//There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
//How many circular primes are there below one million?
import numbers._

object Problem35 
{
	def main(args: Array[String]) 
	{
		val primeBag = primes.takeWhile(_ < 1000000).toSet
		println(primeBag.filter(num => isCircularPrime(num, primeBag)).size)
	}
	
	def isCircularPrime(x : Long, primeBag : Set[Long]) = 
	{
		circularPerm(x.toString.toList).forall(x => primeBag.contains(x.foldLeft("")(_ + _.toString).toInt))
	}
	
	def circularPerm[k](x : Seq[k]) = 
	{
		(0 until x.size).map(num =>
		{
			val res = x.splitAt(num)
			res._2 ++ res._1
		})
	}
}
