//plugins
resolvers += Classpaths.typesafeResolver

resolvers += "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases/"

resolvers += "sbt-idea-repo" at "http://mpeltonen.github.com/maven/"

//eclipse
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.2.0")

//idea
addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.4.0")

//Scalastyle
// sbt scalastyle , sbt scalastyle-generate-config
addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.3.2")
