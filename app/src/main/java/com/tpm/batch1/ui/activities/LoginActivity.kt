package com.tpm.batch1.ui.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.tpm.batch1.ace.R
import com.tpm.batch1.di.Injection
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    companion object{
        fun newIntent(context: Context) : Intent
        {
            val intent = Intent(context,LoginActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)


        btnSignIn.setOnClickListener {
            if(edtUsername.text.isEmpty() && edtPasword.text.isEmpty())
            {
                edtUsername.error = "User name is required!"
                edtPasword.error = "Password is required!"
            }
            else if(edtUsername.text.isEmpty() && !edtPasword.text.isEmpty())
            {
                edtUsername.error = "User name is required!"
            }
            else if(!edtUsername.text.isEmpty() && edtPasword.text.isEmpty())
            {
                edtPasword.error = "Password is required!"
            }
            else if(edtUsername.text.toString().length > 20)
            {
                edtUsername.error = "User name is wrong. "
            }
            else if(edtUsername.text.toString().length < 2)
            {
                edtUsername.error = "User name must have at least 2 characters."
            }
            else if(edtPasword.text.toString().length >  15)
            {
                edtPasword.error = "Password is wrong."
            }
            else if(edtPasword.text.toString().length < 8)
            {
                edtPasword.error = "Password must have at least 8 characters."
            }
            else
            {
                startActivity(MainActivity.newIntent(this))
                finish()
            }

        }

        tvSignUp.setOnClickListener {
            startActivity(SignUpActivity.newIntent(this))
        }
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) Injection.hideSystemUI(window)
    }
}
