package com.tpm.batch1.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import com.tpm.batch1.ace.R
import com.tpm.batch1.di.Injection
import com.tpm.batch1.ui.fragments.*
import kotlinx.android.synthetic.main.activity_main_student.*
import kotlinx.android.synthetic.main.activity_main_trainer.*

class MainActivity : AppCompatActivity() {
    companion object{
        fun newIntent(context: Context): Intent
        {
            val intent = Intent(context,MainActivity::class.java)
            return intent
        }
    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_student_home -> {
                mainToolbar.setTitle(R.string.tpm)
                setSupportActionBar(mainToolbar)
                supportFragmentManager.beginTransaction().replace(R.id.fragment,StudentHomeFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_trainer_home -> {

                supportFragmentManager.beginTransaction().replace(R.id.fragment,TrainerHomeFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_activities -> {
                mainToolbar.setTitle(R.string.title_activities)
                setSupportActionBar(mainToolbar)
                supportFragmentManager.beginTransaction().replace(R.id.fragment,ActivitiesFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_learningMaterial -> {
                mainToolbar.setTitle(R.string.title_learningMaterial)
                setSupportActionBar(mainToolbar)
                supportFragmentManager.beginTransaction().replace(R.id.fragment,LearningMaterialsFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                mainToolbar.setTitle(R.string.title_profile)
                setSupportActionBar(mainToolbar)
                supportFragmentManager.beginTransaction().replace(R.id.fragment,ProfileFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_report -> {
                mainToolbar.setTitle(R.string.title_report)
                setSupportActionBar(mainToolbar)
                supportFragmentManager.beginTransaction().replace(R.id.fragment,FeedbackFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_logout)
        {
            startActivity(LoginActivity.newIntent(this))
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var user_type = "student"

        if(user_type.equals("student"))
        {
            setContentView(R.layout.activity_main_student)
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
            mainToolbar.setTitle(R.string.tpm)
            setSupportActionBar(mainToolbar)
            //navViewStudent.setupWith
            navViewStudent.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
            supportFragmentManager.beginTransaction().replace(R.id.fragment,StudentHomeFragment()).commit()
        }
        else
        {
            setContentView(R.layout.activity_main_trainer)
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
            navViewTrainer.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
            supportFragmentManager.beginTransaction().replace(R.id.fragment,TrainerHomeFragment()).commit()
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) Injection.hideSystemUI(window)
    }

}
