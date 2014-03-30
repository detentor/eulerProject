package problems031to040

import scala.collection.mutable.HashMap

//In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
//
//1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
//It is possible to make £2 in the following way:
//
//1£1 + 150p + 220p + 15p + 12p + 31p
//How many different ways can £2 be made using any number of coins?
object Problem31 
{
	def main(args: Array[String]) 
	{
		val maxCount = 200
		val coinList = List(100, 50, 20, 10, 5, 2, 1)
		
		//curCoint = 100 0 [50, 20, 10, 5, 2, 1]   [100, 50, 20, 10, 5, 2, 1]
		//curCoint = 100 0 [50, 20, 10, 5, 2, 1]   [20, 10, 5, 2, 1]
		
		
		
		def getPermutations(curCoin : Int,    	//a moeda atualmente sendo contada
							curCount : Int, 	//a contagem atual da moeda
							fullList : List[Int],  //as moedas que faltam contar
							secList : List[Int], 	//a segunda lista de moedas que falta contar
							acc : Long) : Long =    //o valor acumulado até agora
		{
			val curSum = curCoin + secList.head
			
			//Se chegou a 200, acabou este caminho
			if (curSum == maxCount)
			{
				getPermutations(curCoin, 0, fullList, secList.tail, acc + 1) //chegou ao fim de um galho
			}
			else if (curSum < maxCount)
			{
				getPermutations(curCoin, curSum, fullList, secList, acc) //Continua somando
			}
			else
			{
				0
			}
			
		}
		
		
	}

}