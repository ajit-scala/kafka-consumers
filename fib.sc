case class Category(name:String, children: List[Category])

def generate(depth: Int, children: Int): List[Category] = {
  if(depth == 0) Nil
  else (0 until children).map(i => Category("abc", generate(depth - 1, children))).toList
}

val list = generate(2, 1)

list.map(println)

case class Emp(name:String)
val emps: List[Emp] = (0 to 10).map(x=>Emp(x.toString())).toList
emps.length