ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.15"

lazy val root = (project in file("."))
  .settings(
    name := "GlobalAQI"
  )

val sparkVersion               = "3.5.3"
val sttpClientVersion          = "3.10.1"
val circeVersion               = "0.14.10"
val testcontainersScalaVersion = "0.41.4"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core",
  "org.apache.spark" %% "spark-sql"
).map(_ % sparkVersion)

libraryDependencies ++= Seq(
  "com.softwaremill.sttp.client3" %% "core",
  "com.softwaremill.sttp.client3" %% "circe",
  "com.softwaremill.sttp.client3" %% "async-http-client-backend-future"
).map(_ % sttpClientVersion)

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-async" % "1.0.1",
  "com.typesafe" % "config" % "1.4.3",
  "com.amazonaws" % "aws-java-sdk-s3" % "1.12.778",
  "org.apache.iceberg" %% "iceberg-spark-runtime-3.5" % "1.7.0",
  "org.jsoup" % "jsoup" % "1.18.1"
)

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.19" % Test,
  "org.mockito" %% "mockito-scala" % "1.17.12" % Test,
  "com.holdenkarau" %% "spark-testing-base" % "3.5.3_2.0.1" % Test,
  "com.dimafeng" %% "testcontainers-scala-scalatest" % testcontainersScalaVersion % Test
)

scalacOptions ++= Seq(
  "-Xasync"
)
