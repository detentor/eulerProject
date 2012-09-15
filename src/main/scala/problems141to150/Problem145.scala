package problems141to150

//Some positive integers n have the property that the sum [ n + reverse(n) ] 
//consists entirely of odd (decimal) digits. 
//For instance, 36 + 63 = 99 and 409 + 904 = 1313. 
//We will call such numbers reversible; so 36, 63, 409, and 904 are reversible. 
//Leading zeroes are not allowed in either n or reverse(n).
//
//There are 120 reversible numbers below one-thousand.
//
//How many reversible numbers are there below one-billion (109)?
import numbers._
object Problem145 
{
	def main(args: Array[String]) 
	{
		def isReversibleFast(n : Int) = 
		{
			if (n % 10 == 0) false
			else
			{
				val revNum = n.toString.toArray
					.foldLeft((0, 1))((x, y) => (x._1 + (y - 48) * x._2, x._2 * 10))._1
				
				if (revNum > n) false
				else (revNum + n).toString.toArray.forall(_ % 2 > 0)
			}
		}
		
		val maxBound = 1000000000 //1000000000
		var curIndex = 0
		var reversibles = 0
		
		registerTime(
		while (curIndex <= maxBound)
		{
			curIndex +=1
			
			if (curIndex % 500000 == 0) println(curIndex);
			if (isReversibleFast(curIndex)) reversibles += 2
		}
		)
		
		println(reversibles)
		
		//608720 //1308395 ms
	}

}