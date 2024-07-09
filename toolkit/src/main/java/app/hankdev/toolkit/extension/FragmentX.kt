package app.hankdev.toolkit.extension

import android.content.Intent
import androidx.annotation.ColorRes
import androidx.annotation.StyleRes
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import app.hankdev.toolkit.NO_RESOURCE
import app.hankdev.toolkit.SHARE_TYPE_TEXT
import app.hankdev.toolkit.function.copyToClipboard
import app.hankdev.toolkit.function.getAddingCalendarEventIntent
import app.hankdev.toolkit.function.getLoadWebUrlIntent
import app.hankdev.toolkit.function.getSendTextIntent
import app.hankdev.toolkit.function.showAlertDialog
import app.hankdev.toolkit.function.showMaterialAlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder

fun Fragment.showMaterialAlertDialog(
    overrideThemeResId: Int = NO_RESOURCE,
    setBuilder: MaterialAlertDialogBuilder.() -> Unit
): AlertDialog = showMaterialAlertDialog(requireContext(), overrideThemeResId, setBuilder)

fun Fragment.showAlertDialog(
    @StyleRes themeResId: Int = NO_RESOURCE,
    setBuilder: AlertDialog.Builder.() -> Unit
): AlertDialog = showAlertDialog(requireContext(), themeResId, setBuilder)

fun Fragment.getColor(@ColorRes resId: Int) = ContextCompat.getColor(requireContext(), resId)

fun Fragment.copyToClipboard(label: String, text: String) {
    copyToClipboard(requireContext(), label, text)
}

/**
 * Add a calendar event.
 * Require intent filter.
 * https://developer.android.com/guide/components/intents-common#AddEvent
 */
fun Fragment.addCalendarEvent(title: String, location: String, begin: Long, end: Long) {
    val intent = getAddingCalendarEventIntent(title, location, begin, end)
    if (intent.resolveActivity(requireContext().packageManager) != null) {
        startActivity(intent)
    }
}

/**
 * adding a <queries> declaration to your manifest when calling this method
 * https://developer.android.com/guide/components/intents-common#ViewUrl
 */
fun Fragment.openWebPage(url: String) {
    val intent = getLoadWebUrlIntent(url)
    if (intent.resolveActivity(requireContext().packageManager) != null) {
        startActivity(intent)
    }
}

/**
 * https://developer.android.com/training/sharing/send#send-text-content
 */
fun Fragment.shareText(text: String, type: String = SHARE_TYPE_TEXT) {
    val intent = getSendTextIntent(text, type)
    val shareIntent = Intent.createChooser(intent, null)
    startActivity(shareIntent)
}