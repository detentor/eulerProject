package problems111to120

import scala.collection.mutable.HashMap
import scala.collection.mutable.ListBuffer
import scala.math._
import scala.collection.mutable.ArrayBuffer

object Problem111 
{
	def main(args: Array[String]) 
	{
//		def isPrime(k : Int) = k == 2 || (k % 2 > 0 && (3 to ceil(sqrt(k)).toInt by 2).forall(k % _ > 0))
//		def nextPrime(x : Int) : Stream[Int] = 
//		{
//			val k = Stream.from(x + 1).find(isPrime).get
//			k #:: nextPrime(k)
//		}  
//		
////		//Retorna um Stream de primos
////		lazy val primes: Stream[Int] = 2 #:: Stream.from(3).filter(i => primes.takeWhile(j => j * j <= i).forall(i % _> 0))
////		
		val lowerBound = BigInt(10).pow(9).toInt
		val upperBound = lowerBound * 10
		
//		val resp = nextPrime(lowerBound).dropWhile(_ < lowerBound)
//					 	  				.takeWhile(_ < upperBound).force
					 	 
		val resp = generatePrimes(upperBound).dropWhile(_ < lowerBound)

		val mapaDigitos = HashMap.empty[Int, ListBuffer[Tuple2[Int, Int]]]
		(0 to 9).foreach(k => mapaDigitos += Tuple2(k, ListBuffer.empty[Tuple2[Int, Int]]))

		for (num <- resp)
		{
			val numArr = num.toString.toArray.map(_ - 48)
			for (i <- 0 to 9)
			{
				mapaDigitos.get(i).get += Tuple2(num, numArr.count(_ == i))
			}
		}
		
		val t = mapaDigitos.map(k => { val max = k._2.maxBy(_._2)._2; k._2.filter(y => y._2 == max).map(_._1).sum}).sum
		
		println(t)
	}
	
	
	
	def generatePrimes(toN : Int) = 
	{
//		val sqr = math.sqrt(toN).toInt
//		val nums = Array.ofDim[Boolean](toN + 1)
//		val primes = ArrayBuffer.empty[Int]
//
//		(4 to toN by 2).foreach(k => nums(k) = true)
//		(3 to sqr by 2).foreach( k => ((k + k) to toN by k).foreach(y => nums(y) = true))
//		(2 to toN).foreach(k => if (!nums(k)) primes += k)
//		primes
		
		println((toN + 1) / 31)
		
		val sqr = math.sqrt(toN).toInt
		val nums = new Array[Int]((toN + 1) / 31)
		
		val primes = ArrayBuffer.empty[Int]

		(4 to toN by 2).foreach(k => nums(k / 32) |= 1 << (k % 32))
		(3 to sqr by 2).foreach(k => ((k + k) to toN by k).foreach(y => nums(y / 32) |= 1 << (y % 32) ))
		(2 to toN).foreach(k => 
			if ((nums(k / 32) & (1 << (k % 32))) == 0) 
				primes += k)
		primes
		
	}

}