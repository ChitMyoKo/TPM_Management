package com.tpm.batch1.data.repositories.ProfileRepository

import android.content.Context
import com.tpm.batch1.network.ApiService
import com.tpm.batch1.network.network_response.profile.Profile
import com.tpm.batch1.network.network_response.profile.TrackNamest
import com.tpm.batch1.util.Utils
import io.reactivex.Observable

class ProfileRepositoryImpl(
    private val context: Context,
    private val apiService: ApiService
) : ProfileRepository{
    var t =TrackNamest(2,"Java")
    var p = Profile(
        "Yangon",
        null,
        "01-01-1997",
        "koko@gmail.com",
        "https://facebook.com/koko",
        "Ko",
        "Male",
        "R.drawable.user",
        1,
        "R.drawable.user",
        "Ko",
        "8/mamana(N)235643",
        "09969979091",
        "B.C.Sc",
        1,
        "Java",
        "3",
        2,t,
        null)
    override fun getProfile(studentId : String): Observable<Profile> {
        if(Utils.isOnline(context))
        {
            //return Observable.just(p)
            return apiService.loadProfile(studentId)
        }
        else
        {
            return Observable.just(p)
        }

    }
}