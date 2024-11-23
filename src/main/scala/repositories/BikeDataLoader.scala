package repositories

import scala.io.Source
import io.circe._
import io.circe.parser._
import scala.util.Using

import scala.util.{ Failure, Success, Try }

trait DataLoader {
  def loadData: Either[String, Json]
}

object BikeDataLoader extends DataLoader {

  private val bikeAPIEndpoint =
    "https://tcgbusfs.blob.core.windows.net/dotapp/youbike/v2/youbike_immediate.json"

  override def loadData: Either[String, Json] =
    Using(Source.fromURL(bikeAPIEndpoint)) { source =>
      parse(source.mkString).left.map(_.getMessage)
    }.fold(exception => Left(s"Failed to load data: ${exception.getMessage}"), result => result)

}
