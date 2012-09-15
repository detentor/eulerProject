package problems31to40

import scala.collection.mutable.ListBuffer

//The fraction 49/98 is a curious fraction, as an inexperienced mathematician 
//in attempting to simplify it may incorrectly believe that 49/98 = 4/8, 
//which is correct, is obtained by cancelling the 9s.
//
//We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
//
//There are exactly four non-trivial examples of this type of fraction, 
//less than one in value, and containing two digits in the numerator and denominator.
//
//If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
object Problem33 
{
	def main(args: Array[String]) 
	{
		val fractions = for(i <- 11 to 99; j <- 11 to 99; 
							if (i / j.toDouble < 1.0d) && 
							(i % 10) == (j / 10) &&
							(i / 10) / (j % 10).toDouble == i.toDouble / j)
						yield (i, j)
		
		val lastFrac = fractions.reduce((f1, f2) => (f1._1 * f2._1, f1._2 * f2._2))
		println(lastFrac._2 / lastFrac._1)
	}

}