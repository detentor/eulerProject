package problems71to80

import scala.collection.mutable.HashSet

//The number 145 is well known for the property that the 
//sum of the factorial of its digits is equal to 145:
//
//1! + 4! + 5! = 1 + 24 + 120 = 145
//
//Perhaps less well known is 169, in that it produces the longest chain
//of numbers that link back to 169; it turns out that there are only three such loops that exist:
//
// 169 -> 363601 -> 1454 -> 169
// 871 -> 45361 -> 871
// 872 -> 45362 -> 872
//
//It is not difficult to prove that EVERY starting number 
//will eventually get stuck in a loop. For example,
//
// 69 -> 363600 -> 1454 -> 169 -> 363601 -> 1454
// 78 -> 45360 -> 871 -> 45361 -> 871
// 540 -> 145 -> 145
//
//Starting with 69 produces a chain of five non-repeating terms, 
//but the longest non-repeating chain with a starting number below one million is sixty terms.
//
//How many chains, with a starting number below one million, contain exactly sixty non-repeating terms?
object Problem74 
{
	def main(args: Array[String]) 
	{
		val facMap = Map(0 -> 1, 1 -> 1, 2 -> 2, 3 -> 6, 4 -> 24, 
						 5 -> 120, 6 -> 720, 7 -> 5040, 8 -> 40320, 9 -> 362880)

		def factorial (x : Int) = facMap.get(x).get

		def calcChain(start : Long) =
		{
			def nextChain(x : Long) = x.toString.map(_ - 48).map(factorial).sum

			val chainSet = new HashSet[Long]
			chainSet += start
			var curChain = nextChain(start)

			while (!chainSet.contains(curChain))
			{
				chainSet += curChain
				curChain = nextChain(curChain)
			}
			chainSet.size
		}
		
		val k = Stream.from(1).takeWhile(_ < 1000000)
					  		  .filter(k => calcChain(k) == 60)
					  		  .size
		
		println(k)			  	
		
	}
	
}