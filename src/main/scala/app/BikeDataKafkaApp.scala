package app

import repositories.{ BikeDataLoader, BikeDataToKafka }
import org.slf4j.{ Logger, LoggerFactory }

object BikeDataKafkaApp {

  private val logger: Logger = LoggerFactory.getLogger(getClass)

  def main(args: Array[String]): Unit =
    BikeDataLoader.loadData match {
      case Right(value) => BikeDataToKafka.sendDataToKafka(value)
      case Left(error)  => println(s"Failed to load data: $error")
    }

}
