package com.tpm.batch1.data.repositories.ActivitiesRepository

import android.content.Context
import android.util.Log
import com.tpm.batch1.ace.R
import com.tpm.batch1.network.ApiService
import com.tpm.batch1.util.Utils
import io.reactivex.Observable

class ActivitiesRepositoryImpl(
    private val context: Context,
    private val apiService: ApiService
) : ActivitiesRepository {
    var a = com.tpm.batch1.network.network_response.activities.Activity(
        1,null,null,null,null,null,
        "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc","Where can I get some?"
    )
    var b = com.tpm.batch1.network.network_response.activities.Activity(
        1,null,null,null,null,null,
        "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc","Where can I get some?"
    )

    var c = com.tpm.batch1.network.network_response.activities.Activity(
        1,null,null,null,null,null,
        "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc","Where can I get some?"
    )

    var d = com.tpm.batch1.network.network_response.activities.Activity(
        1,null,null,null,null,null,
        "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc","Where can I get some?"
    )

    var list = mutableListOf<com.tpm.batch1.network.network_response.activities.Activity>(a,b,c,d)
        //emptyList<com.tpm.batch1.network.network_response.activities.Activity>()
    override fun getActivitiesList(): Observable<List<com.tpm.batch1.network.network_response.activities.Activity>> {
        if(Utils.isOnline(context))
        {
            Log.d("have conn","****")
            return apiService.loadActivityList()
            //return Observable.just(list)
        }
        else{
            Log.d("have not conn","****")
            return Observable.just(list)
        }
    }
}