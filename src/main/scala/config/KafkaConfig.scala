package config

import com.typesafe.config.{ Config, ConfigFactory }
import org.apache.kafka.clients.producer.ProducerConfig

import java.util.Properties

object KafkaConfig {

  private val config: Config = ConfigFactory.load()

  private val bootstrapServers: String = config.getString("kafka.bootstrap-servers")
  private val keySerializer:    String = config.getString("kafka.key-serializer")
  private val valueSerializer:  String = config.getString("kafka.value-serializer")

  def getProducerConfig: Properties = {
    val prop = new Properties()
    prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers)
    prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, keySerializer)
    prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, valueSerializer)
    prop
  }

}
