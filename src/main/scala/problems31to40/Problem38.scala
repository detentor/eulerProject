package problems31to40

object Problem38 
{
	def main(args: Array[String]) 
	{
		//As n > 1, the limit is 9 / 2 = 4 digits(10000), since 10000 + 20000 = 10 digits
		val result = (1 to 10000)
			.map(x => (x, Stream.from(1).scanLeft("")((m, n) => m + (x * n).toString).takeWhile(_.size <= 9).force.last))
			.filter(tuple => tuple._2.size == 9 && (1 to tuple._2.size).forall(y => tuple._2.contains(y.toString)))
			.map(_._2.toLong)
		
		println(result.max)
		
		//932718654 SOLVED!
	}

}