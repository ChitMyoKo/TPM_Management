package com.tpm.batch1.ui.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.WindowManager
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.tpm.batch1.ace.R
import com.tpm.batch1.data.repositories.ActivitiesDetailsRepository.ActivitiesDetailsRepository
import com.tpm.batch1.di.Injection
import com.tpm.batch1.viewmodels.ActivitiesDetailsViewModel
import com.tpm.batch1.viewmodels.factory.ActivitiesDetailsViewModelFactory
import kotlinx.android.synthetic.main.activity_details.*

class ActivityDetailsActivity : AppCompatActivity() {
    companion object{
        fun newIntent(context: Context): Intent
        {
            val intent = Intent(context,ActivityDetailsActivity::class.java)
            return intent
        }
    }

    private val activityDetailsViewModel : ActivitiesDetailsViewModel by lazy {
        ViewModelProviders.of(this,ActivitiesDetailsViewModelFactory(Injection.provideActivityDetailsRepository(this)))
            .get(ActivitiesDetailsViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        activityDetailsToolbar.setTitle(R.string.activity_details)
        setSupportActionBar(activityDetailsToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        activityDetailsViewModel.activityGetSuccessState.observe(this, Observer {
            //trainerAdapter.setTrainerList(it)
            tvActivityDetailsTitle.text = it.activityTitle
            ivActivityDetailsImage.setImageResource(it.activityImage)
            tvActivityDetailsDescr.text = it.activityDesc
        })
        activityDetailsViewModel.activityGetErrorState.observe(this, Observer {
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
        })
        activityDetailsViewModel.loadActivity()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home)
        {
            onBackPressed()
            true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) Injection.hideSystemUI(window)
    }
}
