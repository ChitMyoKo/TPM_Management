package com.tpm.batch1.ui.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.tpm.batch1.ace.R
import com.tpm.batch1.di.Injection
import com.tpm.batch1.ui.adapter.TrainerAdapter
import com.tpm.batch1.viewmodels.TrainerViewModel
import com.tpm.batch1.viewmodels.factory.TrainerViewModelFactory
import kotlinx.android.synthetic.main.activity_trainer.*

class TrainerActivity : AppCompatActivity() {
    companion object{
        fun newIntent(context: Context): Intent
        {
            val intent = Intent(context,TrainerActivity::class.java)
            return intent
        }
    }

    private val trainerAdapter : TrainerAdapter by lazy { TrainerAdapter() }
    private val trainerViewModel : TrainerViewModel by lazy {
        ViewModelProviders.of(this,TrainerViewModelFactory(Injection.provideTrainerRepository(this)))
            .get(TrainerViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trainer)

        recyclerTrainer.apply {
            layoutManager = LinearLayoutManager(this@TrainerActivity)
            adapter = trainerAdapter
        }
        trainerViewModel.trainerListGetSuccessState.observe(this, Observer {
            trainerAdapter.setTrainerList(it)
        })
        trainerViewModel.trainerListGetErrorState.observe(this, Observer {
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
        })
        trainerViewModel.loadTrainerList()
    }
}
