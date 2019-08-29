package com.tpm.batch1.ui.fragments


import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

import com.tpm.batch1.ace.R
import com.tpm.batch1.di.Injection
import com.tpm.batch1.network.network_response.activities.Activity
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
            Glide.with(this)
                .load(R.drawable.loading)
                .into(loading)
            val timer = object: CountDownTimer(1500, 1000) {
                override fun onTick(millisUntilFinished: Long) {

                }

                override fun onFinish() {
                    loading.visibility = View.INVISIBLE
                    lyActivity.visibility = View.VISIBLE
                }
            }
            timer.start()
        })
        activityViewModel.activityListGetErrorState.observe(this, Observer {
            Log.d("errMsg",it)
            Toast.makeText(context,it,Toast.LENGTH_SHORT).show()
        })
        activityViewModel.loadActivityList()
    }
    private fun onClickActivity(activity : Activity){
        startActivity(ActivityDetailsActivity.newIntent(context!!,activity))

    }

}
