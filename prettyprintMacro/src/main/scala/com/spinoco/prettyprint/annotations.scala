package com.spinoco.prettyprint

import scala.annotation.StaticAnnotation
import scala.language.experimental.macros
import scala.reflect.macros.whitebox

object annotations {

  class pretty extends StaticAnnotation {
    def macroTransform(annottees: Any*): Any = macro annotations.prettyprint
  }

  def prettyprint(c: whitebox.Context)(annottees: c.Expr[Any]*): c.Expr[Any] = {
   import c.universe._
    val caseClassObj = withClassDecl(c)
    annottees.map(_.tree) match {
      case (classDecl: ClassDef) :: Nil => caseClassObj(classDecl, None)
      case (classDecl: ClassDef) :: (compDecl: ModuleDef) :: Nil => caseClassObj(classDecl, Some(compDecl))
      case other => c.abort(c.enclosingPosition, s"$other is not supported")
    }
  }

  def withClassDecl(c: whitebox.Context) = {
    import c.universe._

    (cDecl: ClassDef, compDecl: Option[ModuleDef]) => {
      cDecl match {
        case q"case class $className(..$fields) extends ..$bases { ..$body }" => caseClass(c)(cDecl, compDecl, className, fields)
        case other => c.abort(c.enclosingPosition, "Annotation is only supported on case class and/or sealed trait " + other)
      }
    }
  }

  def caseClass(c: whitebox.Context) = {
    import c.universe._
    (cDecl: ClassDef, compDecl: Option[ModuleDef], className: TypeName, fields: Seq[ValDef]) =>
      ???
  }
}
