package model

import io.github.chronoscala.Imports._

import java.time.{ LocalDate, LocalDateTime }

case class TimeInfo(
  srcUpdated:        LocalDateTime,
  dbInserted:        LocalDateTime,
  stationUpdated:    LocalDateTime,
  stationUpdateDate: LocalDate)

case class Location(
  latitude:    Double,
  longitude:   Double,
  areaChinese: String,
  areaEnglish: String,
  addrChinese: String,
  addrEnglish: String)

case class BikeNum(totalCnt: Int, rentableBikes: Int, returnableSlots: Int)

case class Name(chinese: String, english: String)

case class BikeStation(
  stationNumber: String,
  name:          Name,
  bikeNum:       BikeNum,
  location:      Location,
  timeInfo:      TimeInfo,
  isActive:      Boolean)
