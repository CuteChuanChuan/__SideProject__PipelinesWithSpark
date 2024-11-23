package repositories

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import io.circe.Json
import io.circe.parser
import org.mockito.MockitoSugar.{ mock, when }
import scala.io.Source

class BikeDataLoaderSpec extends AnyFlatSpec with Matchers {

  "BikeDataLoader" should "handle successful API response" in {
    val bikeResult = BikeDataLoader.loadData

    bikeResult match {
      case Right(json) =>
        json.isArray shouldBe true
        json.asArray.get.size should be > 0
      case Left(error) =>
        fail(s"Test failed with error: $error")
    }
  }
}
