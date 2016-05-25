package com.spinoco.prettyprint

package object pm {

  def caseClassPrinter(c: scala.reflect.macros.whitebox.Context)(className: c.TypeName, fields: Seq[c.universe.ValDef]) = {
    import c.universe._

    val argTerm = TermName("a")

      val strs = fields.map {
        case q"$_ val ${name: TermName}: $tpeName = $_" =>
        tpeName match {
          case tq"${tpe}" =>
            q""" offsetStr + ${name.toString} + " - " + implicitly[com.spinoco.prettyprint.PrettyPrinter[$tpe]].print($argTerm.$name, offset + 4) """
        }
      }

    val header = q""" ${className.toString.takeWhile(_ != '$')} + " {" """
    val footer = q""" offsetStr + "\n }" """

    q"""
      new com.spinoco.prettyprint.PrettyPrinter[$className] {

        def print(a: $className, offset: Int): String = {
          val offsetStr = " "*(offset+4)
          Seq(..${header +: strs :+ footer}).mkString("\n")
        }
      }
    """
  }

}
