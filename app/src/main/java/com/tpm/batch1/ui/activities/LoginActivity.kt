package com.tpm.batch1.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tpm.batch1.ace.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnSignIn.setOnClickListener {
            startActivity(MainActivity.newIntent(this))
        }

        tvSignUp.setOnClickListener {
            startActivity(SignUpActivity.newIntent(this))
        }
    }
}
