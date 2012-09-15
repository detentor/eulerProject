package problems11to20

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.ArrayBuffer


//The following iterative sequence is defined for the set of positive integers:
//n ->  n/2 (n is even)
//n ->  3n + 1 (n is odd)
//Using the rule above and starting with 13, we generate the following sequence:
//13  40  20  10  5  16  8  4  2  1
//It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. 
//Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
//Which starting number, under one million, produces the longest chain?
//NOTE: Once the chain starts the terms are allowed to go above one million.
object Problem14 
{
	def main(args: Array[String]) 
	{
		val startTime = System.currentTimeMillis
		val result = greaterCollatz(1000000)
		println ("Sequência com maior tamanho : " + result._1 + ". Tamanho : " + result._2.size)
		println("Demorou " + (System.currentTimeMillis - startTime) + " milis")
	}
	
	def greaterCollatz(x : Long) : Tuple2[Long, Iterable[Long]] = 
	{
		var greater = (1L, genCollatz(1))
		
		for (k <- 2L to x)
		{
			val curCollatz = genCollatz(k)
			if (curCollatz.size > greater._2.size)
			{
				greater = (k, curCollatz)
			}
		}
		return greater
	}
	
	def genCollatz(x : Long) = 
	{
		val lb = ArrayBuffer.empty[Long]
		var number = x
		
		while (number != 1)
		{
			lb += number
			number = if (number % 2 == 0) number/2 else (3*number + 1)
		}
		lb
	}

}