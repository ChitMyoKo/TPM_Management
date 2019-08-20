package com.tpm.batch1.data.repositories.SignInRepository

import io.reactivex.Observable

interface SignInRepository {

    fun checkValidate(): Observable<String>
}