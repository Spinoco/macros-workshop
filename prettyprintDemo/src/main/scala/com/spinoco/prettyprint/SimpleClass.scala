package com.spinoco.prettyprint

import com.spinoco.prettyprint.annotations.pretty

@pretty
case class SimpleClass(
  i: Int
  , s: String
  , l: Long
  , d: Double
)

object SimpleClass {
  val x = 5

  def abc(i: Int) = i.toString
}


@pretty
case class SecondClass(
  a: SimpleClass
  , b: Int
)
