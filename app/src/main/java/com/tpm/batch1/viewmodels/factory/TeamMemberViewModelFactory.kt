package com.tpm.batch1.viewmodels.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tpm.batch1.data.repositories.TeamMemberRepository.TeamMemberRepository
import com.tpm.batch1.viewmodels.TeamMemberViewModel

class TeamMemberViewModelFactory(
    private val teamMemberRepo : TeamMemberRepository
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TeamMemberViewModel(teamMemberRepo) as T
    }
}