package com.tpm.batch1.network

import com.tpm.batch1.data.dataclasses.ReportData
import com.tpm.batch1.network.network_response.learning_material.LearningMaterial
import com.tpm.batch1.network.network_response.profile.Profile
import com.tpm.batch1.network.network_response.activities.Activity
import com.tpm.batch1.network.network_response.course.Course
import com.tpm.batch1.network.network_response.report.Report
import com.tpm.batch1.network.network_response.team_member.TeamMember
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
    fun loadTeamMemberList(@Path("teamId") teamId: String)  :Observable<List<TeamMember>>

    @GET("gettrainer/{trackId}")
    fun loadTrainerList(@Path("trackId") trackId : String) : Observable<List<com.tpm.batch1.network.network_response.trainer.Trainer>>

    @GET("learningmaterials/{trackId}")
    fun loadLearningMaterialList(@Path("trackId") trackId: String) : Observable<List<LearningMaterial>>

    @POST("")
    fun sendReport(@Body reportData : ReportData): Observable<Report>

    @GET("getcoursedetails/{trackId}")
    fun loadCourseList(@Path("trackId") trackId : String) : Observable<List<Course>>

    /* @GET("getassignments/{trackId}")
     fun loadAssignmentList(@Path("trackId") trackId: String) : Observable<List<Assignment>>

     @POST("")
     fun uploadAssignment(@Body assignmentFile : Activity) : Observable<Activity>


     */

}