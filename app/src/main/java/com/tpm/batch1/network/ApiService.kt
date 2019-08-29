package com.tpm.batch1.network

import android.provider.ContactsContract
import com.tpm.batch1.data.dataclasses.SignInData
import com.tpm.batch1.network.network_response.Assignment
import com.tpm.batch1.network.network_response.CourseDetails
import com.tpm.batch1.network.network_response.LearningMaterial
import com.tpm.batch1.network.network_response.Profile.Profile
import com.tpm.batch1.network.network_response.Trainer
import com.tpm.batch1.network.network_response.activities.Activity
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
   /* @POST("")
    fun signin(@Body signinData : SignInData): Observable<Activity>

    @POST("")
    //fun signup(@Body signupData : )*/

    @GET("getactivities")
    fun loadActivityList(): Observable<List<Activity>>

    @GET("profile/{studentId}")
    fun loadProfile(@Path("studentId") studentId : String) : Observable<Profile>

    @GET("getteammember/{teamId}")
    fun loadTeamMemberList(@Path("teamId") teamId: String)  :Observable<List<List<String>>>

  /*  @GET("gettrainer/{trackId}")
    fun loadTrainerList(@Path("trackId") trackId : String) : Observable<List<Trainer>>

    @GET("getcourse/{trackId}")
    fun loadCourseList(@Path("trackId") trackId : String) : Observable<List<CourseDetails>>

    @GET("getassignments/{trackId}")
    fun loadAssignmentList(@Path("trackId") trackId: String) : Observable<List<Assignment>>

    @POST("")
    fun uploadAssignment(@Body assignmentFile : Activity) : Observable<Activity>

    @GET("learningmaterial/{trackId}")
    fun loadLearningMaterialList(@Path("trackId") trackId: String) : Observable<List<LearningMaterial>>

    @POST("")
    fun sendReport()*/

}