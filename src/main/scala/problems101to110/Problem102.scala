package problems101to110

import io._
import java.awt.Polygon

//Three distinct points are plotted at random on a 
//Cartesian plane, for which -1000  x, y  1000, such that a triangle is formed.
//
//Consider the following two triangles:
//
// A(-340,495), B(-153,-910), C(835,-947)
//
// X(-175,41),  Y(-421,-714), Z(574,-645)
//
//It can be verified that triangle ABC contains the origin, whereas triangle XYZ does not.
//
//Using triangles.txt (right click and 'Save Link/Target As...'), a 27K text file 
//containing the co-ordinates of one thousand "random" triangles, 
//find the number of triangles for which the interior contains the origin.
//
//NOTE: The first two examples in the file represent the triangles in the example given above.
object Problem102 
{
	def main(args: Array[String]) 
	{
		val resp = loadFile("src/resource/problem102.txt")
						.split("\r\n")
						.flatMap(_.split(",").map(_.toInt))
						.grouped(6)
						.map(k => (Array(k(0), k(2), k(4)), Array(k(1), k(3), k(5))))
						.map(k => new Polygon(k._1, k._2, 3))
						.count(_.contains(0, 0))
		println(resp)
	}
}