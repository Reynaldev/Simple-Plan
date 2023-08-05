package com.reyndev.simpleplan.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.reyndev.simpleplan.R

class MainActivity : AppCompatActivity() {
    private lateinit var fabAdd: View
    private lateinit var fabEdit: View
    private lateinit var tvStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // FAB "Add"
        fabAdd = findViewById(R.id.fabMainAdd)
        fabAdd.setOnClickListener {
            val intent = Intent(this, AddPlanActivity::class.java)
            startActivity(intent)
        }
    }
}