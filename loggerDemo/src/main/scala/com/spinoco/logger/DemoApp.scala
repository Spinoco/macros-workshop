package com.spinoco.logger

import scala.util.Random

object DemoApp extends App {
  def sort(a: List[Int]): List[Int] = {
    if (a.length < 2)
      a
    else {
      val pivot = a(a.length / 2)
      log("pivot", pivot)
      sort(a.filter(_ < pivot)) :::
        a.filter(_ == pivot) :::
        sort(a.filter(_ > pivot))
    }
  }

  val xs = (0 to 20).map(_ => Random.nextInt(100)).toList
  log(xs)
  log(sort(xs))
}
