(0 to 5).foreach(println)
(0 to 5).reduce((x,y) => x + y)
(0 to 5).fold("")((x,y) => x +""+ y)


def cat1(s1:String)(s2:String, s3:String) = s1 + s2
def hello=cat1("hello ") _
hello("world", "d")

def mul(s1:String,s2:String,s3:String) = s1+s2+s3

val mulc = (mul _).curried
Function.uncurried(mulc)

val m = Map("k"->"v")
val m2= m ++ Map("l"->"e")

List("ajit","vinit").flatMap(x=>x.toCharArray)