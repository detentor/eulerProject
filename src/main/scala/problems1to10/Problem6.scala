package problems1to10

import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Buffer

//The sum of the squares of the first ten natural numbers is,
//1² + 2² + ... + 10² = 385

//The square of the sum of the first ten natural numbers is,
//(1 + 2 + ... + 10)² = 552 = 3025

//Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 - 385 = 2640.
//Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
object Problem6
{
	def main(args: Array[String]) 
	{
		val lista = 1 to 100
		
		val sumOfSquares = lista.foldLeft(0L)(_ + dup(_))
		val squareOfSum = dup(lista.foldLeft(0L)(_ + _))
		
		println("Sum of Squares " + sumOfSquares)
		println("Square of the Sum " + squareOfSum)
		
		println("Difference : " + (squareOfSum - sumOfSquares))
	}
	
	def dup(x : Long) = math.pow(x, 2).longValue
}