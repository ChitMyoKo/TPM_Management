package com.tpm.batch1.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import com.tpm.batch1.ace.R
import com.tpm.batch1.di.Injection
import com.tpm.batch1.network.network_response.profile.Profile
import com.tpm.batch1.ui.MySharedPreference
import com.tpm.batch1.ui.fragments.*
import kotlinx.android.synthetic.main.activity_main_student.*
import kotlinx.android.synthetic.main.activity_main_student.mainToolbar
import kotlinx.android.synthetic.main.activity_normal_user.*

class MainActivity : AppCompatActivity() {

    lateinit var pref : MySharedPreference
    companion object {
        var type = 0
        const val EXTRA_PROFILE = "profile"
        var profileData : Profile? = null

        fun newIntent(context: Context,profile : Profile): Intent {
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra(EXTRA_PROFILE,profile)
            return intent
        }
    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_student_home -> {
                mainToolbar.setTitle(R.string.tpm)
                setSupportActionBar(mainToolbar)
                supportFragmentManager.beginTransaction().replace(R.id.fragment, StudentHomeFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_activities -> {
                mainToolbar.setTitle(R.string.title_activities)
                setSupportActionBar(mainToolbar)
                supportFragmentManager.beginTransaction().replace(R.id.fragment, ActivitiesFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_learningMaterial -> {
                mainToolbar.setTitle(R.string.title_learningMaterial)
                setSupportActionBar(mainToolbar)
                supportFragmentManager.beginTransaction().replace(R.id.fragment, LearningMaterialsFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                mainToolbar.setTitle(R.string.title_profile)
                setSupportActionBar(mainToolbar)
                supportFragmentManager.beginTransaction().replace(R.id.fragment, ProfileFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_report -> {
                mainToolbar.setTitle(R.string.title_report)
                setSupportActionBar(mainToolbar)
                supportFragmentManager.beginTransaction().replace(R.id.fragment, FeedbackFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_logout) {
            pref.saveUserType(2)
            startActivity(LoginActivity.newIntent(this))
            finish()
        }
        if (item.itemId == R.id.menu_student) {
            startActivity(LoginActivity.newIntent((this)))
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if (type == 1)
            menuInflater.inflate(R.menu.menu, menu)
        else
            menuInflater.inflate(R.menu.normal_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        pref = MySharedPreference.getInstance(this)
        type = pref.getUserType()
        if(type!= 1 && type != 2)
        {
            type = 2
        }
        super.onCreate(savedInstanceState)
        profileData = intent.getSerializableExtra(EXTRA_PROFILE) as Profile?
        if (type == 1) {
            setContentView(R.layout.activity_main_student)
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
            mainToolbar.setTitle(R.string.tpm)
            setSupportActionBar(mainToolbar)
            navViewStudent.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
            supportFragmentManager.beginTransaction().replace(R.id.fragment, StudentHomeFragment()).commit()
        } else {
            setContentView(R.layout.activity_normal_user)
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
            mainToolbar.setTitle(R.string.title_activities)
            setSupportActionBar(mainToolbar)
            supportFragmentManager.beginTransaction().replace(R.id.fragment, ActivitiesFragment()).commit()
        }

    }


    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) Injection.hideSystemUI(window)
    }

}
