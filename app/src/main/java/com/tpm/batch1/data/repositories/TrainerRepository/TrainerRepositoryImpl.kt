package com.tpm.batch1.data.repositories.TrainerRepository

import android.content.Context
import com.tpm.batch1.ace.R
import com.tpm.batch1.network.ApiService
import com.tpm.batch1.util.Utils
import io.reactivex.Observable

class TrainerRepositoryImpl(
    private val context: Context,
    private val apiService: ApiService
) : TrainerRepository {
    override fun getTrainerList(trackId : String): Observable<List<com.tpm.batch1.network.network_response.trainer.Trainer>> {
        if(!Utils.isOnline(context))
        {
            return apiService.loadTrainerList(trackId)
        }
        else
        {
            return apiService.loadTrainerList(trackId)
        }
    }
}