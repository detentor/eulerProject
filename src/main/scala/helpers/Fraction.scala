package helpers

//Need implicit to work correctly with the operators
//implicit def intToFraction(x : BigInt) = Fraction(x, 1)

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