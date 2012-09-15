package problems41to50

//The first two consecutive numbers to have two distinct prime factors are:
//14 = 2  7
//15 = 3  5
//The first three consecutive numbers to have three distinct prime factors are:
//644 = 2² * 7 *  23
//645 = 3 * 5 * 43
//646 = 2 * 17 * 19.
//Find the first four consecutive integers to have four distinct primes factors. What is the first of these numbers?

import numbers._
import scala.collection.mutable.Buffer
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.ArrayBuffer

object Problem47 
{
	def main(args: Array[String]) 
	{
		var prevItems = List.empty[Tuple2[Int, Buffer[Int]]]
		val amount = 4
		
		var curNumber = 2
		while (getPrimeDivisors(curNumber).size < amount) curNumber += 1
		
		prevItems = (curNumber, getPrimeDivisors(curNumber)) :: prevItems
		curNumber += 1
		
		while (curNumber > 0)
		{
			val divisors = getPrimeDivisors(curNumber)

			if (isDistinct(amount, divisors, prevItems))
			{
				prevItems = (curNumber, divisors) :: prevItems
				
				if (prevItems.size == amount)
				{
					curNumber = -1
				}
			}
			else
			{
				prevItems = (curNumber, divisors) :: Nil
			}
			
			curNumber += 1 
			println(curNumber)
		}
		
		prevItems foreach println
	}
	
	def isDistinct(amount : Int, thisList : Buffer[Int], prevItems : List[Tuple2[Int,Buffer[Int]]]) = 
	{
		prevItems.head._2.size == amount && thisList.size == amount && thisList.forall(x => !prevItems.head._2.contains(x))
	}

}