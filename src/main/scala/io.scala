

import java.io.File
import java.io.FileInputStream

package object io 
{
	def loadFile(fileName : String) = 
	{
		val file = new File(fileName)
		val inputStream = new FileInputStream(file)
		val byteArr = new Array[Byte](file.length.toInt)
		
		inputStream.read(byteArr)
		inputStream.close
		
		new String(byteArr)
	}
}