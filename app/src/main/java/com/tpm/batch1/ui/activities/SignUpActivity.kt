package com.tpm.batch1.ui.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.tpm.batch1.ace.R
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
    }
}
