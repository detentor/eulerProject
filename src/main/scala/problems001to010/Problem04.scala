package problems001to010

//A palindromic number reads the same both ways. 
//The largest palindrome made from the product of two 2-digit numbers is 9009 = 91  99.
//Find the largest palindrome made from the product of two 3-digit numbers.
object Problem04
{
	def main(args: Array[String]) 
	{
		var num1 = 999
		var num2 = 999
		
		val listaListaMults = generateStreams(num1, num2)
		println(listaListaMults.map( _ find(isPalindrome) get ).max)
	}
	
	//Cria todas as possíveis multiplicações de num1 * num2, com num2 diminuindo a cada iteração
	def generateStream(num1 : Int, num2 : Int) : Stream[Int] = 
	{
		(num1 * num2) #:: (if (num2 == 0) Stream.empty[Int] else generateStream(num1, num2 - 1))
	}
	
	//Cria todas os possíveis Streams de multiplicação onde num1 varia até chegar a 0
	def generateStreams(num1 : Int, num2 : Int) : Stream[Stream[Int]] = 
	{
		generateStream(num1, num2) #:: ( if (num1 == 0) Stream.empty[Stream[Int]] else generateStreams(num1 - 1, num2))
	}
	
	//Retorna se um número é palíndromo
	def isPalindrome(num : Int) = num.toString == num.toString.reverse

}