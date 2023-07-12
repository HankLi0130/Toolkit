package app.hankdev.toolkit.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import app.hankdev.toolkit.EMPTY
import app.hankdev.toolkit.R
import com.google.android.material.progressindicator.CircularProgressIndicator

class ProcessDialog : DialogFragment() {

    companion object {
        private const val KEY_INDICATOR_COLOR = "indicatorColor"
        private const val KEY_TITLE = "title"
        private const val KEY_CANCELABLE = "cancelable"

        fun newInstance(
            @ColorInt indicatorColor: Int,
            title: String = EMPTY,
            cancelable: Boolean = false
        ): ProcessDialog {
            val args = Bundle().apply {
                putInt(KEY_INDICATOR_COLOR, indicatorColor)
                putString(KEY_TITLE, title)
                putBoolean(KEY_CANCELABLE, cancelable)
            }

            return ProcessDialog().apply {
                arguments = args
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_process, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<CircularProgressIndicator>(R.id.view_indicator).apply {
            val indicatorColor = arguments?.getInt(KEY_INDICATOR_COLOR) ?: Color.GREEN
            this.setIndicatorColor(indicatorColor)
        }

        view.findViewById<TextView>(R.id.view_title).apply {
            val title = arguments?.getString(KEY_TITLE)
            this.isVisible = !title.isNullOrEmpty()
            this.text = title
        }

        isCancelable = arguments?.getBoolean(KEY_CANCELABLE) ?: false
    }
}