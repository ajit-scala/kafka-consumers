val words: Array[String] = Array("zero","one","two","three","four")

words.foreach(println)
val r: Array[Int] = words.map(x=>x.length)

r.foreach(println)

val rr: Array[Char] = words.flatMap(x=>x.toCharArray)

rr.foreach(println)

val r3: Array[(String, String)] = words.map(x=>(x, x+"111"))
r3.foreach(println)



case class Foo(name:String,lastName:String)
val r4: Array[Array[Foo]] = words.map(x=> Array(Foo(x, x+"-Ajit"),Foo(x,x+"-Vinit") ))
r4.foreach(println)
val r5: Array[Foo] = words.flatMap(x=> Array(Foo(x, x+"-Ajit"),Foo(x,x+"-Vinit") ))
r5.foreach(println)