package com.spinoco

import com.spinoco.logger.macroImpl.LoggerMacroImpl

import scala.language.experimental.macros
/**
  * Created with IntelliJ IDEA.
  * User: raulim
  * Date: 24.5.16
  */
package object logger {
  implicit def locationInfo: LocationInfo = macro LoggerMacroImpl.locationImpl

  def log(body: Any)(implicit location: LocationInfo): Unit = {
    println(s"[LOG][${location.path}:${location.row}:${location.column}]: $body")
  }


}
