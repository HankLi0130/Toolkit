package app.hankdev.toolkit.extension

import android.content.Intent
import androidx.annotation.StyleRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import app.hankdev.toolkit.NO_RESOURCE
import app.hankdev.toolkit.SHARE_TYPE_TEXT
import app.hankdev.toolkit.function.copyToClipboard
import app.hankdev.toolkit.function.getAddingCalendarEventIntent
import app.hankdev.toolkit.function.getLoadWebUrlIntent
import app.hankdev.toolkit.function.getSendTextIntent
import app.hankdev.toolkit.function.showAlertDialog
import app.hankdev.toolkit.function.showMaterialAlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder

fun AppCompatActivity.showMaterialAlertDialog(
    overrideThemeResId: Int = NO_RESOURCE,
    setBuilder: MaterialAlertDialogBuilder.() -> Unit
): AlertDialog = showMaterialAlertDialog(this, overrideThemeResId, setBuilder)

fun AppCompatActivity.showAlertDialog(
    @StyleRes themeResId: Int = NO_RESOURCE,
    setBuilder: AlertDialog.Builder.() -> Unit
): AlertDialog = showAlertDialog(this, themeResId, setBuilder)

fun AppCompatActivity.copyToClipboard(label: String, text: String) {
    copyToClipboard(this, label, text)
}

/**
 * Add a calendar event.
 * Require intent filter.
 * https://developer.android.com/guide/components/intents-common#AddEvent
 */
fun AppCompatActivity.addCalendarEvent(title: String, location: String, begin: Long, end: Long) {
    val intent = getAddingCalendarEventIntent(title, location, begin, end)
    if (intent.resolveActivity(packageManager) != null) {
        startActivity(intent)
    }
}

/**
 * adding a <queries> declaration to your manifest when calling this method
 * https://developer.android.com/guide/components/intents-common#ViewUrl
 */
fun AppCompatActivity.openWebPage(url: String) {
    val intent = getLoadWebUrlIntent(url)
    if (intent.resolveActivity(packageManager) != null) {
        startActivity(intent)
    }
}

/**
 * https://developer.android.com/training/sharing/send#send-text-content
 */
fun AppCompatActivity.shareText(text: String, type: String = SHARE_TYPE_TEXT) {
    val intent = getSendTextIntent(text, type)
    val shareIntent = Intent.createChooser(intent, null)
    startActivity(shareIntent)
}