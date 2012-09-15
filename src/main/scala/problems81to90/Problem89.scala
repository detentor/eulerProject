package problems81to90

import java.io.File
import java.io.FileInputStream

//The rules for writing Roman numerals allow for many ways of writing each number 
//(see About Roman Numerals...). However, there is always a "best" way of writing a particular number.
//
//For example, the following represent all of the legitimate ways of writing the number sixteen:
//
//IIIIIIIIIIIIIIII
//VIIIIIIIIIII
//VVIIIIII
//XIIIIII
//VVVI
//XVI
//
//The last example being considered the most efficient, as it uses the least number of numerals.
//
//The 11K text file, roman.txt (right click and 'Save Link/Target As...'), 
//contains one thousand numbers written in valid, but not necessarily minimal, 
//Roman numerals; that is, they are arranged in descending units and obey 
//the subtractive pair rule (see About Roman Numerals... for the definitive rules for this problem).
//
//Find the number of characters saved by writing each of these in their minimal form.
//
//Note: You can assume that all the Roman numerals in the file contain no more than four consecutive identical units.
import io._

object Problem89 
{
	def main(args: Array[String]) 
	{
		val text = loadFile("src/resource/problem89.txt")
		
		val initialSize = text.split(System.getProperty("line.separator")).foldLeft(0)(_ + _.size)
		
		val newSize = text.replaceAll("IIII", "IV")
					   	  .replaceAll("XXXX", "XL")
					   	  .replaceAll("CCCC", "CD")
					   	  .replaceAll("VIV", "IX")
					   	  .replaceAll("LXL", "XC")
					   	  .replaceAll("DCD", "CM")
					   	  .split(System.getProperty("line.separator"))
					   	  .foldLeft(0)(_ + _.size)
	  println(initialSize - newSize)
		
//		println(text.map(x => (x.size) - Roman(x).toRoman.size).sum)
	}
	
	case class Roman(fromStr : String)
	{
		val valMap = Map("M" -> 1000, "CM" -> 900, "D" -> 500, "CD" -> 400, "C" -> 100, 
						 "XC" -> 90, "L" -> 50, "XL" -> 40, "X" -> 10, "IX" -> 9, "V" -> 5, "IV" -> 4, "I" -> 1)
		val letterList = Vector((1000, "M"), (900, "CM"), (500, "D"), (400, "CD"), (100, "C"), (90, "XC"), 
								(50, "L"), (40, "XL"), (10, "X"), (9, "IX"), (5, "V"), (4, "IV"), (1, "I"))
		
		def getValue = 
		{
			def getValue(chars : String) : Int = 
			{
				if (chars.isEmpty) 0
				else
				{
					valMap.get(chars.take(2)) match
					{
						case Some(value) => value + getValue(chars.drop(2))
						case None => valMap.get(chars.take(1)).get + getValue(chars.drop(1))
					}
				}
			}
			getValue(fromStr)
		}
		
		def toRoman = 
		{
			def toRoman(curVal : Int, curIndex : Int, curAnswer : String) : String = 
			{
				if (curVal == 0) curAnswer
				else
				{
					val curLetter = letterList(curIndex)
					if (curLetter._1 > curVal) toRoman(curVal, curIndex + 1, curAnswer)
					else
					{
						val numTimes = curVal / curLetter._1
						val nextVal = curVal - numTimes * curLetter._1
						toRoman(nextVal, curIndex, curAnswer + (1 to numTimes).map(k => curLetter._2).mkString)
					}
				}
			}
			toRoman(getValue, 0, "")
		}
	}

}