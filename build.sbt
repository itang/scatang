name := "scatang"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.11.2"

organization := "me.itang"

javaOptions += "-Xmx912m"

javacOptions ++= Seq("-encoding", "UTF-8")

javacOptions ++= Seq("-source", "1.7", "-target", "1.7")

scalacOptions ++= Seq("-encoding", "UTF-8","-encoding", "UTF-8", "-Xlint", "-feature", "-unchecked", "-deprecation", "-target:jvm-1.7", "-language:postfixOps", "-language:implicitConversions", "-language:reflectiveCalls", "-Yno-adapted-args", "-Xfatal-warnings")

libraryDependencies ++= Seq(
  //"org.brianmckenna" % "wartremover_2.10" % "0.3",
  "org.scalatest" % "scalatest_2.11" % "2.2.0" % "test"
)

//org.scalastyle.sbt.ScalastylePlugin.Settings

publishTo := Some(Resolver.file("file",  new File(Path.userHome.absolutePath+"/.m2/repository")))

initialCommands in console := """import scatang._;import scatang.string._"""

