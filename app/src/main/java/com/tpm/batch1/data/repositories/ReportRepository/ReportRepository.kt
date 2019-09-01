package com.tpm.batch1.data.repositories.ReportRepository

import com.tpm.batch1.data.dataclasses.ReportData
import com.tpm.batch1.network.network_response.report.Report
import io.reactivex.Observable

interface ReportRepository {
    fun getReportMessage(reportData: ReportData) : Observable<Report>
}