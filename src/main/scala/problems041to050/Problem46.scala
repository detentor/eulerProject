package problems041to050

import scala.collection.mutable.ArrayBuffer

//It was proposed by Christian Goldbach that 
//every odd composite number can be written as the sum of a prime and twice a square.
//
//9 = 7 + 2 * 1 ^ 2
//15 = 7 + 2 * 2 ^ 2
//21 = 3 + 2 * 3 ^ 2
//25 = 7 + 2 * 3 ^ 2 
//27 = 19 + 2 * 2 ^ 2
//33 = 31 + 2 * 1 ^2
//
//It turns out that the conjecture was false.
//
//What is the smallest odd composite that cannot 
//be written as the sum of a prime and twice a square?
object Problem46 
{
	def main(args: Array[String]) 
	{
		val primeList = new ArrayBuffer[Int]
		primeList += 2
		
		var i = 1
		var cont = true
		
		while (cont)
		{
			i += 2
			if (primeList.view.takeWhile(x => x * x <= i).forall(i % _ > 0))
			{
				primeList += i
			}
			else
			{
				cont = primeList.view.takeWhile(_ < i).reverseIterator.exists(k => 
				{
					val theSqr = math.sqrt((i - k) / 2).toInt
					k + 2 * (theSqr * theSqr) == i
				})
			}
		}
		println("resposta: " + i)
	}
}