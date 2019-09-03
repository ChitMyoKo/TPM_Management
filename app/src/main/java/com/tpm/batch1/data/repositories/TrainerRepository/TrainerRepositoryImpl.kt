package com.tpm.batch1.data.repositories.TrainerRepository

import android.content.Context
import com.tpm.batch1.ace.R
import com.tpm.batch1.network.ApiService
import com.tpm.batch1.network.network_response.trainer.Trainer
import com.tpm.batch1.util.Utils
import io.reactivex.Observable

class TrainerRepositoryImpl(
    private val context: Context,
    private val apiService: ApiService
) : TrainerRepository {
    var t1 = Trainer("agag@gmail.com","Aung","R.drawable.user","Aung","09987654","Java  Developer")
    var t2 = Trainer("ayeaye@gmail.com","Aye","R.drawable.user","Aye","09987654","Java  Developer")
    var tList = mutableListOf<Trainer>(t1,t2)
    override fun getTrainerList(trackId : String): Observable<List<com.tpm.batch1.network.network_response.trainer.Trainer>> {
        if(Utils.isOnline(context))
        {
            //return Observable.just(tList)
            return apiService.loadTrainerList(trackId)
        }
        else
        {
            return Observable.just(tList)
        }
    }
}