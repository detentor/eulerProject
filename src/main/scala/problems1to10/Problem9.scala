package problems1to10

import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Buffer

//A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
//							a² + b² = c²
//
//For example, 3² + 4² = 9 + 16 = 25 = 5².
//
//There exists exactly one Pythagorean triplet for which a + b + c = 1000.
//Find the product abc.
object Problem9
{
	def main(args: Array[String]) 
	{
		var num1 = 3
		var num2 = 4
		
		val listaTuplas = generateStreams(num1, num2)
		
		def findAnswer(str : Stream[Tuple2[Int, Int]]) = 
		{
			val ret = str.find(tupla => { var c = sqrt(pow(tupla._1) + pow(tupla._2)); c.isDefined && (tupla._1 + tupla._2 + c.get == 1000)})
			if (ret.isEmpty) None else Some( (ret.get._1, ret.get._2, sqrt(pow(ret.get._1) + pow(ret.get._2)).get))
		}
		
		//Procure em TODOS os Streams possíveis
		val result = listaTuplas.find(findAnswer(_).isDefined)
		val answer = findAnswer(result.get).get
		println("Multiplicação : " + answer._1 * answer._2 * answer._3)
	}
	
	//Gera um Stream de tuplas, onde o segundo elemento sempre aumenta, até que
	//a soma do primeiro com o segundo chegue num determinado limiar
	//OBS: O segundo elemento é sempre maior que o primeiro
	def generateTuple(start1 : Int, start2 : Int) : Stream[Tuple2[Int, Int]] = 
	{
		val endSum = 1000
		(start1, start2) #:: (if (start1 + start2 >= endSum) Stream.empty[Tuple2[Int,Int]] else generateTuple(start1, start2 + 1))
	}
	
	//Gera streams 
	def generateStreams(start1 : Int, start2 : Int) : Stream[Stream[Tuple2[Int, Int]]] = 
	{
		val endSum = 1000
		generateTuple(start1, start2) #:: (if (start1 + start2 >= endSum) Stream.empty[Stream[Tuple2[Int,Int]]] else generateStreams(start1 + 1, start1 + 2))
	}
	
	def pow(x : Int) = math.pow(x, 2).intValue
	def sqrt(x : Int) = if (isExact(math.sqrt(x))) Some(math.sqrt(x).intValue) else None
	
	def isExact(x : Double) = x - x.intValue == 0
	
}