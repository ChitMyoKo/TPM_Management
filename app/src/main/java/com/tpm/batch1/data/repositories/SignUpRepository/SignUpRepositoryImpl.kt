package com.tpm.batch1.data.repositories.SignUpRepository

import android.content.Context
import com.tpm.batch1.data.dataclasses.SignupData
import com.tpm.batch1.network.ApiService
import com.tpm.batch1.util.Utils
import io.reactivex.Observable

class SignUpRepositoryImpl (
    private val context: Context,
    private val apiService: ApiService
): SignUpRepository {
    override fun checkValidate(signUpData: SignupData): Observable<String> {
        if (Utils.isOnline(context ))
        {
            return  apiService.signup(signUpData)
        }
        else
        {
            return apiService.signup(signUpData)
        }
    }
}