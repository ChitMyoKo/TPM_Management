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

import com.tpm.batch1.ace.R
import com.tpm.batch1.data.dataclasses.ReportData
import com.tpm.batch1.di.Injection
import com.tpm.batch1.viewmodels.ReportViewModel
import com.tpm.batch1.viewmodels.factory.ReportViewModelFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FeedbackFragment : Fragment() {

    private val reportViewModel : ReportViewModel by lazy {
        ViewModelProviders.of(this,ReportViewModelFactory(Injection.provideReportRepository(context!!)))
            .get(ReportViewModel::class.java)
    }
    private var reportData : ReportData? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feedback, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        reportViewModel.reportSuccessState.observe(this, Observer {
            Log.d("message", it.message)
        })

            reportViewModel.reportErrorState.observe(this, Observer {
                Log.d("errMsg", it)
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            })
            reportViewModel.loadReportMessage(reportData!!)
        }
}
