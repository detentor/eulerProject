package problems051to060

//It is possible to show that the square root of two can be expressed as an infinite continued fraction.
//
// 2 = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...
//
//By expanding this for the first four iterations, we get:
//
// 1 + 1/2 = 3/2 = 1.5
// 1 + 1/(2 + 1/2) = 7/5 = 1.4
// 1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...
// 1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...
//
//The next three expansions are 99/70, 239/169, and 577/408, but the eighth expansion, 
//1393/985, is the first example where the number of digits in the numerator exceeds the number of digits in the denominator.
//
//In the first one-thousand expansions, how many fractions contain a numerator with more digits than denominator?

object Problem57 
{
	implicit def intToFraction(x : BigInt) = Fraction(x, 1)
	
	def main(args: Array[String]) 
	{
		def infFraction(expansion : Fraction) : Stream[Fraction] = (BigInt(1) + BigInt(1) / expansion) #:: infFraction(BigInt(2) + BigInt(1) / expansion)
		val cont = BigInt(2) + Fraction(1, 2)
		
		val n = 1000
		
		println(infFraction(cont).take(n - 1).filter(k => k.numerator.toString.size > k.denominator.toString.size).size)
	}
	
	case class Fraction(val numerator : BigInt, val denominator : BigInt)
	{
		def +(that : BigInt) : Fraction = this + Fraction(that, 1)
		
		def +(that : Fraction) = 
		{
			val gcd = lcd(this.denominator, that.denominator)
			Fraction( (gcd / denominator) * numerator + (gcd / that.denominator) * that.numerator, gcd)
		}
		
		def /(that : Fraction) = Fraction(this.numerator * that.denominator, this.denominator * that.numerator)
		
		override def toString = numerator + "/" + denominator
		
		private def lcd(x : BigInt, y : BigInt, acc : BigInt = 1) : BigInt = 
		{
			if (x == y && x == 1) acc
			else
			{
				val theGcd = x.gcd(y)
				val gcd = if (theGcd == 1) x.max(y) else theGcd
				lcd( BigInt(1).max(x / gcd), BigInt(1).max(y / gcd), acc * gcd)
			}
		}
	}
	

}