package app.hankdev.toolkit.function

import android.content.Intent
import android.content.Intent.ACTION_INSERT
import android.content.Intent.ACTION_SEND
import android.content.Intent.ACTION_VIEW
import android.content.Intent.EXTRA_TEXT
import android.net.Uri
import android.provider.CalendarContract
import app.hankdev.toolkit.SHARE_TYPE_TEXT

/**
 * Add a calendar event.
 * Require intent filter.
 * https://developer.android.com/guide/components/intents-common#AddEvent
 */
fun getEventAddingIntent(
    title: String,
    location: String,
    begin: Long,
    end: Long
) = Intent(ACTION_INSERT).apply {
    data = CalendarContract.Events.CONTENT_URI
    putExtra(CalendarContract.Events.TITLE, title)
    putExtra(CalendarContract.Events.EVENT_LOCATION, location)
    putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin)
    putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end)
}

/**
 * Load a web URL.
 * Require intent filter.
 * https://developer.android.com/guide/components/intents-common#ViewUrl
 */
fun getLoadWebUrlIntent(url: String) = Intent(ACTION_VIEW, Uri.parse(url))

/**
 * Sending text content
 * https://developer.android.com/training/sharing/send#send-text-content
 */
fun getSendTextIntent(text: String, type: String = SHARE_TYPE_TEXT) = Intent().apply {
    action = ACTION_SEND
    putExtra(EXTRA_TEXT, text)
    this.type = type
}