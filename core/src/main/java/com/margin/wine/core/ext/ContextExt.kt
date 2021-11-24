package com.margin.wine.core.ext

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast

fun Context.toast(
    msg: Any,
    length: Int = Toast.LENGTH_SHORT
) {
    if (msg is String) toast(msg)
    else if (msg is Int) toast(getString(msg, length))
}

fun Context.toast(
    msg: String,
    length: Int = Toast.LENGTH_SHORT
) {
    Toast.makeText(this, msg, length).show()
    /*try {
        if (isOnMainThread()) {

        } else {
            Handler(Looper.getMainLooper()).post {
                Toast.makeText(this, msg, length).show()
            }
        }
    } catch (e: Exception) {

    }*/
}