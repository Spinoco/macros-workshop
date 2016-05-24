import sbt.Keys._
import sbt._


object Build extends Build  {


  val commonSettings = Defaults.coreDefaultSettings ++ Seq(
    organization := "spinoco"
    , scalaVersion := "2.11.7"
    , version :=  "0.1"
    , scalacOptions += "-deprecation"
    , scalacOptions += "-unchecked"
    , scalacOptions += "-feature"
    , scalacOptions ++= Seq("-Ypatmat-exhaust-depth", "off")
    , resolvers += Resolver.sonatypeRepo("releases")
  )

  val macroSettings = Seq(
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-reflect" % "2.11.7"
    )
  )

  lazy val loggerMacro = Project(
    id = "loggerMacro"
    , base = file("./loggerMacro")
    , settings = commonSettings ++ macroSettings
  )

  lazy val prettyprintMacro = Project(
    id = "prettyprintMacro"
    , base = file("./prettyprintMacro")
    , settings = commonSettings ++ macroSettings ++ Seq(
      addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)
    )
  )

  lazy val loggerDemo = Project(
    id = "loggerDemo"
    , base = file("./loggerDemo")
    , settings = commonSettings
  ).dependsOn(loggerMacro)


  lazy val prettyprintDemo = Project(
    id = "prettyprintDemo"
    , base = file("./prettyprintDemo")
    , settings = commonSettings ++ Seq(
      addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)
    )
  ).dependsOn(prettyprintMacro)

}
