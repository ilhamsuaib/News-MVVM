package id.ilhamsuaib.newsmvvm.utils.extensions

import com.google.gson.Gson

/**
 * Created by @ilhamsuaib on 11/01/19.
 * github.com/ilhamsuaib
 */

fun Any?.toJson() = Gson().toJsonTree(this)