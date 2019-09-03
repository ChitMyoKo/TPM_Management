package com.tpm.batch1.data.repositories.ReportRepository

import android.content.Context
import com.tpm.batch1.data.dataclasses.ReportData
import com.tpm.batch1.network.ApiService
import com.tpm.batch1.network.network_response.report.Report
import com.tpm.batch1.util.Utils
import io.reactivex.Observable

class ReportRepositoryImpl(
    private val context: Context,
    private val apiService: ApiService
): ReportRepository {
    var  r = Report(200,"helloworld")
    override fun getReportMessage(reportData: ReportData): Observable<Report> {
        if(Utils.isOnline(context))
        {
            //return Observable.just(r)
            return apiService.sendReport(reportData)
        }
        else
        {
            return Observable.just(r)
        }
    }
}