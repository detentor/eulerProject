package problems071to080

import scala.collection.mutable.ListBuffer
import scala.collection.mutable.ArrayBuffer

//A common security method used for online banking is to ask 
//the user for three random characters from a passcode. 
//For example, if the passcode was 531278, they may ask 
//for the 2nd, 3rd, and 5th characters; the expected reply would be: 317.
//
//The text file, keylog.txt, contains fifty successful login attempts.
//
//Given that the three characters are always asked for in order, 
//analyse the file so as to determine the shortest possible secret passcode of unknown length.
object Problem79 
{
	def main(args: Array[String]) 
	{
		val data = ("129 160 162 168 180 289 290 316 318 319 362 368 380 389 620 629 680 " +
					   		"689 690 710 716 718 719 720 728 729 731 736 760 762 769 790 890").split(" ")
		
		val codeLength = data.mkString.distinct.size //size of distinct elements
		
		val passcode = ArrayBuffer.empty[String]
		val fistElems = data.map(_.head.toString).toList
		
		while (passcode.size < codeLength)
		{
			val nums = (fistElems :::
					    data.foldLeft(List.empty[String])((x, y) => {
						   val pos = y.indexOf(if (passcode.isEmpty) "" else passcode.last)
						   if (pos > -1 && pos < (y.size - 1)) y.charAt(pos + 1).toString :: x else x
					   })).distinct.filterNot(k => passcode.contains(k))
			
			passcode += nums.find(num => data.forall(str2 => 
							{ 
								val pos = str2.indexOf(num)
								pos < 1 || str2.take(pos).forall(c => passcode.contains(c.toString))
							})).get
		}
		println(passcode mkString) //73162890
	}

}