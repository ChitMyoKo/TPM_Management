package com.tpm.batch1.ui.activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.WindowManager
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.tpm.batch1.ace.R
import com.tpm.batch1.di.Injection
import com.tpm.batch1.ui.adapter.AssignmentAdapter
import com.tpm.batch1.util.AppConstants
import com.tpm.batch1.util.Utils
import com.tpm.batch1.viewmodels.AssignmentViewModel
import com.tpm.batch1.viewmodels.factory.AssignmentViewModelFactory
import kotlinx.android.synthetic.main.activity_asignment.*
import kotlinx.android.synthetic.main.browse_zipfile.*
import kotlinx.android.synthetic.main.browse_zipfile.view.*
import kotlinx.android.synthetic.main.browse_zipfile.view.btnCancel

class AssignmentActivity : AppCompatActivity() {
    companion object{
        var trackId = ""
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
    private lateinit var bottomSheetBehavior : BottomSheetBehavior<RelativeLayout>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asignment)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        assignmentToolbar.setTitle(R.string.assignments)
        setSupportActionBar(assignmentToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        trackId = "1"
        val coordinatorLayout : CoordinatorLayout = assignmentCoordinatorLayout
        val bottomSheetLayout = coordinatorLayout.bottomSheetAssignmentUpload
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetLayout)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED

        recyclerAssignment.apply {
            layoutManager = LinearLayoutManager(this@AssignmentActivity)
            adapter = assignmentAdapter
        }
        if(Utils.isOnline(this))
        {
            assignmentViewModel.assignmentListGetSuccessState.observe(this, Observer {
                Log.d("size",it.size.toString())
                assignmentAdapter.setAssignmentList(it)
            })
            assignmentViewModel.assignmentListGetErrorState.observe(this, Observer {
                Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
            })
            assignmentViewModel.loadAssignmentList(trackId)
        }
        else
        {
            Toast.makeText(this,"Check your internect connection.",Toast.LENGTH_SHORT).show()
        }


        btnCancel.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        }
        btnUpload.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        }
        tvBrowseZipFile.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)

            intent.setType("application/zip");

            if(intent.resolveActivity(packageManager)!= null)
            {
                startActivityForResult(intent, AppConstants.ZIP_FILE_REQUEST_CODE)
            }
        }
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

    /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == AppConstants.ZIP_FILE_REQUEST_CODE && resultCode == Activity.RESULT_OK)
        {
            val photoUri = data!!.data
            Toast.makeText(this,photoUri.toString(),Toast.LENGTH_SHORT).show()
           // Glide.with(this).load(photoUri).into(ivImageProfile)
        }
    }*/

    private fun uploadZipFile()
    {
        if (bottomSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)
            Log.d("Menu show","do menu item")
        } else {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED)
            Log.d("Menu not show","do menu item")
        }
    }

}
