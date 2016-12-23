import org.scalatest._

class HelloSpecIt extends WordSpec with Matchers {
  "Integration hello tests" should {
    "have tests" in {
      true should ===(true)
    }
  }
}
