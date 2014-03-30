package problems051to060

//By replacing the 1st digit of *3, it turns out 
//that six of the nine possible values: 13, 23, 43, 53, 73, and 83, are all prime.
//
//By replacing the 3rd and 4th digits of 56**3 with the same digit, 
//this 5-digit number is the first example having seven primes among 
//the ten generated numbers, yielding the family: 56003, 56113, 56333, 56443, 56663, 56773, and 56993. 
//Consequently 56003, being the first member of this family, is the smallest prime with this property.
//
//Find the smallest prime which, by replacing part of the number 
//(not necessarily adjacent digits) with the same digit, is part of an eight prime value family.
object Problem51 
{
	def main(args: Array[String]) 
	{
		def from(n : Long) : Stream[Long] = n #:: from(n + 1)
		lazy val primes: Stream[Long] = 2L #:: from(3).filter(i => primes.takeWhile(j => j * j <= i).forall(i % _> 0))
		
		def similarity(x : Long, y : Long) = x.toString.zip(y.toString).count(x => x._1 == x._2)
		
		val t = Stream.from(2).map(k => primes.dropWhile(_ < BigInt(10).pow(k - 1))
									  		  .takeWhile(_ < BigInt(10).pow(k))
							) 
		
		println(t.take(1).head.mkString(" "))
		
	}
	
}