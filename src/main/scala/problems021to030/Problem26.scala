package problems021to030

import scala.collection.mutable.ListBuffer

//A unit fraction contains 1 in the numerator. 
//The decimal representation of the unit fractions with denominators 2 to 10 are given:
//
//1/2	= 	0.5
//1/3	= 	0.(3)
//1/4	= 	0.25
//1/5	= 	0.2
//1/6	= 	0.1(6)
//1/7	= 	0.(142857)
//1/8	= 	0.125
//1/9	= 	0.(1)
//1/10	= 	0.1
//Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. 
//It can be seen that 1/7 has a 6-digit recurring cycle.
//
//Find the value of d <= 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
object Problem26 
{
	def main(args: Array[String]) 
	{
		case class Division(num : Int, val deno : Int)
		{
			val divisionList = new ListBuffer[Tuple2[Int, String]]
			private var remainder = num
			private var isRecurring = false
			
			def getRecurringSize = 
			{
				var resp = getNextItem
				while(resp < 0) { resp = getNextItem }
				
				if (remainder == 0) 0
				else divisionList.length - resp
			}
			
			private def getNextItem = 
			{
				if (remainder == 0) 0
				else
				{
					val t = divisionList.indexWhere(t => t._1 == remainder) 
					
					if (t > -1) t
					else
					{
						val startNum = remainder
						var nextNum = remainder
						var zeroes = new StringBuilder
						
						nextNum *= 10
						
						while (nextNum < deno)
						{
							nextNum *= 10
							zeroes += '0'
						}
						
						remainder = nextNum % deno
						zeroes ++= (nextNum / deno).toString
						divisionList += Tuple2(startNum, zeroes.toString)
						-1
					}
				}
			}
		}

		val nums = (2 to 1000).map(x => Division(1, x)).sortWith(_.getRecurringSize > _.getRecurringSize)
		
		println(nums.head + " " + nums.head.getRecurringSize)
		
		//10 / 2 = 5
		//10 / 3 = 3 / 1
		
		//nums.map( k => (k, k._2.distinct)).filter(_._2.size > 8) foreach println
		
  
	}
	
	

}