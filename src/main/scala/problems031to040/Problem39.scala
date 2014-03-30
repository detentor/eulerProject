package problems031to040

import scala.collection.mutable.ListBuffer

//If p is the perimeter of a right angle triangle with integral length sides, 
//{a,b,c}, there are exactly three solutions for p = 120.
//
//{20,48,52}, {24,45,51}, {30,40,50}
//
//For which value of p <= 1000, is the number of solutions maximised?
object Problem39 
{
	def main(args: Array[String]) 
	{
		//Percorre todos os casos possíveis
		val maxPer = 1000
		
		val res = for (per <- 1 to maxPer; a <- 1 to per / 2; b <- (a + 1) to per / 2; 
							val c = per - (a + b); if (a*a + b*b == c*c))
				  yield Tuple4(a, b, c, per)
		
		println(res.groupBy( _._4).maxBy(_._2.size))
	}

}