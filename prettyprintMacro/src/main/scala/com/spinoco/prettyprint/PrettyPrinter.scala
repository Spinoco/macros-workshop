package com.spinoco.prettyprint

import scala.reflect.ClassTag

/**
  * Created with IntelliJ IDEA.
  * User: raulim
  * Date: 24.5.16
  */

trait PrettyPrinter[A] {
  def print(a: A, offset: Int): String
}

object PrettyPrinter {
  def asString[A](implicit classTag: ClassTag[A]): PrettyPrinter[A] = new PrettyPrinter[A] {
    override def print(a: A, offset: Int): String = {
      s" ${a.toString}: ${classTag.toString()}"
    }
  }

  implicit val intPrinter = asString[Int]
  implicit val longPrinter = asString[Long]
  implicit val stringPrinter = asString[String]
  implicit val doublePrinter = asString[Double]

}
