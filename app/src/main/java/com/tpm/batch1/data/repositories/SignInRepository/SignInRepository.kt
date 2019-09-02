package com.tpm.batch1.data.repositories.SignInRepository

import com.tpm.batch1.data.dataclasses.SignInData
import io.reactivex.Observable

interface SignInRepository {

    fun checkValidate(signInData : SignInData): Observable<String>
}