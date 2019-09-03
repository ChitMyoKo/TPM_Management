package com.tpm.batch1.ui

import android.content.Context
import android.content.SharedPreferences

class MySharedPreference(context: Context) {
    companion object{
        const val USER_TYPE = "user_type"
        const val PREFERENCE_NAME = "com.tpm.batch1.ace.preference_name"

        private var instance : MySharedPreference? = null
        fun getInstance(context: Context): MySharedPreference
        {
            if(instance == null)
            {
                instance = MySharedPreference(context)
            }
            return instance as MySharedPreference
        }
    }
    private val sharePre = context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE)

    fun saveUserType(type : Int)
    {
        with(sharePre.edit())
        {
            putInt(USER_TYPE,type)
        }.apply()
    }
    fun getUserType(): Int = sharePre.getInt(USER_TYPE,0)
}