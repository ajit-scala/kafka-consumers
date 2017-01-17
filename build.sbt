
name := """kafka-consumers"""

version := "1.0"

scalaVersion := "2.11.8"

// Change this to another test framework if you prefer
val akkaVersion = "2.4.11"
val akkaDependencies = Seq(
  "com.typesafe.akka" %% "akka-stream-kafka" % "0.13",
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-http-experimental" % akkaVersion,
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "io.circe" %% "circe-core" % "0.4.1",
  "io.circe" %% "circe-parser"  % "0.4.1",
  "io.circe" %% "circe-generic" % "0.4.1",
  "com.typesafe.play" % "play-json_2.11" % "2.5.10"
)

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.3.0",
  "org.mockito"             % "mockito-core"       % "2.2.9" % "test,it",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test,it",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.4.0",
  "ch.qos.logback" % "logback-classic" % "1.1.7"
) ++ akkaDependencies


lazy val root = (project in file("."))
  .configs(IntegrationTest)
  .settings(Defaults.itSettings: _*)
  .settings(
    cleanFiles <+= baseDirectory { _ / "logs" }
  )