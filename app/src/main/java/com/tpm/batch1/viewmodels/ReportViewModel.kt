package com.tpm.batch1.viewmodels

import androidx.lifecycle.MutableLiveData
import com.tpm.batch1.data.dataclasses.ReportData
import com.tpm.batch1.data.repositories.ReportRepository.ReportRepository
import com.tpm.batch1.network.network_response.report.Report
import io.reactivex.android.schedulers.AndroidSchedulers

class ReportViewModel(
    private val reportRepo : ReportRepository
) : BaseViewModel(){
    var reportSuccessState = MutableLiveData<Report>()
    var reportErrorState = MutableLiveData<String>()

    fun loadReportMessage(repotData: ReportData)
    {
        launch {
            reportRepo.getReportMessage(repotData)
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    reportSuccessState.postValue(it)
                },{
                    reportErrorState.value = it.localizedMessage
                })
        }
    }
}