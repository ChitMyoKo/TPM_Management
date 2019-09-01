package com.tpm.batch1.data.repositories.TrainerRepository

import com.tpm.batch1.network.network_response.Trainer
import io.reactivex.Observable

interface TrainerRepository {
    fun getTrainerList(trackId : String) : Observable<List<com.tpm.batch1.network.network_response.trainer.Trainer>>
}