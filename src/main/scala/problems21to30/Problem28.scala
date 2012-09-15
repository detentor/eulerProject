package problems21to30

//Starting with the number 1 and moving to the right 
//in a clockwise direction a 5 by 5 spiral is formed as follows:
//
//									21 22 23 24 25
//									20  7  8  9 10
//									19  6  1  2 11
//									18  5  4  3 12
//									17 16 15 14 13
//
//It can be verified that the sum of the numbers on the diagonals is 101.
//
//What is the sum of the numbers on the diagonals
//in a 1001 by 1001 spiral formed in the same way?
object Problem28 
{
	def main(args: Array[String]) 
	{
		val spiralSize = 1001
		
		var curN = 1
		var diag1 = 1
		var diag2 = 0
		
		while (curN < spiralSize)
		{
			curN += 2
			val predSquare = (curN - 1) * (curN - 1)
			diag1 = diag1 + (curN * curN) + (((curN - 2) * (curN - 2) + 1) + (curN - 1) * 2 - 1)  
			diag2 = diag2 + (predSquare - (curN - 2)) + (curN * curN - (curN - 1)) 
		}
		println(diag1 + diag2)
	}

}