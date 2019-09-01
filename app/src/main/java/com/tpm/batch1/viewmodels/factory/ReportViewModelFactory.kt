package com.tpm.batch1.viewmodels.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tpm.batch1.data.repositories.ReportRepository.ReportRepository
import com.tpm.batch1.viewmodels.ReportViewModel

class ReportViewModelFactory(
    private val reportRepo : ReportRepository
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ReportViewModel(reportRepo) as T
    }
}