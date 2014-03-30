package problems001to010

import scala.collection.mutable.ListBuffer
import scala.collection.mutable.ArrayBuffer
import scala.annotation.tailrec

//The prime factors of 13195 are 5, 7, 13 and 29.
//What is the largest prime factor of the number 600851475143 ?
object Problem03
{
	def main(args: Array[String]) 
	{
		val number = 600851475143L
		val result = 2 #:: 3 #:: primes((2L :: 3L :: Nil).toStream).takeWhile(_ < number) //Lista lazy de primos até o valor de number
		
		var num = number //Variável a ser atualizada a cada passada
		val lFatores = ListBuffer.empty[Long] //Guarda a lista de fatores primos
		
		while (num != 1)
		{
			val multiplo = result.find(num % _ == 0).get //Encontra um primo que seja múltiplo
			lFatores += multiplo //Adiciona na lista de fatores
			num = num / multiplo //Reduz o número a ser procurado
		}
		
		println(lFatores mkString(" "))
		println("maior valor : " + lFatores.max)
	}
	
	def from(n : Long) : Stream[Long] = n #:: from(n + 1)
	
	@tailrec
	def primes(lPrimos : Stream[Long]) : Stream[Long] = 
	{
		val newValue = from(lPrimos.head + 1).find(k => lPrimos.forall(x => k % x != 0)).get
		newValue #:: primes(newValue #:: lPrimos)
	}
}