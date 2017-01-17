import com.typesafe.config.ConfigFactory

import scala.util.Try
import scala.collection.JavaConverters._

trait Configuration {
  lazy val config                   = ConfigFactory.load()

  lazy val brokers: String          = java.net.InetAddress.getAllByName(config.getString("kafka.host")).map(a => s"${a.getHostAddress}:${config.getInt("kafka.port")}").mkString(",")
  lazy val brokersHost: String      = config.getString("kafka.host")
  lazy val kafkaZookeeper: String   = config.getString("kafka.zookeeper")
  lazy val kafkaPort: Int           = config.getInt("kafka.port")
  lazy val kafkaClientId: String    = config.getString("kafka.client.id")
  lazy val kafkaGroupId: String     = config.getString("kafka.group.id")
  lazy val inputTopics: Set[String] = config.getStringList("kafka.inputTopics").asScala.toSet
}

