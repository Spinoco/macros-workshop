package com.spinoco.logger.macroImpl
import com.spinoco.logger.LocationInfo

import scala.language.experimental.macros

object LoggerMacroImpl {

  def locationImpl(c: scala.reflect.macros.blackbox.Context): c.Expr[LocationInfo] = {
    ???
  }

}
