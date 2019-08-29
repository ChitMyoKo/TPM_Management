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
import com.squareup.picasso.Picasso
import com.tpm.batch1.ace.R
import com.tpm.batch1.data.repositories.ActivitiesDetailsRepository.ActivitiesDetailsRepository
import com.tpm.batch1.di.Injection
import com.tpm.batch1.network.network_response.activities.Activity
import com.tpm.batch1.viewmodels.ActivitiesDetailsViewModel
import com.tpm.batch1.viewmodels.factory.ActivitiesDetailsViewModelFactory
import kotlinx.android.synthetic.main.activity_details.*

class ActivityDetailsActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_ACTIVITY = "activity"
        fun newIntent(context: Context,
                      activity: Activity): Intent
        {
            val intent = Intent(context,ActivityDetailsActivity::class.java)
            intent.putExtra(EXTRA_ACTIVITY,activity)
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
        val activity = intent.extras!!.getSerializable(EXTRA_ACTIVITY) as Activity
        tvActivityDetailsTitle.text = activity.title
       // Picasso.get().load(activity.imageLink).into(ivActivityDetailsImage)
        Picasso.get().load(activity.picture).into(ivActivityDetailsImage)
        tvActivityDetailsDescr.text = activity.text

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
