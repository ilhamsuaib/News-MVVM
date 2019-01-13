package id.ilhamsuaib.newsmvvm.utils.extensions

import android.util.Log
import com.google.gson.Gson

/**
 * Created by @ilhamsuaib on 11/01/19.
 * github.com/ilhamsuaib
 */

fun Any?.toJson() = Gson().toJsonTree(this)

inline fun <reified T> T.logD(msg: String?) {
    val tag = T::class.java.simpleName
    Log.d(tag, msg)
}

inline fun <reified T> T.logE(msg: String?) {
    val tag = T::class.java.simpleName
    Log.e(tag, msg)
}