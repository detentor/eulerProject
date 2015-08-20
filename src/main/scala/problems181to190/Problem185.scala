package problems181to190
//The game Number Mind is a variant of the well known game Master Mind.
//
//Instead of coloured pegs, you have to guess a secret sequence of digits. After each guess you're only told in how many places you've guessed the correct digit. So, if the sequence was 1234 and you guessed 2036, you'd be told that you have one correct digit; however, you would NOT be told that you also have another digit in the wrong place.
//
//For instance, given the following guesses for a 5-digit secret sequence,
//
//90342 ;2 correct
//70794 ;0 correct
//39458 ;2 correct
//34109 ;1 correct
//51545 ;2 correct
//12531 ;1 correct
//
//The correct sequence 39542 is unique.
//
//Based on the following guesses,
//
//5616185650518293 ;2 correct
//3847439647293047 ;1 correct
//5855462940810587 ;3 correct
//9742855507068353 ;3 correct
//4296849643607543 ;3 correct
//3174248439465858 ;1 correct
//4513559094146117 ;2 correct
//7890971548908067 ;3 correct
//8157356344118483 ;1 correct
//2615250744386899 ;2 correct
//8690095851526254 ;3 correct
//6375711915077050 ;1 correct
//6913859173121360 ;1 correct
//6442889055042768 ;2 correct
//2321386104303845 ;0 correct
//2326509471271448 ;2 correct
//5251583379644322 ;2 correct
//1748270476758276 ;3 correct
//4895722652190306 ;1 correct
//3041631117224635 ;3 correct
//1841236454324589 ;3 correct
//2659862637316867 ;2 correct
//
//Find the unique 16-digit secret sequence.

object Problem185
{
val dataA = """2321386104303845 ;0
3847439647293047 ;1 
8157356344118483 ;1  
6375711915077050 ;1 
4895722652190306 ;1 
3174248439465858 ;1
6913859173121360 ;1 
2326509471271448 ;2
6442889055042768 ;2
5616185650518293 ;2
5251583379644322 ;2 
2615250744386899 ;2 
4513559094146117 ;2
2659862637316867 ;2       
5855462940810587 ;3 
9742855507068353 ;3 
3041631117224635 ;3
1748270476758276 ;3
8690095851526254 ;3
4296849643607543 ;3
7890971548908067 ;3
1841236454324589 ;3""".split("\n").map(_.split(";").map(_.trim())).map(k => Tuple2(k(0).map(_ - 48), k(1).toInt))

val dataB = """70794 ;0 
12531 ;1
34109 ;1
39458 ;2 
90342 ;2 
51545 ;2""".split("\n").map(_.split(";").map(_.trim())).map(k => Tuple2(k(0).map(_ - 48), k(1).toInt))

val data = dataA


  def main(args: Array[String]) 
  {
      val eleZero = data.find(_._2 == 0).get._1
      val resp = genTrieFast(Nil, data.filter(k => k._2 > 0), Array.fill(data(0)._1.length)(10), List(eleZero))
      println(resp)
      
      val mT =  (0 to 9).toSet &~ (for (curEle <- data) yield curEle._1(12)).toSet
      
      println(mT)
  }
  
  var mCount = 0
  
  //Exclui o restante dos elementos para aqueles casos que já foi satisfeito
  def genTrieFast(cumulative : List[(IndexedSeq[Int], Int)], elesToSatisfy : IndexedSeq[(IndexedSeq[Int], Int)], cumArray : Array[Int], zeroEles : List[IndexedSeq[Int]]) : Option[Array[Int]] = 
  {
      val curEle = elesToSatisfy.head
      val comb = (0 until data(0)._1.length).filter(i => ! zeroEles.exists(a => curEle._1(i) == a(i))).combinations(curEle._2)
      
      for (curTrie <- comb)
      {
          val satisEle = genArray(curTrie, curEle._1, cumArray)
          
          if (satisEle.nonEmpty)
          {
              mCount += 1
              if (mCount % 10000 == 0) println(satisEle.get.mkString("(", ",", ")"))
              val otherEles = elesToSatisfy.tail
              
              if (otherEles.isEmpty)
              {
                  return if (data.forall(curEle => countOcc(satisEle.get, curEle._1) == curEle._2)) Some(satisEle.get) else None
              }
              else
              {
                  //Se até agora continuam todos certos
                 if (cumulative.forall(curEle => countOcc(satisEle.get, curEle._1) <= curEle._2))
                 {
                     val negatedArr = curEle._1.toArray.clone
                     for (k <- curTrie) negatedArr(k) = 10 //nega os elementos não escolhidos
                     val res = genTrieFast(curEle :: cumulative, otherEles, satisEle.get, negatedArr :: zeroEles)
                     if (res.nonEmpty) return res
                 }
              }
          }
      }
      
      None
  }
  
  def genArray(fromComb : IndexedSeq[Int], inEle : IndexedSeq[Int], prevArr : Array[Int]) : Option[Array[Int]]= 
  {
      val genArr = prevArr.clone()
      
      for (i <- fromComb)
      {
        //não tem como combinar os 2
        if (prevArr(i) != 10 && prevArr(i) != inEle(i)) return None
        genArr(i) = inEle(i)
      }
      
      Some(genArr)
  }
  
  def countOcc(str1 : IndexedSeq[Int], str2 : IndexedSeq[Int]) = (0 until str1.length).count(i => str1(i) == str2(i)) 
}