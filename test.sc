import scala.annotation.tailrec

def fibSeq(n: Int): List[Int] = {
  var ret = scala.collection.mutable.ListBuffer[Int](1, 2)
  while (ret(ret.length - 1) < n) {
    val temp = ret(ret.length - 1) + ret(ret.length - 2)
    if (temp >= n) {
      return ret.toList
    }
    ret += temp
  }
  ret.toList
}

fibSeq(10)

def sum(n: Int):Int = {

  @tailrec
  def sumRec(numbers: Int, acc: Int): Int = {
    if (numbers == 0)
      acc
    else
      sumRec(numbers - 1, acc + numbers)
  }

  sumRec(n, 0)
}
sum(2)

def sumList(n:List[Int]):Int = {
  @tailrec
  def sum(numbers:List[Int], acc:Int): Int = {
    numbers match {
      case Nil => acc
      case head :: tail => sum(tail, acc + head)
    }
  }

  sum(n, 0)
}
sumList(List(1,2,878,99))

List(1,2,3,4,5).reduceLeft(_ + _)
List(1,2,3,4,5).foldLeft(1)(_ + _)

val s: Stream[Int] = 5 #:: 6 #:: Stream.Empty
s.map(println)

def sumLists(n:Stream[Int]):Int = {
  @tailrec
  def sum(numbers:Stream[Int], acc:Int): Int = {
    numbers match {
      case Stream.Empty => acc
      case head #:: tail => sum(tail, acc + head)
    }
  }

  sum(n, 0)
}

sumLists(Stream(1,2))

(0 until 5)



