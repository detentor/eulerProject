package problems31to40

//We shall say that an n-digit number is pandigital if it makes use of all 

//the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.
//
//The product 7254 is unusual, as the identity, 39 * 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.
//
//Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
//HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
import numbers._
object Problem32 
{
	def main(args: Array[String]) 
	{
		//As n > 1, the limit is 9 / 2 = 4 digits(10000), since 10000 + 20000 = 10 digits
		val result = for (i <- 1 until 100; j <- i until 9999; 
						  val temp = i.toString + j + (i*j); 
					  	  if (temp.size == 9 && temp.distinct.size == 9 && !temp.contains("0"))) 
					 yield (i * j)
		
		println(result.distinct.sum)
		//45228
	}

}