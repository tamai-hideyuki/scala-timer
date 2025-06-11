ThisBuild / scalaVersion := "3.3.3"
ThisBuild / organization := "com.barony"

lazy val timerCore = project.in(file("timer-core"))

lazy val timerUI = project.in(file("timer-ui"))

lazy val root = (project in file("."))
  .aggregate(timerCore, timerUI)
  .settings(
    name := "scala-timer",
    publish / skip := true
  )
