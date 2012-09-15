package problems21to30

import scala.collection.mutable.Buffer

//A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation 
//of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, 
//we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
//
//012   021   102   120   201   210
//
//What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
object Problem24 
{
	def main(args: Array[String]) 
	{
		println(permutation(999999, (0 to 9).toBuffer))
	}
	
	def permutation(nth : Int, numList : Buffer[Int]) : String = 
	{
		if (numList.isEmpty) "" 
		else if (numList.size == 1) numList.head.toString
		else
		{
			val curSum = factorial(numList.size - 1)
			val index = nth / curSum
			val removedItem = numList.remove(index)
			removedItem.toString + permutation(nth % curSum, numList)
		}
	}
	
	def factorial(x : Int) = (2 to x).foldLeft(1)(_ * _)
}