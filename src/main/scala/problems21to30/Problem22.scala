package problems21to30

import java.io.FileInputStream
import java.io.File

//Using names.txt (http://projecteuler.net/project/names.txt), a 46K text file containing over five-thousand first names, 
//begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, 
//multiply this value by its alphabetical position in the list to obtain a name score.
//For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, 
//is the 938th name in the list. So, COLIN would obtain a score of 938 * 53 = 49714.
//What is the total of all the name scores in the file?
object Problem22 
{
	def main(args: Array[String]) 
	{
		val listaNomes = loadFile("C:\\Users\\vini\\Desktop\\names.txt").replaceAll("\"", "").split(",").sorted
		
		println(listaNomes.map(nome => getValue(nome) * (listaNomes.indexOf(nome) + 1) ).sum)
	}
	
	def getValue(nome : String) = nome.map(_ - 64).sum
	
	def loadFile(fileName : String) = 
	{
		val arqRef = new File(fileName)
		val arqHandle = new FileInputStream(arqRef)
		
		val arqContents = Array.ofDim[Byte](arqRef.length.intValue)
		arqHandle.read(arqContents)
		arqHandle.close
		
		new String(arqContents)
	}

}