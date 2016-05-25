package com.spinoco.logger.macroImpl
import com.spinoco.logger.LocationInfo

import scala.language.experimental.macros

object LoggerMacroImpl {

  def locationImpl(c: scala.reflect.macros.blackbox.Context): c.Expr[LocationInfo] = {
    import c.universe._

      c.Expr(q"""
      com.spinoco.logger.LocationInfo(
        ${c.enclosingPosition.source.file.path}
        , ${c.enclosingPosition.line}
        , ${c.enclosingPosition.column}
      )
    """)

  }

}
