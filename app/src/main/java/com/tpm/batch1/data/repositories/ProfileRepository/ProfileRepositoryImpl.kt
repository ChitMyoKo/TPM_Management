package com.tpm.batch1.data.repositories.ProfileRepository

import android.content.Context
import com.tpm.batch1.network.ApiService
import com.tpm.batch1.network.network_response.Profile.Profile
import com.tpm.batch1.util.Utils
import io.reactivex.Observable

class ProfileRepositoryImpl(
    private val context: Context,
    private val apiService: ApiService
) : ProfileRepository{
    var p = Profile("a",null,"c","d","d","d","d","d",1,"as"
    ,"a","a","a","a",1,"a",
        "3",2,null)
    override fun getProfile(studentId : String): Observable<Profile> {
        if(Utils.isOnline(context))
        {
            return apiService.loadProfile(studentId)
        }
        else
        {
            return Observable.just(p)
        }

    }
}