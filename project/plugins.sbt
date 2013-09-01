//plugins
resolvers += Classpaths.typesafeResolver

resolvers += "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases/"

//eclipse
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.3.0")

//Scalastyle
// sbt scalastyle , sbt scalastyle-generate-config
//addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.3.2")
