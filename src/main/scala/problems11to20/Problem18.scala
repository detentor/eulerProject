package problems11to20

import scala.collection.mutable.ListBuffer

//By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.
//    3
//   7 4
//  2 4 6
// 8 5 9 3
//
// That is, 3 + 7 + 4 + 9 = 23.
//
//Find the maximum total from top to bottom of the triangle below:
//
// 75
// 95 64
// 17 47 82
// 18 35 87 10
// 20 04 82 47 65
// 19 01 23 75 03 34
// 88 02 77 73 07 63 67
// 99 65 04 28 06 16 70 92
// 41 41 26 56 83 40 80 70 33
// 41 48 72 33 47 32 37 16 94 29
// 53 71 44 65 25 43 91 52 97 51 14
// 70 11 33 28 77 73 17 78 39 68 17 57
// 91 71 52 38 17 14 91 43 58 50 27 29 48
// 63 66 04 68 89 53 67 30 73 16 69 87 40 31
// 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23

//NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. 
//However, Problem 67, is the same challenge with a triangle containing one-hundred rows; 
//it cannot be solved by brute force, and requires a clever method! ;o)
object Problem18 
{
	def main(args: Array[String]) 
	{
		val data = """	75
						95 64
						17 47 82
						18 35 87 10
						20 04 82 47 65
						19 01 23 75 03 34
						88 02 77 73 07 63 67
						99 65 04 28 06 16 70 92
						41 41 26 56 83 40 80 70 33
						41 48 72 33 47 32 37 16 94 29
						53 71 44 65 25 43 91 52 97 51 14
						70 11 33 28 77 73 17 78 39 68 17 57
						91 71 52 38 17 14 91 43 58 50 27 29 48
						63 66 04 68 89 53 67 30 73 16 69 87 40 31
						04 62 98 27 23 09 70 98 73 93 38 53 60 04 23 """
		
		val dataTree = data.trim.split("\n").map(_.trim.split(" ").map(_.toInt)).reverse
		
		for (i <- 1 until dataTree.size; j <- 0 until dataTree(i).size)
			dataTree(i)(j) += math.max(dataTree(i - 1)(j), dataTree(i-1)(j + 1))

		println(dataTree.last.head)
	}
	
//	val data = """	75
//						95 64
//						17 47 82
//						18 35 87 10
//						20 04 82 47 65
//						19 01 23 75 03 34
//						88 02 77 73 07 63 67
//						99 65 04 28 06 16 70 92
//						41 41 26 56 83 40 80 70 33
//						41 48 72 33 47 32 37 16 94 29
//						53 71 44 65 25 43 91 52 97 51 14
//						70 11 33 28 77 73 17 78 39 68 17 57
//						91 71 52 38 17 14 91 43 58 50 27 29 48
//						63 66 04 68 89 53 67 30 73 16 69 87 40 31
//						04 62 98 27 23 09 70 98 73 93 38 53 60 04 23 """
//		
//		case class Tree[K](var value : K, val leftNode : Tree[K], val rightNode : Tree[K])
//		val emptyTree = Tree[Int](null.asInstanceOf[Int], null, null)
//
//		val dataTree = data.trim.split("\n").map(_.trim.split(" ").map(_.toInt)).reverse
//
//		var prevList = Seq.empty[Tree[Int]] 
//		var treeList = ListBuffer.empty[Seq[Tree[Int]]]
//		
//		for (i <- 0 until dataTree.size)
//		{
//			val curList = for (j <- 0 until dataTree(i).size; 
//							  val leftNode = if (prevList.isEmpty) emptyTree else prevList(j); 
//							  val rightNode = if (prevList.isEmpty) emptyTree else prevList(j + 1)) 
//						  yield Tree(dataTree(i)(j), leftNode, rightNode)
//			
//			prevList = curList
//			treeList += curList
//		}
//		
//		treeList = treeList.tail
//		
//		for (trees <- treeList; tree <- trees)
//		{
//			val node = if (tree.leftNode.value > tree.rightNode.value) tree.leftNode else tree.rightNode  
//			tree.value += node.value
//		}
//		println (treeList.last(0).value)
	
}