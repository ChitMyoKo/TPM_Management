package com.tpm.batch1.ui.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.tpm.batch1.ace.R
import com.tpm.batch1.di.Injection
import com.tpm.batch1.ui.adapter.AssignmentAdapter
import com.tpm.batch1.viewmodels.AssignmentViewModel
import com.tpm.batch1.viewmodels.factory.AssignmentViewModelFactory
import kotlinx.android.synthetic.main.activity_asignment.*
import kotlinx.android.synthetic.main.browse_zipfile.view.*

class AssignmentActivity : AppCompatActivity() {
    companion object{
        fun newIntent(context: Context): Intent
        {
            val intent = Intent(context,AssignmentActivity::class.java)
            return intent
        }
    }
    private val assignmentAdapter : AssignmentAdapter by lazy { AssignmentAdapter(this::uploadZipFile) }
    private val assignmentViewModel : AssignmentViewModel by lazy {
        ViewModelProviders.of(this,AssignmentViewModelFactory(Injection.provideAssignmentRepository(this)))
            .get(AssignmentViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asignment)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        assignmentToolbar.setTitle(R.string.assignments)
        setSupportActionBar(assignmentToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerAssignment.apply {
            layoutManager = LinearLayoutManager(this@AssignmentActivity)
            adapter = assignmentAdapter
        }
        assignmentViewModel.assignmentListGetSuccessState.observe(this, Observer {
            Log.d("size",it.size.toString())
            assignmentAdapter.setAssignmentList(it)
        })
        assignmentViewModel.assignmentListGetErrorState.observe(this, Observer {
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
        })
        assignmentViewModel.loadAssignmentList()
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
    private fun uploadZipFile() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.browse_zipfile,null)
        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setPositiveButton("Upload", null)
            .setNegativeButton("Cancel", null)
        val dialog = builder.show()
        dialogView.browseZipFile.setOnClickListener {
            Toast.makeText(this,"browse",Toast.LENGTH_SHORT).show()
        }
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener({
            dialog.dismiss()
            Toast.makeText(applicationContext, "Login is submitted, verify the credential and log the user into the app", Toast.LENGTH_SHORT).show()
        })
    }

}
