package problems041to050

//The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
// Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.

import numbers._

object Problem48 
{
	def main(args: Array[String]) 
	{
		println((1 to 1000).map( x => BigInt(x).pow(x)).sum.toString.takeRight(10))
	}

}