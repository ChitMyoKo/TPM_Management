package com.tpm.batch1.di

import android.content.Context
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.tpm.batch1.data.repositories.CourseDetailsRepository.CourseDetailsRepository
import com.tpm.batch1.data.repositories.CourseDetailsRepository.CourseDetailsRepositoryImpl
import com.tpm.batch1.data.repositories.CourseRepository.CourseRepository
import com.tpm.batch1.data.repositories.CourseRepository.CourseRepositoryImpl
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
            .build()
        return retrofit.create(ApiService::class.java)
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
}