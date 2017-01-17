import org.scalatest.{FlatSpec,Matchers,WordSpec}


class HelloSpec extends FlatSpec with Matchers {
  "Hello" should "have tests" in {
    true should === (true)
  }
}


import org.mockito.Mock
import org.mockito.Mockito._
import org.mockito.ArgumentMatchers._


class test {
  def compareTo1(name:String): Int ={
    99
  }
}

object TestSpec {
  val m = mock(classOf[test])
  when(m.compareTo1("ajit")).thenReturn(100)
  when(m.compareTo1("vinit")).thenReturn(101)
  //when(m.compareTo1(any())).thenReturn(1000)

  def printVals(obj: test): Int = {
    obj.compareTo1("vinit")
  }

}
class TestSpec extends WordSpec with Matchers {
  import TestSpec._
  "trying mockito" should {
    "name params " in  {
      println("----------->>>>>>>"+printVals(m))
      printVals(m) shouldBe (101)
    }
  }
}


