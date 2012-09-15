package problems41to50

//The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, 
//is unusual in two ways: (i) each of the three terms are prime, and, (ii) 
//each of the 4-digit numbers are permutations of one another.
//
//There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, 
//exhibiting this property, but there is one other 4-digit increasing sequence.
//
//What 12-digit number do you form by concatenating the three terms in this sequence?
import numbers._

object Problem49
{
	def main(args: Array[String]) 
	{
		val primeRange = primes.dropWhile(_ < 1000).takeWhile(_ < 10000).toSet

		val thePrimes = primeRange.filter(x => primeRange.intersect(x.toString.permutations.map(_.toLong).toSet).size > 2)
								  .map(_.toString.permutations.map(_.toLong).toSet.intersect(primeRange).toList.sortWith(_ > _))

		val result = thePrimes.flatMap(primeTest)
							  .map(list => List(list.head, list.head - list.last, list.head - list.last * 2)
							  			.reverse.mkString)

		println(result)
	}
	
	def primeTest(theList : List[Long]) : Option[List[Long]] = 
	{
		if (theList.size < 2) None
		else 
		{
			val dist = theList.tail.map(k => theList.head - k)
			val resp = dist.find(k => dist.exists(m => m == 2 * k))

			if (resp.isEmpty)
				primeTest(theList.tail)
			else
				Some(List(theList.head, resp.get))
		}
	}
}
