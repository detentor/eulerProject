package problems21to30

import scala.collection.mutable.ArrayBuffer

//Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
// If d(a) = b and d(b) = a, where a != b, then a and b are an amicable pair and each of a and b are called amicable numbers.

//For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; 
//therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
//Evaluate the sum of all the amicable numbers under 10000.
object Problem21
{
	def main(args: Array[String]) 
	{
		val amicables = (1 until 10000).filter(isAmicable)
		println(amicables)
		println(amicables sum)
	}
	
	def isAmicable(x : Int) = 
	{
		val sumA = getDivisors(x) sum
		val sumB = getDivisors(sumA) sum
		
		sumB == x && x != sumA
	}
	
	def getDivisors(x : Int) = (1 to x /2).filter(x % _ == 0)

}