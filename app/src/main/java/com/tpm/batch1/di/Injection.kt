package com.tpm.batch1.di

import android.content.Context
import android.view.View
import android.view.Window
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.tpm.batch1.data.repositories.ActivitiesDetailsRepository.ActivitiesDetailsRepository
import com.tpm.batch1.data.repositories.ActivitiesDetailsRepository.ActivitiesDetailsRepositoryImpl
import com.tpm.batch1.data.repositories.ActivitiesRepository.ActivitiesRepository
import com.tpm.batch1.data.repositories.ActivitiesRepository.ActivitiesRepositoryImpl
import com.tpm.batch1.data.repositories.AssignmentRepository.AssignmentRepository
import com.tpm.batch1.data.repositories.AssignmentRepository.AssignmentRepositoryImpl
import com.tpm.batch1.data.repositories.CourseDetailsRepository.CourseDetailsRepository
import com.tpm.batch1.data.repositories.CourseDetailsRepository.CourseDetailsRepositoryImpl
import com.tpm.batch1.data.repositories.CourseRepository.CourseRepository
import com.tpm.batch1.data.repositories.CourseRepository.CourseRepositoryImpl
import com.tpm.batch1.data.repositories.LearningMaterials.LearningMaterialsRepository
import com.tpm.batch1.data.repositories.LearningMaterials.LearningMaterialsRepositoryImpl
import com.tpm.batch1.data.repositories.ProfileRepository.ProfileRepository
import com.tpm.batch1.data.repositories.ProfileRepository.ProfileRepositoryImpl
import com.tpm.batch1.data.repositories.SignInRepository.SignInRepository
import com.tpm.batch1.data.repositories.SignInRepository.SignInRepositoryImpl
import com.tpm.batch1.data.repositories.TeamMemberRepository.TeamMemberRepository
import com.tpm.batch1.data.repositories.TeamMemberRepository.TeamMemberRepositoryImpl
import com.tpm.batch1.data.repositories.TrainerRepository.TrainerRepository
import com.tpm.batch1.data.repositories.TrainerRepository.TrainerRepositoryImpl
import com.tpm.batch1.network.ApiService
import com.tpm.batch1.util.AppConstants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.net.ssl.*
import javax.security.cert.CertificateException

object Injection {
    private fun provideApiService(): ApiService
    {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(AppConstants.baseUrl)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
        return retrofit.create(ApiService::class.java)
    }

    //fullscreen
    fun hideSystemUI(window: Window) {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }

    fun provideSignUpRepository(context: Context) : SignInRepository
    {
        return SignInRepositoryImpl(context, provideApiService())
    }

    fun provideTrainerRepository(context: Context) : TrainerRepository
    {
        return TrainerRepositoryImpl(context, provideApiService())
    }
    fun provideTeamMemberRepository(context: Context) : TeamMemberRepository
    {
        return TeamMemberRepositoryImpl(context, provideApiService())
    }
    fun provideCourseRepository(context: Context): CourseRepository
    {
        return CourseRepositoryImpl(context, provideApiService())
    }
    fun provideCourseDetailsRepository(context: Context): CourseDetailsRepository
    {
        return CourseDetailsRepositoryImpl(context, provideApiService())
    }
    fun provideActivityRepository(context: Context): ActivitiesRepository
    {
        return ActivitiesRepositoryImpl(context, provideApiService())
    }
    fun provideActivityDetailsRepository(context: Context): ActivitiesDetailsRepository
    {
        return ActivitiesDetailsRepositoryImpl(context, provideApiService())
    }
    fun provideAssignmentRepository(context: Context): AssignmentRepository
    {
        return AssignmentRepositoryImpl(context, provideApiService())
    }
    fun provideLearningMaterialsRepository(context: Context): LearningMaterialsRepository
    {
        return LearningMaterialsRepositoryImpl(context, provideApiService())
    }
    fun provideProfileRepository(context: Context): ProfileRepository
    {
        return ProfileRepositoryImpl(context, provideApiService())
    }
}