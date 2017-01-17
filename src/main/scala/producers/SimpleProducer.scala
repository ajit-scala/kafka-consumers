package producers

import java.util.Properties

import model.Employee
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

/**
  * Created by achahal on 17/01/2017.
  */
object SimpleProducer extends App{

  lazy val producer: KafkaProducer[String, String] = new KafkaProducer(getKafkaConfigProperties)
  lazy val testEmpObjects:List[Employee] = (0 to 1000).map(x=>Employee("John"+x, x)).toList

  testEmpObjects.foreach { emp =>
      producer.send(new ProducerRecord[String, String]("raw-data-1", emp.id.toString, Employee.asJson(emp)))
  }

  def getKafkaConfigProperties: Properties = {
    val config = new Properties()

    config.put("bootstrap.servers", "localhost:9092")
    config.put("group.id", "group1")
    config.put("client.id", "client1")
    config.put("enable.auto.commit", "true")
    config.put("session.timeout.ms", "10000")
    config.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    config.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    config.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    config.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

    config
  }
}
