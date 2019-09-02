package com.tpm.batch1.data.repositories.SignInRepository

import android.content.Context
import com.tpm.batch1.data.dataclasses.SignInData
import com.tpm.batch1.network.ApiService
import com.tpm.batch1.util.Utils
import io.reactivex.Observable
import okhttp3.internal.Util

class SignInRepositoryImpl(
    private val context: Context,
    private val apiService: ApiService
) : SignInRepository {
    override fun checkValidate(signInData: SignInData): Observable<String> {
        if(Utils.isOnline(context))
        {
          return  apiService.signin(signInData)
        }
        else
        {
          return  apiService.signin(signInData)
        }
    }


}