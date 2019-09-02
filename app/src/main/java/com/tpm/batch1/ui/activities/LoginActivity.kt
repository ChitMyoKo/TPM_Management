package com.tpm.batch1.ui.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.tpm.batch1.ace.R
import com.tpm.batch1.data.dataclasses.SignInData
import com.tpm.batch1.data.dataclasses.SignupData
import com.tpm.batch1.di.Injection
import com.tpm.batch1.util.Utils
import com.tpm.batch1.viewmodels.SigninViewModel
import com.tpm.batch1.viewmodels.factory.SigninViewModelFactory
import kotlinx.android.synthetic.main.activity_login.*
import okhttp3.internal.Util
import kotlin.math.sign

class LoginActivity : AppCompatActivity() {
    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, LoginActivity::class.java)
            return intent
        }
    }

    private val signViewModel: SigninViewModel by lazy {
        ViewModelProviders.of(this, SigninViewModelFactory(Injection.provideSignInRepository(this)))
            .get(SigninViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        btnSignIn.setOnClickListener {
            if (edtUsername.text.isEmpty() && edtPasword.text.isEmpty()) {
                edtUsername.error = "User name is required!"
                edtPasword.error = "Password is required!"
            } else if (edtUsername.text.isEmpty() && !edtPasword.text.isEmpty()) {
                edtUsername.error = "User name is required!"
            } else if (!edtUsername.text.isEmpty() && edtPasword.text.isEmpty()) {
                edtPasword.error = "Password is required!"
            } else if (edtUsername.text.toString().length > 20) {
                edtUsername.error = "User name is wrong. "
            } else if (edtUsername.text.toString().length < 2) {
                edtUsername.error = "User name must have at least 2 characters."
            } else if (edtPasword.text.toString().length > 15) {
                edtPasword.error = "Password is wrong."
            } else if (edtPasword.text.toString().length < 8) {
                edtPasword.error = "Password must have at least 8 characters."
            } else {
                /*if(Utils.isOnline(this))
                {
                    signViewModel.checkValidateState.observe(this@LoginActivity, Observer {
                        //
                    })
                    signViewModel.validateMessageState.observe(this, Observer {
                        Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                    })
                    val signInData = SignInData(edtUsername.text.toString(),edtPasword.text.toString())
                    signViewModel.checkSignInData(signInData)
                }
                else
                {
                    Toast.makeText(this,"Check your internet connection.",Toast.LENGTH_SHORT).show()
                }*/
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
