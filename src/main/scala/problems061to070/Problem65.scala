package problems061to070

import helpers.Fraction

//The square root of 2 can be written as an infinite continued fraction.2 = 1 +	1
//
// 	2 +	1
//
// 	 	2 +	1
//
// 	 	 	2 +	1
//
// 	 	 	 	2 + ...
//
//
//The infinite continued fraction can be written, 2 = [1;(2)], 
//(2) indicates that 2 repeats ad infinitum. In a similar way, 23 = [4;(1,3,1,8)].
//
//It turns out that the sequence of partial values of continued fractions 
//for square roots provide the best rational approximations. Let us consider the convergents for 2.1 +	1
//	= 3/2
// 	2	 
//1 +	1
//	= 7/5
// 	2 +	1
//
// 	 	2	 
//1 +	1
//	= 17/12
// 	2 +	1
//	 
// 	 	2 +	1
//	 
// 	 	 	2	 
//1 +	1
//	= 41/29
// 	2 +	1
//
// 	 	2 +	1
//	 
// 	 	 	2 +	1
//	 
// 	 	 	 	2	 
//
//
//Hence the sequence of the first ten convergents for 2 are:
//1, 3/2, 7/5, 17/12, 41/29, 99/70, 239/169, 577/408, 1393/985, 3363/2378, ...
//
//What is most surprising is that the important mathematical constant,
//e = [2; 1,2,1, 1,4,1, 1,6,1 , ... , 1,2k,1, ...].
//
//The first ten terms in the sequence of convergents for e are:
//2, 3, 8/3, 11/4, 19/7, 87/32, 106/39, 193/71, 1264/465, 1457/536, ...
//
//The sum of digits in the numerator of the 10th convergent is 1+4+5+7=17.
//
//Find the sum of digits in the numerator of the 100th convergent of the continued fraction for e.
object Problem65 
{
	def main(args: Array[String]) 
	{
		implicit def intToFraction(x : BigInt) = Fraction(x, 1)
		
		
		def infFraction(expansion : Fraction, frac : List[BigInt]) : Stream[Fraction] = 
		{
			(BigInt(1) + expansion) #:: 
				infFraction(expansion.numerator /
						(expansion.denominator + Fraction(1, frac.head)), frac.tail ::: frac.head :: Nil  )
		}

//		val cont = BigInt(1) + Fraction(1, 2)
//		
//		val n = 1000
		
		println(infFraction(Fraction(1,2), List(2))take(10) force )
		
//		println(infFraction(cont).take(n - 1).filter(k => k.numerator.toString.size > k.denominator.toString.size).size)
		
//		2.718281828459045;
		
		
  
	}

}