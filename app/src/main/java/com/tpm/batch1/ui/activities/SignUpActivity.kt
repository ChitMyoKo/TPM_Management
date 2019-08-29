package com.tpm.batch1.ui.activities

import android.app.Activity
import android.app.DatePickerDialog
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
import java.util.*

class SignUpActivity : AppCompatActivity() {

    companion object{
        var MONTH = mutableListOf<String>("Jan","Feb","Mar","Apr","May","June","July","Aug","Oct","Nov","Dec")
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
        var image = ivCamera.drawingCache
        lyBirthday.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)


            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                // Display Selected date in textbox
                tvBirthday.setText("Birthday : " + dayOfMonth +" "+ MONTH[monthOfYear] + ", " + year)
            }, year, month, day)


            dpd.show()
        }
        btnSignUp.setOnClickListener {/*
            var userName = edtUserName.text.toString()
            var password = edtPassword.text.toString()
            var retypePassword = edtRePassword.text.toString()
            var phone = edtPhoneNumber.text.toString()
            var email = edtEmail.text.toString()
            var birthday = edtBirthday.text.toString()
            var address = edtAddress.toString()
            var fbLink = edtFBAcc.text.toString()
            var qualification = edtQualification.text.toString()

            if(userName.isEmpty())
            {
                edtUserName.error = "User name is required!"
            }
            else if(phone.isEmpty())
            {
                edtPhoneNumber.error = "Phone number is required!"
            }
            else if(email.isEmpty())
            {
                edtEmail.error = "Email is required!"
            }
            else if(birthday.isEmpty())
            {
                edtBirthday.error = "Birthday is required!"
            }
            else if(address.isEmpty())
            {
                edtAddress.error = "Address is required!"
            }
            else if(fbLink.isEmpty())
            {
                edtFBAcc.error = "Facebook account link is required!"
            }
            else if(qualification.isEmpty())
            {
                edtQualification.error = "Qualification is required!"
            }
            else if(password.isEmpty())
            {
                edtPassword.error = "Password is required!"
            }
            else if(retypePassword.isEmpty())
            {
                edtRePassword.error = "Retype-Password is required!"
            }
            else {
                if (userName.length < 2 && userName.length > 20) {
                    edtPassword.error = "User name must have between 2 characters and 15 characters."
                }
                if (password.length < 8 && password.length > 15) {
                    edtPassword.error = "Password length must have between 8 characters and 15 characters."
                }
                else if (!password.equals(retypePassword)) {
                    edtRePassword.error = "Password and Retype-Password are  not same."
                }
                if (!email.contains("@gmail.com")) {
                    edtEmail.error = "Email is wrong."
                }
                else{
                    Toast.makeText(this,"Sign  Up",Toast.LENGTH_SHORT).show()
                }
            }*/

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
