package com.spinoco.logger

/**
  * Describes position in file
  * @param path full path of a file
  * @param row
  * @param column
  */
case class LocationInfo(path: String, row: Int, column: Int)
