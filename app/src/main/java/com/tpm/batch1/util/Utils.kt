package com.tpm.batch1.util

import android.content.Context
import android.net.ConnectivityManager

object Utils {

    fun isOnline(context: Context) : Boolean
    {
        val conManager = context.getSystemService("connectivity") as ConnectivityManager
        val networkInfo = conManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}