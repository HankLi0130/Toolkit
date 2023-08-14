package app.hankdev.toolkit.ui

import android.content.DialogInterface
import android.widget.Toast
import androidx.annotation.ArrayRes
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import app.hankdev.toolkit.NO_RESOURCE
import com.google.android.material.dialog.MaterialAlertDialogBuilder

fun Fragment.showListDialog(
    @StringRes titleId: Int = NO_RESOURCE,
    @ArrayRes itemsId: Int,
    cancelable: Boolean = false,
    listener: (DialogInterface, Int) -> Unit
) {
    val title = if (titleId == NO_RESOURCE) null else getString(titleId)
    MaterialAlertDialogBuilder(requireContext())
        .setTitle(title)
        .setCancelable(cancelable)
        .setItems(itemsId, listener)
        .create()
        .show()
}

fun Fragment.showListDialog(
    title: String? = null,
    items: Array<out CharSequence>,
    cancelable: Boolean = false,
    listener: (DialogInterface, Int) -> Unit
) {
    MaterialAlertDialogBuilder(requireContext())
        .setTitle(title)
        .setCancelable(cancelable)
        .setItems(items, listener)
        .create()
        .show()
}

fun Fragment.showMessageDialog(
    @StringRes titleId: Int = NO_RESOURCE,
    @StringRes messageId: Int,
    @StringRes buttonTextId: Int = android.R.string.ok,
    cancelable: Boolean = false,
    listener: (DialogInterface, Int) -> Unit = { dialog, _ -> dialog.dismiss() }
) {
    val title = if (titleId == NO_RESOURCE) null else getString(titleId)
    MaterialAlertDialogBuilder(requireContext())
        .setTitle(title)
        .setMessage(messageId)
        .setCancelable(cancelable)
        .setPositiveButton(buttonTextId, listener)
        .create()
        .show()
}

fun Fragment.showMessageDialog(
    title: String? = null,
    message: String? = null,
    buttonText: String,
    cancelable: Boolean = false,
    listener: (DialogInterface, Int) -> Unit = { dialog, _ -> dialog.dismiss() }
) {
    MaterialAlertDialogBuilder(requireContext())
        .setTitle(title)
        .setMessage(message)
        .setCancelable(cancelable)
        .setPositiveButton(buttonText, listener)
        .create()
        .show()
}

fun Fragment.showToast(text: CharSequence, duration: Int = Toast.LENGTH_LONG) =
    Toast.makeText(requireContext(), text, duration).show()

fun Fragment.showToast(@StringRes resId: Int, duration: Int = Toast.LENGTH_LONG) =
    Toast.makeText(requireContext(), resId, duration).show()

fun Fragment.getColor(@ColorRes resId: Int) = ContextCompat.getColor(requireContext(), resId)
