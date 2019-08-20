package com.tpm.batch1.ui.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.tpm.batch1.ace.R
import com.tpm.batch1.data.repositories.CourseRepository.CourseRepository
import com.tpm.batch1.di.Injection
import com.tpm.batch1.ui.adapter.CourseAdapter
import com.tpm.batch1.viewmodels.CourseViewModel
import com.tpm.batch1.viewmodels.factory.CourseViewModelFactory
import kotlinx.android.synthetic.main.activity_course.*

class CourseActivity : AppCompatActivity() {

    companion object{
        fun newIntent(context: Context): Intent
        {
            val intent = Intent(context,CourseActivity::class.java)
            return intent
        }
    }
    private val courseAdapter : CourseAdapter by lazy { CourseAdapter(this::onClickCourseItem) }
    private val courseViewModel : CourseViewModel by lazy {
        ViewModelProviders.of(this,CourseViewModelFactory(Injection.provideCourseRepository(this)))
            .get(CourseViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)

        recyclerCourse.apply {
            layoutManager = LinearLayoutManager(this@CourseActivity)
            adapter = courseAdapter
        }
        courseViewModel.courseListGetSuccessState.observe(this, Observer {
            Log.d("size",it[1])
            courseAdapter.setCourseList(it)
        })
        courseViewModel.courseListGetErrorState.observe(this, Observer {
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
        })
        courseViewModel.loadCourseList()
    }
    private fun onClickCourseItem()
    {
        startActivity(CourseDetailsActivity.newIntent(this))
        Toast.makeText(this,"Click Item",Toast.LENGTH_SHORT).show()
    }
}
