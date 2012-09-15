
object Problem
{
	def main(args: Array[String]) 
	{
		def isSquarePerfect(x : Long) = 
		{
			val k = math.sqrt(x).toInt
			k * k == x
		}
		
		import math._
		def cubeRoot(x : BigInt) = BigInt(floor(exp(log(x.doubleValue) / 2)).toLong)
		
		def squareStream(fromX : Long) : Stream[Long] = (fromX * fromX) #:: squareStream(fromX + 1) 
		
		val num = "1_2_3_4_5_6_7_8_9_0"
		val numL = num.sliding(1, 2).toList
		
		var start = ceil(sqrt(num.replaceAll("_", "0").toLong)).toLong
		var curNum = start * start
		
		while (curNum.toString.sliding(1, 2).toList != numL)
		{
			println(curNum)
			start += 1
			curNum = start * start
		}

//		val t = squareStream(start).find(k => {println(k); k.toString.sliding(1, 2).toList == numL })
		
		println(start)
		
//		println(num.toString.sliding(1, 2).toList == "1021324354657688990".sliding(1, 2).toList)
		
		
//		800.000.000
  
	}

}