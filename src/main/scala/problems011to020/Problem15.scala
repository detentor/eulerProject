package problems011to020

import scala.collection.mutable.ListBuffer
import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer
import com.sun.org.apache.xml.internal.serializer.ToStream

//Starting in the top left corner of a 2 x 2 grid, 
//there are 6 routes (without backtracking) to the bottom right corner.
//
//How many routes are there through a 20 x 20 grid?
object Problem15 
{
	def main(args: Array[String]) 
	{
		//Resolução Elegante, TOTALMENTE funcional:
//			val gridSize = 20
//			val numItems = (gridSize + 1) * (gridSize + 1)
//			val treeArr = (0 until numItems).map(i => new BTree(i.toString)).toArray
//	
//			def getArrPos(pos : Tuple2[Int, Int]) = pos._2 * (gridSize + 1) + pos._1
//			
//			for (y <- 0 to gridSize)
//			{
//				for (x <- 0 to gridSize)
//				{
//					if (x > 0) treeArr(getArrPos(x, y)).roots += treeArr(getArrPos(x - 1, y))
//					if (y > 0) treeArr(getArrPos(x, y)).roots += treeArr(getArrPos(x, y - 1))
//				}
//			}
//			
//			println(treeArr(treeArr.length - 1).roteCount) //137846528820
		//
		
		
		//Resolução super-rápida, usando o triângulo de PASCAL
		
			//		def nextPascal(fromList : List[Long]) = 1L :: fromList.sliding(2, 1).map(x => x.head + x.tail.head).toList ::: 1L :: Nil
			//		
			//		var i = 1
			//		var curList = List(1L, 1L)
			//		
			//		while (i < 40)
			//		{
			//			curList = nextPascal(curList)
			//			i += 1
			//		}
			//		println(curList(curList.size / 2))
		
		//
		
		//Resolução usando Stream (estoura com números muito grandes)
		def nextPascal(fromList : List[BigInt]) : Stream[List[BigInt]] = 
		{
			val k = (BigInt(1) :: fromList.sliding(2, 1).map(x => x.head + x.tail.head).toList ::: BigInt(1) :: Nil)
			k #:: nextPascal(k)
		}
			
		lazy val pascList : Stream[List[BigInt]] = List(BigInt(1), BigInt(1)) #:: nextPascal(pascList.head)
		
		val resp = pascList.drop(39).take(1).head
		println(resp(resp.size / 2))
		//
	}
}

//Binary tree
class BTree(val value : String, val roots : ListBuffer[BTree] = ListBuffer.empty[BTree])
{
	lazy val roteCount : BigInt = 
	{
		roots.toList match
		{
			case Nil => 1
			case x :: Nil => x.roteCount
			case x :: y :: Nil => x.roteCount + y.roteCount
			case _ => throw new IllegalArgumentException("tree with more than two roots")
		}
	}
	override def toString = value
}

