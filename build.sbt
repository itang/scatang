name := "scatang"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.9.2"

organization := "me.itang"

javaOptions += "-Xmx912m"

javacOptions ++= Seq("-encoding", "UTF-8")

javacOptions ++= Seq("-source", "1.5", "-target", "1.5")

libraryDependencies +=  "org.scalatest" % "scalatest_2.9.0" % "1.6.1" % "test"
