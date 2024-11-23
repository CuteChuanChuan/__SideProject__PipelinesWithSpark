package config

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class KafkaConfigSpec extends AnyFlatSpec with Matchers {

  "KafkaConfig" should "get producer config" in {
    val producerConfig = KafkaConfig.getProducerConfig
    producerConfig.get("bootstrap.servers") shouldBe "localhost:9092"
    producerConfig.get(
      "key.serializer") shouldBe "org.apache.kafka.common.serialization.StringSerializer"
    producerConfig.get(
      "value.serializer") shouldBe "org.apache.kafka.common.serialization.StringSerializer"
  }

}
