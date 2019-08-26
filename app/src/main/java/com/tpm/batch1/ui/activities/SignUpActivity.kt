package com.tpm.batch1.ui.activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.bumptech.glide.Glide
import com.tpm.batch1.ace.R
import com.tpm.batch1.di.Injection
import com.tpm.batch1.util.AppConstants
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    companion object{
        fun newIntent(context: Context): Intent
        {
            val intent = Intent(context,SignUpActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        signupToolbar.setTitle(R.string.sign_up)
        setSupportActionBar(signupToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        var track = mutableListOf<String>("Android","Java","Php")
        var trackAdapter = ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,track)
        spinTrack.adapter = trackAdapter

        spinTrack.onItemSelectedListener = object : AdapterView.OnItemSelectedListener
        {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                //
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
               Toast.makeText(this@SignUpActivity,track[p2],Toast.LENGTH_SHORT).show()
            }

        }
        ivCamera.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type ="image/*"
            if(intent.resolveActivity(packageManager)!= null)
            {
                startActivityForResult(intent,AppConstants.IMAGE_REQUEST_CODE)
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == AppConstants.IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK)
        {
            val photoUri = data!!.data
            Glide.with(this).load(photoUri).into(ivImageProfile)
        }
    }
}
