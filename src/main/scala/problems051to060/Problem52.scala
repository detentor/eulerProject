package problems051to060

//It can be seen that the number, 125874, 
//and its double, 251748, contain exactly the same digits, but in a different order.
//
//Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
object Problem52 
{
	def main(args: Array[String]) 
	{
		println(Stream.from(1).find(x => (1 to 6).map(y => (x * y).toString).forall(x.toString.intersect(_).size == x.toString.size)).get)
	}

}