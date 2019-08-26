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
import com.tpm.batch1.ui.activities.ActivityDetailsActivity
import com.tpm.batch1.ui.adapter.ActivitiesAdapter
import com.tpm.batch1.viewmodels.ActivitiesViewModel
import com.tpm.batch1.viewmodels.factory.ActivitiesViewModelFactory
import kotlinx.android.synthetic.main.fragment_activities.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ActivitiesFragment : Fragment() {

    private val activityAdapter : ActivitiesAdapter by lazy { ActivitiesAdapter(this::onClickActivity) }
    private val activityViewModel : ActivitiesViewModel by lazy {
        ViewModelProviders.of(this,ActivitiesViewModelFactory(Injection.provideActivityRepository(context!!)))
            .get(ActivitiesViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_activities, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerActivity.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = activityAdapter
        }
        activityViewModel.activityListGetSuccessState.observe(this, Observer {
            Log.d("act",it.size.toString())
            Log.d("name",it[0].title)
            activityAdapter.setActivityList(it)
        })
        activityViewModel.activityListGetErrorState.observe(this, Observer {
            Log.d("errMsg",it)
            Toast.makeText(context,it,Toast.LENGTH_SHORT).show()
        })
        activityViewModel.loadTrainerList()
    }
    private fun onClickActivity(){
        startActivity(ActivityDetailsActivity.newIntent(context!!))

    }

}
