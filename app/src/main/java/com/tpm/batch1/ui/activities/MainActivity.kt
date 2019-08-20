package com.tpm.batch1.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import com.tpm.batch1.ace.R
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
                supportFragmentManager.beginTransaction().replace(R.id.fragment,StudentHomeFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_trainer_home -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment,TrainerHomeFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_activities -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment,ActivitiesFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_learningMaterial -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment,LearningMaterialsFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment,ProfileFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_feedback -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment,FeedbackFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var user_type = "student"

        if(user_type.equals("student"))
        {
            setContentView(R.layout.activity_main_student)
            navViewStudent.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
            supportFragmentManager.beginTransaction().replace(R.id.fragment,StudentHomeFragment()).commit()
        }
        else
        {
            setContentView(R.layout.activity_main_trainer)
            navViewTrainer.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
            supportFragmentManager.beginTransaction().replace(R.id.fragment,TrainerHomeFragment()).commit()
        }

    }
}
