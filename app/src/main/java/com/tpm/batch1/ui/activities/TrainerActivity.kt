package com.tpm.batch1.ui.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.tpm.batch1.ace.R
import com.tpm.batch1.di.Injection
import com.tpm.batch1.ui.adapter.TrainerAdapter
import com.tpm.batch1.util.Utils
import com.tpm.batch1.viewmodels.TrainerViewModel
import com.tpm.batch1.viewmodels.factory.TrainerViewModelFactory
import kotlinx.android.synthetic.main.activity_trainer.*

class TrainerActivity : AppCompatActivity() {
    companion object {
        var trackId: String = ""
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, TrainerActivity::class.java)
            return intent
        }
    }

    private val trainerAdapter: TrainerAdapter by lazy { TrainerAdapter() }
    private val trainerViewModel: TrainerViewModel by lazy {
        ViewModelProviders.of(this, TrainerViewModelFactory(Injection.provideTrainerRepository(this)))
            .get(TrainerViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trainer)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        trainerToolbar.setTitle(R.string.trainers)
        setSupportActionBar(trainerToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        trackId = "1"
        recyclerTrainer.apply {
            layoutManager = LinearLayoutManager(this@TrainerActivity)
            adapter = trainerAdapter
        }
        if (Utils.isOnline(this)) {
            trainerViewModel.trainerListGetSuccessState.observe(this@TrainerActivity, Observer {
                trainerAdapter.setTrainerList(it)
            })
            trainerViewModel.trainerListGetErrorState.observe(this, Observer {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            })
            trainerViewModel.loadTrainerList(trackId)
        } else {
            Toast.makeText(this, "Check your internet conection.", Toast.LENGTH_SHORT).show()
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
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
