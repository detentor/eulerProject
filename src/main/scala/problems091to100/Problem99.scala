package problems091to100

//Comparing two numbers written in index form like 2^11 and 3^7 is not difficult, 
//as any calculator would confirm that 211 = 2048  37 = 2187.
//
//However, confirming that 632382^518061  519432^525806 
//would be much more difficult, as both numbers contain over three million digits.
//
//Using base_exp.txt (right click and 'Save Link/Target As...'), 
//a 22K text file containing one thousand lines with a base/exponent 
//pair on each line, determine which line number has the greatest numerical value.
//
//NOTE: The first two lines in the file represent the numbers in the example given above.
import io._
object Problem99 
{
	def main(args: Array[String]) 
	{
		case class ExpNum(baseValue : Int, exp : Int)
		{
			def getDigitSize = exp * math.log(baseValue)
		}

		val text = loadFile("src/resource/problem99.txt").split(System.getProperty("line.separator"))
		val numList = text.map(str => ExpNum(str.split(",").head.toInt, str.split(",").last.toInt))

		val resp = numList.zipWithIndex.maxBy( _._1.getDigitSize)
		
		println(resp._2 + 1)
		
	}

}