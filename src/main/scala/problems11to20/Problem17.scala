package problems11to20

//If the numbers 1 to 5 are written out in words: one, two, three, four, five, 
//then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
//
//If all the numbers from 1 to 1000 (one thousand) 
//inclusive were written out in words, how many letters would be used? 
//
//NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) 
//contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. 
//The use of "and" when writing out numbers is in compliance with British usage.
object Problem17 
{
	def main(args: Array[String]) 
	{
		println((1 to 1000).map(toWord(_).replace(" ", "")).foldLeft(0)(_ + _.size))
	}
	
	def toWord( x : Int) : String = 
	{
		if (x < 20)
		{
			x match
			{
				case 0 => ""
				case 1 => "one"
				case 2 => "two"
				case 3 => "three"
				case 4 => "four"
				case 5 => "five"
				case 6 => "six"
				case 7 => "seven"
				case 8 => "eight"
				case 9 => "nine"
				case 10 => "ten"
				case 11 => "eleven"
				case 12 => "twelve"
				case 13 => "thirteen"
				case 14 => "fourteen"
				case 15 => "fifteen"
				case 16 => "sixteen"
				case 17 => "seventeen"
				case 18 => "eighteen"
				case 19 => "nineteen"
				case x => throw new IllegalArgumentException("número desconhecido : " + x)
			}
		}
		else if (x < 100)
		{
			val k = x - (x % 10)
			
			val result = k match
			{
				case 20 => "twenty" 
				case 30 => "thirty"
				case 40 => "forty"
				case 50 => "fifty"
				case 60 => "sixty"
				case 70 => "seventy"
				case 80 => "eighty"
				case 90 => "ninety"
			} 
			val newValue = x - ((x / 10) * 10)
			result + (if (newValue == 0) "" else " " + toWord(newValue))
		}
		else if (x < 1000)
		{
			val newValue = x - ((x / 100) * 100)
			toWord(x.toString.head.toString.toInt) + " hundred" + (if (newValue == 0) "" else " and " + toWord(newValue))
		}
		else if (x < 10000)
		{
			val newValue = x - ((x / 1000) * 1000)
			toWord(x.toString.head.toString.toInt) + " thousand" + (if (newValue == 0) "" else " " + toWord(newValue))
		}
		else
		{
			throw new IllegalArgumentException("número desconhecido : " + x)
		}
		
	}
	
	def toWord( x : Int, magnitude : Int) = 
	{
		magnitude match
		{
			case 1 => "one"
			case 2 => "two"
			case 3 => "three"
			case 4 => "four"
			case 5 => "five"
			case 6 => "six"
			case 7 => "seven"
			case 8 => "eight"
			case 9 => "nine"
			case 10 => "ten"
			case 11 => "eleven"
			case 12 => "twelve"
			case 13 => "thirteen"
			case 14 => "fourteen"
			case 15 => "fifteen"
			case 16 => "sixteen"
			case 17 => "seventeen"
			case 18 => "eighteen"
			case 19 => "nineteen"
			case x => throw new IllegalArgumentException("número desconhecido : " + x)
		}
	}
	
	
	

}