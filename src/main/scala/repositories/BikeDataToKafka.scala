package repositories

import config.KafkaConfig
import org.apache.kafka.clients.producer.{ KafkaProducer, ProducerRecord }
import io.circe.Json
import org.slf4j.{ Logger, LoggerFactory }
import io.github.chronoscala.Imports._
import scala.util.{ Failure, Success, Try, Using }

object BikeDataToKafka {

  private val topic = "bike_data"
  private val logger: Logger = LoggerFactory.getLogger(getClass)

  def sendDataToKafka(bikeData: Json): Try[Unit] = {
    val producer = new KafkaProducer[String, String](KafkaConfig.getProducerConfig)

    Using(producer) { producer =>
      val key     = createKeyWithCurrentTime
      val message = bikeData.noSpaces
      println(s"Message size: ${message.getBytes("UTF-8").length} bytes")
      val record  = new ProducerRecord[String, String](topic, key, message)
      producer.send(record)
      logger.info(s"Sent data to Kafka: ${message.length}")
    }.recoverWith { case e: Exception =>
      logger.error(s"Failed to send data to Kafka: ${e.getMessage}", e)
      Failure(e)
    }
  }

  private def createKeyWithCurrentTime: String =
    Instant.now.toEpochMilli.toString
}
