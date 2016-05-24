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
    , addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)
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

  lazy val serializerMacro = Project(
    id = "serializerMacro"
    , base = file("./serializerMacro")
    , settings = commonSettings ++ macroSettings
  )

  lazy val loggerDemo = Project(
    id = "loggerDemo"
    , base = file("./loggerDemo")
    , settings = commonSettings
  ).dependsOn(loggerMacro)



}
