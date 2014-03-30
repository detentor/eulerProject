package problems081to090

import io._
import scala.io.Source
import scala.collection.mutable.ListBuffer

//In the 5 by 5 matrix below, the minimal path sum from the top left 
//to the bottom right, by only moving to the right and down, is indicated in bold red and is equal to 2427.	
//131	673	234	103	18
//201	96	342	965	150
//630	803	746	422	111
//537	699	497	121	956
//805	732	524	37	331
//
//Find the minimal path sum, in matrix.txt (right click and 
//'Save Link/Target As...'), a 31K text file containing a 80 by 80 matrix, 
//from the top left to the bottom right by only moving right and down.
object Problem81 
{
  def main(args: Array[String]) 
  {
     val curArray = Source.fromFile("""C:\Users\f9540702\Desktop\matrix.txt""").getLines.toIndexedSeq.map(_.split(",").map(_.toInt))
     val maxVal = curArray.size
     val nodeArr = curArray.flatten.map(new Node(_))

     for (i <- 0 until maxVal; j <- 0 until maxVal)
     {
         val curNode =  nodeArr(i * maxVal + j)
	     if (i < (maxVal - 1)) curNode.connections += nodeArr((i + 1) * maxVal + j)
	     if (j < (maxVal - 1)) curNode.connections += nodeArr(i * maxVal + (j + 1))
     }
     println("weight: " + nodeArr(0).weight)
     println("trace: " + nodeArr(0).traceNode)
  }

  class Node(val value : Int, val connections : ListBuffer[Node] = ListBuffer.empty)
  {
    lazy val weight : Int =  value + (if (connections.isEmpty) 0 else connections.minBy(_.weight).weight)
    def traceNode : String = value + (if (connections.isEmpty) ""  else " -> " + connections.minBy(_.weight).traceNode)
  }
}