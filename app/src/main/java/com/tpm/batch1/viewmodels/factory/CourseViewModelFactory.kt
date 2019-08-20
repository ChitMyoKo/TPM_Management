package com.tpm.batch1.viewmodels.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tpm.batch1.data.repositories.CourseRepository.CourseRepository
import com.tpm.batch1.viewmodels.CourseViewModel

class CourseViewModelFactory(
    private val courseRepo : CourseRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CourseViewModel(courseRepo) as T
    }

}