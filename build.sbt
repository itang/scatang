name := "scatang"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.10.3"

organization := "me.itang"

javaOptions += "-Xmx912m"

javacOptions ++= Seq("-encoding", "UTF-8")

javacOptions ++= Seq("-source", "1.6", "-target", "1.6")

scalacOptions ++= Seq("-encoding", "UTF-8","-encoding", "UTF-8", "-Xlint", "-feature", "-unchecked", "-deprecation", "-target:jvm-1.6", "-language:postfixOps", "-language:implicitConversions", "-language:reflectiveCalls", "-Yno-adapted-args", "-Ywarn-all", "-Xfatal-warnings")

libraryDependencies ++= Seq(
  //"org.brianmckenna" % "wartremover_2.10" % "0.3",
  "org.scalatest" % "scalatest_2.10" % "2.1.0" % "test"
)

//org.scalastyle.sbt.ScalastylePlugin.Settings
