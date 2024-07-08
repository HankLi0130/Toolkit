package app.hankdev.toolkit.function

import android.content.Context
import androidx.appcompat.app.AlertDialog
import app.hankdev.toolkit.NO_RESOURCE
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

/**
 *  example: GMT-5
 */
fun getTimeZoneAbbreviation(): String {
    val format = DateTimeFormatter.ofPattern("O")
    return ZonedDateTime.now().format(format)
}

fun showMaterialAlertDialog(
    context: Context,
    overrideThemeResId: Int = NO_RESOURCE,
    setBuilder: MaterialAlertDialogBuilder.() -> Unit
): AlertDialog {
    val builder = MaterialAlertDialogBuilder(context, overrideThemeResId)
    builder.setBuilder()
    return builder.show()
}