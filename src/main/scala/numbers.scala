import scala.collection.immutable.Stream.consWrapper
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.HashSet

package object numbers 
{
	//ATTENTION: THERE'S some errors when numbers get too high. Sometimes the answer can be in floor
		//or ceil. //Ex: 127035954683. Cuberoot says it's 5195, but the real answer is 5196.
//		def cubeRoot(x : BigInt) = BigInt(ceil(exp(log(x.doubleValue) / 3)).toInt)
//		def isCube(x : BigInt) = BigInt(floor(exp(log(x.doubleValue) / 3)).toInt).pow(3) == x
	
	//Lista infinita de números long
	def from(n : Long) : Stream[Long] = n #:: from(n + 1)
	
	//Retorna um Stream de primos
	lazy val primes: Stream[Long] = 2L #:: from(3).filter(i => primes.takeWhile(j => j * j <= i).forall(i % _> 0))
	
	//fatorial
	def factorial(num : Int) = (2 to num).foldLeft(1L)( _ * _)
	def digitSum(theNum : String) = theNum.map(_.toString.toInt).sum
	
	def getDivisors(x : Long) = (1L to x /2).filter(x % _ == 0)
	
	@inline
	def toDigit(num : Int) = num.toString.toArray.map(_ - 48)
	
	def getPrimeDivisors(x : Int) = 
	{
		val arrBuff = new ArrayBuffer[Int]
		
		for (k <- 2 to x/2)
		{
			if (x % k == 0 && ! arrBuff.exists( k % _ == 0))
			{
				arrBuff += k
			}
		}
		
		if (arrBuff.isEmpty) arrBuff += x
		
		arrBuff
	}
	
	def getProperDivisors(x : Long) = (1L to x/2).filter(x % _ == 0) ++ (x :: Nil) 
	
	def registerTime[A](t: => A) =
	{
		val startTime = System.currentTimeMillis
		val resp = t
		println("Demorou " + (System.currentTimeMillis - startTime) + " milis")
		resp
	}
	
	
	implicit def convertInt(num : Int) = new RichNumber(num)
	
	class RichNumber(num : Int)
	{
		//Transforma um número numa lista de dígitos
		@inline
		def toDigit = num.toString.toArray.map( _ - 48)
		
		@inline
		def factorial = { require(num > -1); if (num < 2) 1 else (2 to num).foldLeft(1L)(_ * _) } 
		
	}
	
}