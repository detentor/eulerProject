package problems91to100

import io._

object Problem98 
{
	def main(args: Array[String]) 
	{
		val text = loadFile("src/resource/problem98.txt")
						.replaceAll("\"", "")
						.split(",")
						.groupBy(str => str.size)
						.toStream
						.sortWith(_._1 > _._1)
						.map(_._2)
		
		val k = 
		for (k <- text; val ana = 
			for (word <- k; 
					val anagram = k.find(str => str != word && str.sorted == word.sorted); 
					if anagram.isDefined ) 
			yield (word, anagram.get);
			if ana.nonEmpty
		) yield ana
		
		println(k.force.map(_.toList).force)
		
	}

}