package problems121to130

//The palindromic number 595 is interesting because it can be 
//written as the sum of consecutive squares: 6^2 + 7^2 + 8^2 + 9^2 + 10^2 + 11^2 + 12^2.
//
//There are exactly eleven palindromes below one-thousand that can be written as 
//consecutive square sums, and the sum of these palindromes is 4164. 
//Note that 1 = 0^2 + 1^2 has not been included as this problem 
//is concerned with the squares of positive integers.
//
//Find the sum of all the numbers less than 10^8 that are both palindromic and can be written as the sum of consecutive squares.
object Problem125 
{
	def main(args: Array[String]) 
	{
		def isPalindrome(x : Int) = x.toString.reverse == x.toString
		
		def findPalindromes(streamHead: Stream[Int], inStream : Stream[Int], palinList : List[Int], stop : Int) : List[Int] = 
		{
			if (inStream.foldRight(0)(_ + _) >= stop) palinList
			else
			{
				val nextItem = inStream.take(1)
				
				if (isPalindrome(inStream.foldRight(0)(_ + _)))
					findPalindromes(streamHead, nextItem, nextItem.head :: palinList, stop)
				else
					findPalindromes(streamHead.take(1), nextItem, nextItem.head :: palinList, stop)
			}
			
		}
		
		def squareStream(n : Int) : Stream[Int] = (n * n) #:: squareStream(n + 1)
		
		
		val numbers = squareStream(2)
		numbers take 4 foreach println
		
  
	}
	

}