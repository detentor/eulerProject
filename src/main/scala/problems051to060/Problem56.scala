package problems051to060

//A googol (10 ^ 100) is a massive number: one followed by one-hundred zeros; 100 ^ 100 
//is almost unimaginably large: one followed by two-hundred zeros. 
//Despite their size, the sum of the digits in each number is only 1.
//Considering natural numbers of the form, a ^ b, where a, b < 100, what is the maximum digital sum?
object Problem56 
{
	def main(args: Array[String]) 
	{
		println((for(a <- 1 until 100; b <- 1 until 100) 
					yield BigInt(a).pow(b).toString.map(_ - 48).sum).max)
	}

}