package problems61to70

//The cube, 41063625 (345^3), can be permuted to produce two other cubes: 
//56623104 (384^3) and 66430125 (405^3). In fact, 41063625 
//is the smallest cube which has exactly three permutations of its digits which are also cube.
//Find the smallest cube for which exactly five permutations of its digits are cube.
object Problem62 
{
	def main(args: Array[String]) 
	{
		def ofSize(x : Int) : Stream[Stream[BigInt]] =
		{
			def from(x : BigInt) : Stream[BigInt] = x.pow(3) #:: from(x + 1)
			val lowerBound = BigInt(10).pow(x - 1)
			val higherBound = BigInt(10).pow(x)
			from(1).dropWhile(_ < lowerBound).takeWhile(_ < higherBound) #:: ofSize(x + 1)
		}

		val answer = for (str <- ofSize(4); val permMap = str.groupBy(k => k.toString.sorted)
										 					 .filter(k => k._2.size == 5)
										 	if permMap.nonEmpty) 
				     yield permMap
		
		println(answer.take(1).head.minBy(_._2.min)._2.head)
		
	}
}