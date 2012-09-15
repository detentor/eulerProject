package problems11to20

import java.util.Calendar

//You are given the following information, but you may prefer to do some research for yourself.
//1 Jan 1900 was a Monday.
//Thirty days has September,
//April, June and November.
// All the rest have thirty-one,
//Saving February alone,
// Which has twenty-eight, rain or shine.
// And on leap years, twenty-nine.
//A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
//How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
object Problem19 
{
	def main(args: Array[String]) 
	{
		val cal = Calendar.getInstance
		
		//Inicializa a data fim
		cal.set(Calendar.DAY_OF_MONTH, 31)
		cal.set(Calendar.MONTH, 11)
		cal.set(Calendar.YEAR, 2000)
		val endDate = cal.getTime
		
		//Inicializa com a data
		cal.set(Calendar.DAY_OF_MONTH, 1)
		cal.set(Calendar.MONTH, 0)
		cal.set(Calendar.YEAR, 1901)
		
		var numSundays = 0
		
		while(cal.getTime.before(endDate))
		{
			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
			{
				numSundays += 1
			}
			cal.add(Calendar.MONTH, 1)
		}
		println(numSundays)
	}

}