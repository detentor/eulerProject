package problems31to40

//145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
//
//Find the sum of all numbers which are equal to the sum of the factorial of their digits.
//
//Note: as 1! = 1 and 2! = 2 are not sums they are not included.

import numbers._

object Problem34
{
	def main(args: Array[String]) 
	{
		val factorials = (0 to 9).map(_.factorial.toInt).toArray
		println((3 to 9999999).filter(x => x == x.toDigit.foldLeft(0)((x, y) => x + factorials(y))).sum)
	}
}