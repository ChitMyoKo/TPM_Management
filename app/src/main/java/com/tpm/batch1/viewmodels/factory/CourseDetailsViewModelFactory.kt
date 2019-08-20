package com.tpm.batch1.viewmodels.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.tpm.batch1.data.repositories.CourseDetailsRepository.CourseDetailsRepository
import com.tpm.batch1.viewmodels.CourseDetailsViewModel

class CourseDetailsViewModelFactory(
    private val courseDetailsRepo : CourseDetailsRepository
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CourseDetailsViewModel(courseDetailsRepo) as T
    }
}