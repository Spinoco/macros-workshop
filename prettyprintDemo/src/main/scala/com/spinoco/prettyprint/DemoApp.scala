package com.spinoco.prettyprint


object DemoApp extends App {

  val x = 1

  val prettyPrinter = implicitly[PrettyPrinter[Int]]

  println(prettyPrinter.print(x, 0))
}
