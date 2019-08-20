package com.tpm.batch1.data.repositories.SignInRepository

import android.content.Context
import com.tpm.batch1.network.ApiService
import com.tpm.batch1.util.Utils
import io.reactivex.Observable

class SignInRepositoryImpl(
    private val context: Context,
    private val apiService: ApiService
) : SignInRepository {
    override fun checkValidate(): Observable<String> {
        //
        if(Utils.isOnline(context))
        {

        }
        else
        {

        }
        return Observable.just("")

    }
}