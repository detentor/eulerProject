package problems051to060

//There are exactly ten ways of selecting three from five, 12345:
//
//123, 124, 125, 134, 135, 145, 234, 235, 245, and 345
//
//In combinatorics, we use the notation, 5C3 = 10.
//
//In general,
//
//nCr =	        n!
//        -----------
//         r!(n - r)!
//,where r <= n, n! = n * (n - 1)...3 * 2 * 1, and 0! = 1.
//It is not until n = 23, that a value exceeds one-million: 23C10 = 1144066.
//
//How many, not necessarily distinct, values of  nCr, for 1 <= n <= 100, are greater than one-million?
object Problem53 
{
	def main(args: Array[String]) 
	{
		def factorial(x : BigInt) = (BigInt(1) to x).product
		def combination(n : BigInt, r : BigInt) = factorial(n) / (factorial(r) * factorial(n - r))
		
		val combs = for (n <- 1 to 100; r <- 1 to n; 
						val comb = combination(n, r); if comb > 1000000) yield comb
		println(combs.size)
	}
}
