package app.hankdev.toolkit.function

import android.Manifest.permission.ACCESS_NETWORK_STATE
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import androidx.annotation.RequiresPermission

/**
 * Check a device's network connection
 * https://stackoverflow.com/questions/57284582/networkinfo-has-been-deprecated-by-api-29
 */
@RequiresPermission(allOf = [ACCESS_NETWORK_STATE])
fun isNetworkAvailable(context: Context): Boolean {
    val connectivityManager = context.getSystemService(ConnectivityManager::class.java)

    val network = connectivityManager.activeNetwork ?: return false
    val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
    return when {
        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
        // for other device how are able to connect with Ethernet
        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
        // for check internet over Bluetooth
        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> true
        else -> false
    }
}

/**
 * Check a device's network connection
 * https://developer.android.com/training/basics/network-ops/managing#check-connection
 */
@RequiresPermission(allOf = [ACCESS_NETWORK_STATE])
fun isOnline(context: Context): Boolean {
    val connMgr = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo: NetworkInfo? = connMgr.activeNetworkInfo
    return networkInfo?.isConnected == true
}

/**
 * Copying to the Clipboard
 * https://developer.android.com/guide/topics/text/copy-paste#Copying
 */
fun copyToClipboard(context: Context, label: String, text: String) {
    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText(label, text)
    clipboard.setPrimaryClip(clip)
}