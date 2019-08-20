package com.tpm.batch1.data.repositories.TrainerRepository

import android.content.Context
import com.tpm.batch1.ace.R
import com.tpm.batch1.network.ApiService
import com.tpm.batch1.network.network_response.Trainer
import com.tpm.batch1.util.Utils
import io.reactivex.Observable

class TrainerRepositoryImpl(
    private val context: Context,
    private val apiService: ApiService
) : TrainerRepository {
    override fun getTrainerList(): Observable<List<Trainer>> {
        var t1 = Trainer("Mr Kyaw Kyaw Khing","Android Developer",R.drawable.user,"kyaw@gmail.com","0945678")
        var t2 = Trainer("Mr Myo Set Paing","Android Developer",R.drawable.user,"myo@gmail.com","0945678")
        var trainerList = mutableListOf<Trainer>(t1,t2)
        if(!Utils.isOnline(context))
        {
            return Observable.just(trainerList)
        }
        else
        {
            return Observable.just(trainerList)
        }
    }
}