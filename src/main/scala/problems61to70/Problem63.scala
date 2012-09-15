package problems61to70

import scala.collection.mutable.ListBuffer
import scala.annotation.tailrec

//The 5-digit number, 16807=7^5, is also a fifth power. Similarly, the 9-digit number, 134217728=8^9, is a ninth power.
//
//How many n-digit positive integers exist which are also an nth power?
object Problem63 
{
	def main(args: Array[String]) 
	{
//		def powStream(n : BigInt, times : Int) : Stream[BigInt] = n.pow(times) #:: powStream(n + 1, times)
//		
//		val answer = Stream.from(1).map(curPower => powStream(2, curPower)
//						.takeWhile(_ < BigInt(10).pow(curPower))
//						.filter(_.toString.size == curPower).size)
//					.takeWhile(_ > 0).sum + 1
//		println(answer)
		
		
		//One-liner, copied from Haskell:
		val answer = for (a <- 1 to 10; b <- 1 to 50; if BigInt(a).pow(b).toString.size == b) yield 1
		println(answer.length)
	}
	
}