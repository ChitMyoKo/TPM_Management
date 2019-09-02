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
import com.tpm.batch1.util.Utils
import com.tpm.batch1.viewmodels.ReportViewModel
import com.tpm.batch1.viewmodels.factory.ReportViewModelFactory
import kotlinx.android.synthetic.main.fragment_feedback.*
import okhttp3.internal.Util

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FeedbackFragment : Fragment() {

    private val reportViewModel: ReportViewModel by lazy {
        ViewModelProviders.of(this, ReportViewModelFactory(Injection.provideReportRepository(context!!)))
            .get(ReportViewModel::class.java)
    }
    private var reportData: ReportData? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feedback, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var rpData = ReportData(1, "hello", edtFeedback.text.toString(), 1, 1)
        reportData = rpData

        if (Utils.isOnline(context!!)) {

            btnSendReport.setOnClickListener {
                lyReport.visibility = View.VISIBLE
                if (edtFeedback.text.toString().isNotEmpty()) {

                    reportViewModel.reportSuccessState.observe(this, Observer {
                        if (it.code == 200) {
                            edtFeedback.setText("")
                            Toast.makeText(context!!, "Successful send report message.", Toast.LENGTH_SHORT).show()
                        }
                    })

                    reportViewModel.reportErrorState.observe(this, Observer {
                        Log.d("errMsg", it)
                        Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                    })
                    reportViewModel.loadReportMessage(reportData!!)
                } else
                    Toast.makeText(context!!, "Firstly , write your problem.", Toast.LENGTH_SHORT).show()
            }

        } else {
            lyReport.visibility = View.INVISIBLE
            Toast.makeText(context, "Check your internet connection.", Toast.LENGTH_SHORT).show()
        }
    }
}
