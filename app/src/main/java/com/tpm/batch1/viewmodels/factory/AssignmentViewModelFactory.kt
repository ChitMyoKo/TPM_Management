package com.tpm.batch1.viewmodels.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tpm.batch1.data.repositories.AssignmentRepository.AssignmentRepository
import com.tpm.batch1.viewmodels.AssignmentViewModel

class AssignmentViewModelFactory(
    private val assignmentRepo : AssignmentRepository
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AssignmentViewModel(assignmentRepo) as T
    }
}