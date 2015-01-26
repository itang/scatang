name := "scatang"

version := "0.2-SNAPSHOT"

scalaVersion := "2.11.5"

organization := "me.itang"

javaOptions += "-Xmx912m"

javacOptions ++= Seq("-encoding", "UTF-8")

javacOptions ++= Seq("-source", "1.7", "-target", "1.7")

scalacOptions ++= Seq("-encoding", "UTF-8","-encoding", "UTF-8", "-Xlint", "-feature", "-unchecked", "-deprecation", "-target:jvm-1.7", "-language:postfixOps", "-language:implicitConversions", "-language:reflectiveCalls", "-Yno-adapted-args", "-Xfatal-warnings")

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.11" % "2.2.2" % "test"
)

//org.scalastyle.sbt.ScalastylePlugin.Settings

publishTo := Some(Resolver.file("file",  new File(Path.userHome.absolutePath+"/.m2/repository")))

initialCommands in console := """import scatang._;import scatang.string._"""

publishTo := {
  val nexus = "http://120.24.68.174:8081/nexus/content/repositories"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "/snapshots")
  else
    Some("releases"  at nexus + "/releases")
}

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")