package com.tpm.batch1.ui.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.tpm.batch1.ace.R
import com.tpm.batch1.di.Injection
import com.tpm.batch1.ui.adapter.LearningMaterialsAdapter
import com.tpm.batch1.viewmodels.LearningMaterialsViewModel
import com.tpm.batch1.viewmodels.factory.LearningMaterialsViewModelFactory
import kotlinx.android.synthetic.main.fragment_learning_materials.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class LearningMaterialsFragment : Fragment() {

    private val materialsAdapter : LearningMaterialsAdapter by lazy { LearningMaterialsAdapter() }
    private val materialsViewModel : LearningMaterialsViewModel by lazy {
        ViewModelProviders.of(this,LearningMaterialsViewModelFactory(Injection.provideLearningMaterialsRepository(context!!)))
            .get(LearningMaterialsViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_learning_materials, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerMaterials.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = materialsAdapter
        }
        materialsViewModel.materialsListGetSuccessState.observe(this, Observer {
            Log.d("act",it.size.toString())
            materialsAdapter.setMaterialsList(it)
        })
        materialsViewModel.materialsListGetErrorState.observe(this, Observer {
            Toast.makeText(context,it,Toast.LENGTH_SHORT).show()
        })
        materialsViewModel.loadTrainerList()
    }


}
