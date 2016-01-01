name := """betonplay"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJdbc,
  javaJpa,
  cache,
  javaWs,
  filters,
  evolutions
)

libraryDependencies += "org.hibernate" % "hibernate-entitymanager" % "4.3.8.Final"
libraryDependencies += "joda-time" % "joda-time" % "2.8.2"
libraryDependencies += "junit" % "junit" % "4.12" % "test"
libraryDependencies ++= Seq(
  "com.fasterxml.jackson.core" % "jackson-core" % "2.6.1",
  "com.fasterxml.jackson.core" % "jackson-annotations" % "2.6.1",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.6.1",
  "com.fasterxml.jackson.module" % "jackson-module-paranamer" % "2.6.1"
)
libraryDependencies += "org.postgresql" % "postgresql" % "9.4-1200-jdbc41"
libraryDependencies += "com.heroku.sdk" % "heroku-jdbc" % "0.1.0"
libraryDependencies += "org.jadira.usertype" % "usertype.core" % "4.0.0.GA"


// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
PlayKeys.externalizeResources := false

// Package the history files as well
import com.typesafe.sbt.SbtNativePackager.Universal

mappings in Universal += {
  file("app/history/team-names-per-seasons.csv") -> "bin/app/history/team-names-per-seasons.csv"  
}
mappings in Universal += {
  file("app/history/2015-16/matches-league-1.csv") -> "bin/app/history/2015-16/matches-league-1.csv"  
}
mappings in Universal += {
  file("app/history/2015-16/team-league.csv") -> "bin/app/history/2015-16/team-league.csv"  
}