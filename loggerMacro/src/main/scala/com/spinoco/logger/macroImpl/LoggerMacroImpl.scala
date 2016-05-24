package com.spinoco.logger.macroImpl
import com.spinoco.logger.LocationInfo

import scala.language.experimental.macros

/**
  * Created with IntelliJ IDEA.
  * User: raulim
  * Date: 24.5.16
  */
object LoggerMacroImpl {

  def locationImpl(c: scala.reflect.macros.blackbox.Context): c.Expr[LocationInfo] = {
    import c.universe._

    ???
  }

}
