
name := """kafka-consumers"""

version := "1.0"

scalaVersion := "2.11.8"

// Change this to another test framework if you prefer
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test,it"

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.3.0",
  "org.mockito"             % "mockito-core"       % "2.2.9" % "test,it"
)
// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"

lazy val root = (project in file("."))
  .configs(IntegrationTest)
  .settings(Defaults.itSettings: _*)
  .settings(
    cleanFiles <+= baseDirectory { _ / "logs" }
  )