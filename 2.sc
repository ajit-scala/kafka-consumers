def filer(fn:Int): String ={
  println(fn)
  fn+"-.."
}

def testhof[R,T](in:R, resource: R=>T): Unit ={
  println(resource(in))
}
def testhof2[T](resource: ()=>T): Unit ={
  println(resource())
}
def testhof3[T](resource: =>T): Unit ={
  println(resource)
}

//testhof(33, filer)
//testhof2( ()=> filer(334))
testhof3(filer(1234))