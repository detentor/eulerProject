package problems111to120

//Working from left-to-right if no digit is exceeded by 
//the digit to its left it is called an increasing number; for example, 134468.
//
//Similarly if no digit is exceeded by the digit to 
//its right it is called a decreasing number; for example, 66420.
//
//We shall call a positive integer that is neither 
//increasing nor decreasing a "bouncy" number; for example, 155349.
//
//As n increases, the proportion of bouncy numbers below n 
//increases such that there are only 12951 numbers 
//below one-million that are not bouncy and only 277032 non-bouncy numbers below 10^10.
//
//How many numbers below a googol (10 ^ 100) are not bouncy?
import numbers._

object Problem113 
{
	def main(args: Array[String]) 
	{
		def isIncreasing(n : Int) = n.toString.sorted.mkString.toInt == n
		def isDecreasing(n : Int) = n.toString.sortWith(_ > _).mkString.toInt == n
		def isBouncy(n : Int) = !isIncreasing(n) && !isDecreasing(n)
		
		var curBouncys = 0
		var curIndex = 0
		
		val maxBound = 1000000
		
//		10.000.000.000
		
		registerTime( BigInt(10).pow(100) )
		
//		while (curIndex  <= maxBound)
//		{
//			if (isBouncy(curIndex)) curBouncys += 1
//			curIndex += 1
//		}
		println(maxBound - curBouncys)
		
		println(BigInt(10).pow(100))
		
		//Increasing:
		
		//99:
		
		//00
		//01
		//02
		
		//0 [10]
		//1 9
		//2 8
		//3 7
		//4 6
		//5 5
		//6 4
		//7 3
		//8 2
		//9 1
		
		//999
		//0 0 0 [10]
		//0 1 1 [9]
		//0 2 2 [8]
		//0 3 3 [7]
		//0 4 4 [6]
//		...
		//1 1 1 [9]
		//1 2 2 [8]
		
		//55
		
  
	}

}