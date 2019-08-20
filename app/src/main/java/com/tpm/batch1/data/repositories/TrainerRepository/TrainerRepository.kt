package com.tpm.batch1.data.repositories.TrainerRepository

import com.tpm.batch1.network.network_response.Trainer
import io.reactivex.Observable

interface TrainerRepository {
    fun getTrainerList() : Observable<List<Trainer>>
}