package problems051to060

//The primes 3, 7, 109, and 673, are quite remarkable. By taking any two primes 
//and concatenating them in any order the result will always be prime. 
//For example, taking 7 and 109, both 7109 and 1097 are prime. 
//The sum of these four primes, 792, represents the lowest sum for a set of four primes with this property.
//
//Find the lowest sum for a set of five primes for which any two primes concatenate to produce another prime.
object Problem60 
{
	def main(args: Array[String]) 
	{
		//Retorna um Stream de primos
		lazy val primes: Stream[Int] = 2 #:: Stream.from(3).filter(i => primes.takeWhile(j => j * j <= i).forall(i % _> 0))
		
		def isPrime(x : Int) = primes.dropWhile(_ < x).take(1).head == x
		
		val resp = Stream.from(4).find(k => {
			 	println(k); primes.take(k).combinations(4).exists(com => com.combinations(2)
			 								.forall(y =>  isPrime( (y.head.toString + y.tail.head.toString).toInt) &&
			 											  isPrime( (y.tail.head.toString + y.head.toString).toInt)) ) 
			})
		
  
	}

}