package consumers

import akka.Done
import akka.actor.ActorSystem
import akka.kafka.scaladsl.Consumer
import akka.kafka.{ConsumerSettings, Subscriptions}
import akka.stream.scaladsl.Sink
import akka.stream.{ActorMaterializer, ActorMaterializerSettings}
import cats.data.Xor
import com.typesafe.config.ConfigFactory
import org.apache.kafka.clients.consumer.{ConsumerConfig, ConsumerRecord}
import org.apache.kafka.clients.consumer.internals.PartitionAssignor.Subscription
import org.apache.kafka.common.serialization.{ByteArrayDeserializer, StringDeserializer}
import io.circe._
import io.circe.generic.auto._
import cats.data.Xor.{Left, Right}
import model.Employee

import scala.concurrent.Future

object StreamConsumer  extends App{
  implicit val actorSystem = ActorSystem("consumer-actors", ConfigFactory.load())
  implicit val materializer = ActorMaterializer(ActorMaterializerSettings(actorSystem))

  lazy val consumerSettings = ConsumerSettings(actorSystem, new ByteArrayDeserializer, new StringDeserializer)
    .withBootstrapServers("localhost:9092")
    .withGroupId("group13")
    .withProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")//"latest")
    .withProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true")
    .withProperty(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000")

  lazy val subscription = Subscriptions.topics("raw-data-1")
  lazy val db = new Processor()
  Consumer.plainSource(consumerSettings, subscription)
      .mapAsync(4){
        db.processMessage
      }
    .runWith(Sink.ignore)

}

class Processor {
  def processMessage(record: ConsumerRecord[Array[Byte], String]): Future[Done] ={
    println(s"DB.save: ${record.value()}")

    Option(record.value()).foreach{ jsonString =>
      val mayBeEmp: Xor[Error, Employee] = jawn.decode[Employee](jsonString)
      mayBeEmp match {
        case Left(error) => println(error)
        case Right(emp) => println(s"employee name: ${emp.name}")
      }
    }
    Future.successful(Done)  }
}
