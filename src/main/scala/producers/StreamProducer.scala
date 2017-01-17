package producers

import java.util.Properties

import akka.actor.ActorSystem
import akka.kafka.ProducerSettings
import akka.kafka.scaladsl.Producer
import akka.stream.{ActorMaterializer, ActorMaterializerSettings}
import com.typesafe.config.ConfigFactory
import com.typesafe.scalalogging.LazyLogging
import model.Employee
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import org.apache.kafka.common.serialization.{ByteArraySerializer, StringSerializer}
import play.api.libs.json
import play.api.libs.json.Json

import scala.io.Source

object StreamProducer extends App with LazyLogging{

  implicit val actorSystem = ActorSystem("producer-actors", ConfigFactory.load())
  implicit val materializer = ActorMaterializer(ActorMaterializerSettings(actorSystem))

  lazy val producerSettings = ProducerSettings(actorSystem, new ByteArraySerializer, new StringSerializer)
    .withBootstrapServers("localhost:9092")
  lazy val testEmpObjects:List[Employee] = (0 to 1000).map(x=>Employee("John"+x, x)).toList

  val records: List[ProducerRecord[Array[Byte], String]] = testEmpObjects.map(emp => new ProducerRecord[Array[Byte], String]("raw-data-1", Employee.asJson(emp)))
  //records.runWith(Producer.plainSink(producerSettings))
}


