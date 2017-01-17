import scala.collection.immutable.IndexedSeq

object Names {
    def unapplySeq(name: String): Option[(String, String, Seq[String])] = {
        val names = name.trim.split(" ")
        if(names.size < 2)
          None
        else
          Some(names.last, names.head, names.drop(1).dropRight(1).toList)
    }

}

"Ajit chahal" match {
  case Names(lname, fname, _*) => "Hello " + lname + " " + fname
  case _ => "please provide your name"
}


val lists = List(1, 2, 3) :: List.empty :: List(5, 3) :: Nil

lists.flatMap(x=>x)
def scores: List[Int] = List(1, 2, 3)

val best :: next :: rest = scores
rest

Set(1,2,3,1,4,6)

trait Emp{
  val n:Int
}

val xx0 = (1 to 2).map(x=>new {val n=x+2})
val xx: Seq[Emp] = (1 to 2).map(x=>new Emp{val n=x+2})
val xx1: Seq[Int] = (1 to 2).map(x=>(x+2))
val xx11: Seq[(Int, Int)] = (1 to 2).map(x=>(x+2, 2))
xx.head.n


for {
  name <- Option("Donald") if name.length < 8
  last <- Option("Duck")
} yield s"$name $last"

def gameResults(): Seq[(String, Int)] =
  ("Daniel", 3500) :: ("Melissa", 13000) :: ("John", 7000) :: Nil

val gr = gameResults()
gr.filter(x => x._2 > 5000)
gr.filter{
  case (x,y) => y > 7000
}
(0 to 5).filter(x=>x % 2==0)


case class Player(name:String, Score:Int)
val Player(name, _) = Player("ajit", 6000)//
name