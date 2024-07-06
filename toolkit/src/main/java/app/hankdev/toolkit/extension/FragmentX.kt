package app.hankdev.toolkit.extension

import android.content.Intent
import androidx.fragment.app.Fragment
import app.hankdev.toolkit.SHARE_TYPE_TEXT
import app.hankdev.toolkit.function.getLoadWebUrlIntent
import app.hankdev.toolkit.function.getSendTextIntent

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