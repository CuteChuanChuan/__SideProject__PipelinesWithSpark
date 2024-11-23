//package repositories
//
//import io.circe.{ parser, Json }
//import org.mockito.MockitoSugar.{ mock, when }
//import org.scalatest.flatspec.AnyFlatSpec
//import org.scalatest.matchers.should.Matchers
//
//import scala.io.Source
//
//class MockedDataLoaderSpec extends AnyFlatSpec with Matchers {
//  it should "handle API failure" in {
//    val mockClient   = mock[DataLoader]
//    val errorMessage = "HTTP request failed: 404 Not Found"
//
//    when(mockClient.loadData).thenReturn(Left(errorMessage))
//
//    val bikeResult = mockClient.loadData
//    bikeResult shouldBe Left("HTTP request failed: 404 Not Found")
//  }
//
//  it should "correctly parse valid bike data Json with correct count" in {
//    val mockClient     = mock[DataLoader]
//    val mockResponse   = Source.fromResource("fake_bike_data.json").mkString
//    val parsedResponse = parser.parse(mockResponse).getOrElse(Json.Null)
//
//    when(mockClient.loadData).thenReturn(Right(parsedResponse))
//
//    val bikeResult = mockClient.loadData
//
//    bikeResult shouldBe a[Right[_, _]]
//    bikeResult.foreach(json => json.isArray shouldBe true)
//    parsedResponse.asArray.get.size shouldBe 3
//  }
//
//}
