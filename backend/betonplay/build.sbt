name := """betonplay"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJdbc,
  javaJpa,
  cache,
  javaWs
)

libraryDependencies += "org.hibernate" % "hibernate-entitymanager" % "5.0.2.Final"
libraryDependencies += "joda-time" % "joda-time" % "2.8.2"


// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
