package com.tpm.batch1.data.repositories.SignUpRepository

import com.tpm.batch1.data.dataclasses.SignupData
import io.reactivex.Observable

interface SignUpRepository {
    fun checkValidate(signUpData : SignupData): Observable<String>
}