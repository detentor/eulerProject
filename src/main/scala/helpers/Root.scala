package helpers

/**
 * Representa a enésima raiz de um número.
 * A precisão é arbitrária (tão grande quanto se queira)
 */
case class Root(val ofNum : Long, val n : Int = 2)
{
	//É possível usar esse algoritmo para calcular raízes de números decimais também. Ver http://en.wikipedia.org/wiki/Methods_of_computing_square_roots
	
	def getResults = 
	{
		def infiniteStream : Stream[Int] = 0 #:: infiniteStream 
		val numbers = ((if (n.toString.size % 2 > 0) "0" else "") + n.toString).grouped(2).map(_.toInt).toStream ++ infiniteStream
		
		val k = numbers.take(1).head
		val r = 0
		val c = r * 100 + k
		
		val p = 0
		
		
		
//		One digit of the root will appear above each pair of digits of the square.
//
//Beginning with the left-most pair of digits, do the following procedure for each pair:
//Starting on the left, bring down the most significant (leftmost) pair of digits not yet used (if all the digits have been used, write "00") 
//		and write them to the right of the remainder from the previous step (on the first step, there will be no remainder).
//		In other words, multiply the remainder by 100 and add the two digits. This will be the current value c.
//Find p, y and x, as follows: 
//Let p be the part of the root found so far, ignoring any decimal point. (For the first step, p = 0).
//Determine the greatest digit x such that . We will use a new variable y = x(20p + x). 
//Note: 20p + x is simply twice p, with the digit x appended to the right).
//Note: You can find x by guessing what c/(20·p) is and doing a trial calculation of y, then adjusting x upward or downward as necessary.
//Place the digit  as the next digit of the root, i.e., above the two digits of the square you just brought down. Thus the next p will be the old p times 10 plus x.
//Subtract y from c to form a new remainder.
//If the remainder is zero and there are no more digits to bring down, then the algorithm has terminated. Otherwise go back to step 1 for another iteration.
		
		
	}
}

object Teste
{
	def main(args: Array[String]) 
	{
		val n = 201
		val numbers = ((if (n.toString.size % 2 > 0) "0" else "") + n.toString).grouped(2).map(_.toInt)
		
		numbers foreach println
  
	}
}