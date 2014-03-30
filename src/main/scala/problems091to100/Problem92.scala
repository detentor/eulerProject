package problems091to100

import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.HashMap
import scala.collection.mutable.ListBuffer

//A number chain is created by continuously adding the 
//square of the digits in a number to form a new number until it has been seen before.
//
//For example,
//
//44 -> 32 -> 13 -> 10 ->  1 ->  1
//85 -> 89 -> 145 -> 42 -> 20 ->  4 -> 16 -> 37 -> 58 -> 89
//
//Therefore any chain that arrives at 1 or 89 will become stuck 
//in an endless loop. 
//What is most amazing is that EVERY starting number will eventually arrive at 1 or 89.
//
//How many starting numbers below ten million will arrive at 89?
object Problem92 
{
	def main(args: Array[String]) 
	{
		val countChain = new Array[Int](600)
		var startNum = 1
		
		val startTime = System.currentTimeMillis
		
		//Pre-caching common results
		while (startNum < 600)
		{
			var curNum = startNum
			
			while (curNum != 89 && curNum != 1)
				curNum = next(curNum)
			
			countChain(startNum) = curNum
			startNum +=1
		}
		//
		
		var counter = 0
		
		startNum = 1
		while (startNum < 10000000)
		{
			var curNum = countChain(next(startNum))
			if (curNum == 89) counter += 1
			startNum +=1
		}
		
		println(counter) //8581146
		println(System.currentTimeMillis - startTime)
	}
	
	def next(n : Int) = 
	{
		var k = n
		var theSum = 0
		while (k > 0)
		{
			theSum += (k % 10) * (k % 10)
			k /= 10
		}
		theSum
	}
	
}