package com.spinoco.prettyprint


object DemoApp extends App {

  val x = 1

  val prettyPrinter = implicitly[PrettyPrinter[SecondClass]]

  println(prettyPrinter.print(SecondClass(SimpleClass(1, "S", 1L, 0.2), 12), 0))
}
