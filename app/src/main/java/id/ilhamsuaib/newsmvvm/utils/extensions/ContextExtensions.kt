package id.ilhamsuaib.newsmvvm.utils.extensions

import android.content.Context
import android.widget.Toast

/**
 * Created by @ilhamsuaib on 11/01/19.
 * github.com/ilhamsuaib
 */

fun Context.toast(message: String?) = message?.let {
    Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
}