package com.tpm.batch1.ui.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.tpm.batch1.ace.R
import com.tpm.batch1.di.Injection
import com.tpm.batch1.ui.adapter.CourseDetailsAdapter
import com.tpm.batch1.viewmodels.CourseDetailsViewModel
import com.tpm.batch1.viewmodels.factory.CourseDetailsViewModelFactory
import kotlinx.android.synthetic.main.activity_course_details.*

class CourseDetailsActivity : AppCompatActivity() {
    companion object{
        fun newIntent(context: Context): Intent
        {
            val intent = Intent(context,CourseDetailsActivity::class.java)
            return intent
        }
    }

    private val courseDetailsAdapter : CourseDetailsAdapter by lazy { CourseDetailsAdapter() }
    private val courseDetailsViewModel : CourseDetailsViewModel by lazy {
        ViewModelProviders.of(this, CourseDetailsViewModelFactory(Injection.provideCourseDetailsRepository(this)))
            .get(CourseDetailsViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_details)

        recyclerCourseDetails.apply {
            layoutManager = LinearLayoutManager(this@CourseDetailsActivity)
            adapter = courseDetailsAdapter
        }
        courseDetailsViewModel.courseDetailsListGetSuccessState.observe(this, Observer {
            courseDetailsAdapter.setCourseDetailsList(it)
            Log.d("details size",it.size.toString())
        })
        courseDetailsViewModel.courseDetailsListGetErrorState.observe(this, Observer {
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
        })
        courseDetailsViewModel.loadCourseDetailsList()
    }
}
