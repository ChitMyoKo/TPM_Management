package com.tpm.batch1.data.repositories.ProfileRepository

import com.tpm.batch1.network.network_response.profile.Profile
import io.reactivex.Observable

interface ProfileRepository {
    fun getProfile(studentId : String) : Observable<Profile>
}