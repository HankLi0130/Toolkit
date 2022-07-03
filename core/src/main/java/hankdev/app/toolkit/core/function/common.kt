package hankdev.app.toolkit.core.function

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

/**
 *  example: GMT-5
 */
fun getTimeZoneAbbreviation(): String {
    val format = DateTimeFormatter.ofPattern("O")
    return ZonedDateTime.now().format(format)
}