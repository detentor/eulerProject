package problems1to10

import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Buffer

//2520 is the smallest number that can be divided by each of the 
//numbers from 1 to 10 without any remainder.
//What is the smallest positive number that 
//is evenly divisible by all of the numbers from 1 to 20?
object Problem5
{
	def main(args: Array[String]) 
	{
		val number = 2 to 20
		val lb = new ListBuffer[Int]
		
		number.foreach(x => 
		{
			val result = addItem(x, lb)
			
			if (! result.isEmpty)
			{
				lb += result.get
			}
		})
		println(lb.foldLeft(1)(_ * _)) //232792560
	}
	
	def addItem(x : Int, inList : Buffer[Int]) = 
	{
		var divided = x
		
		inList.foreach(k =>
		{
			if (divided % k == 0)
			{
				divided = divided / k
			}
		})
		
		if (divided == 1) None else Some(divided)
	}
	

}