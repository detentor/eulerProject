package problems031to040

//The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.
//
//Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
//
//(Please note that the palindromic number, in either base, may not include leading zeros.)
object Problem36 
{
	def main(args: Array[String]) 
	{
		def isPalindromic(x : Any) = x.toString == x.toString.reverse
		def doublePalindromic(x : Int) = isPalindromic(x) && isPalindromic(BigInt(x).toString(2))

		println((1 to 1000000).filter(doublePalindromic).sum)
	}

}