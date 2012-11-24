//plugins
resolvers += Classpaths.typesafeResolver

resolvers += "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases/"

resolvers += "sbt-idea-repo" at "http://mpeltonen.github.com/maven/"

//eclipse
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.1.0")

//idea
addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.1.0")

//Scalastyle
// sbt scalastyle , sbt scalastyle-generate-config
addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.2.0")


