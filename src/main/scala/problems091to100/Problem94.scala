package problems091to100

import scala.collection.mutable.HashMap

//It is easily proved that no equilateral triangle exists with integral 
//length sides and integral area. However, the almost 
//equilateral triangle 5-5-6 has an area of 12 square units.
//
//We shall define an almost equilateral triangle to be a 
//triangle for which two sides are equal and the third differs by no more than one unit.
//
//Find the sum of the perimeters of all almost equilateral 
//triangles with integral side lengths and area and whose 
//perimeters do not exceed one billion (1,000,000,000).
object Problem94 
{
	def main(args: Array[String]) 
	{
		def sqrStream(start : Long) : Stream[Tuple2[Long,Long]] = (start * start, start) #:: sqrStream(start + 1)
		
		var sqrList = sqrStream(1)
		
		def getSqr(x : Long) = 
		{
			val lastElem = sqrList.dropWhile(_._1 < x)
			sqrList = lastElem
			if (lastElem.take(1).head._1 == x) Some(lastElem.take(1).head._2) else None
		}
		
//		def getArea(equalSide : Long, greatersize : Long) = 
//		{
//			val sqrResult = getSqr((4L * equalSide * equalSide) - (greatersize * greatersize))
//			
//			if (sqrResult.isEmpty) false
//			else
//			{
//				val nextResult = BigDecimal(sqrResult.get * greatersize) / 4d
//				nextResult.toBigIntExact.isDefined
//			}
//			
////			sqrResult.isDefined && ((sqrResult.get * greatersize) / 4d).isWhole
////			(math.sqrt( (4L * equalSide * equalSide) - (greatersize * greatersize)) * greatersize) / 4d
//		}
		
		def getArea(equalSide : Long, greatersize : Long) = 
		{
			val bigDec = (BigDecimal(equalSide * equalSide) / BigDecimal(greatersize * greatersize)) - BigDecimal(1/4d)
			
				val sqrResult = math.sqrt(bigDec.toDouble)
				(BigDecimal(greatersize * greatersize * sqrResult) * 0.5d).toBigIntExact.isDefined
		}
		
		//Dá estouro de memória
//		def from(n : Long) : Stream[Long] = n #:: from(n + 1)
//		
//		val k = from(1).takeWhile(_ * 3 + 1 < 1000000000L)
//					   .filter(k => integralArea(k, k + 1))
//					   .scanLeft(0L)(_ + _ * 3 + 1)
//		
//		println(k.force);
		//
		
		val startTime = System.currentTimeMillis
		
		var i = 2L
		var count = i * 3 + 1
		var curSum = 0L
		
		while (count <= 1000000000L)
		{
			if (i % 10000000 == 0) println(i)
			
			val area1 = getArea(i, i + 1)
			if (area1) 
			{
//				println("acertou para área " + i + " " + count)
				curSum += count
			}
			
			i += 1
			count = i * 3 + 1
		}
		
		println(curSum) //156264743725559352
		
		
		println(getArea(5, 6))
		
		println(System.currentTimeMillis - startTime);
	}

}