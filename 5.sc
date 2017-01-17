val l = List(1,2,3,4,5)
l.foldLeft(List.empty[Int]){
  (list, x) => (x * 2) :: list
}


l.foldLeft(List.empty[String]){
  (list: List[String], x) => (x * 2).toString :: list
}

l.foldRight(0)((x,list)=>x+list)

l.foldRight(""){
  (x, list: String) => {
    println(x)
    println("l:"+list)
    x + list
  }
}


l.reduceRight{
  (elem, acc: Int) => {
    elem + acc
  }
}

List(1, 2, 3, 4, 5, 6).foldRight(List.empty[String]) {
     (x, list) => ("[" + x + "]") :: list
   }

List(1, 2, 3, 4, 5, 6).map {
  x => "[" + x + "]"

}
