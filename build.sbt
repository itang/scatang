name := "scatang"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.10.2"

organization := "me.itang"

javaOptions += "-Xmx912m"

javacOptions ++= Seq("-encoding", "UTF-8")

javacOptions ++= Seq("-source", "1.6", "-target", "1.6")

scalacOptions ++= Seq("-deprecation", "-feature", "-Yno-adapted-args", "-Ywarn-all", "-Xfatal-warnings")

libraryDependencies ++= Seq(
  "org.brianmckenna" % "wartremover_2.10" % "0.3",
  "org.scalatest" % "scalatest_2.10" % "1.9.1" % "test"
)

org.scalastyle.sbt.ScalastylePlugin.Settings
