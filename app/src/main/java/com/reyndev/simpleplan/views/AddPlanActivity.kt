package com.reyndev.simpleplan.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.reyndev.simpleplan.R

class AddPlanActivity : AppCompatActivity() {
    private lateinit var btnBack: ImageButton
    private lateinit var btnAddPlan: Button
    private lateinit var edtTitle: EditText
    private lateinit var edtDesc: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_plan)

        edtTitle = findViewById(R.id.edtAddTitle)
        edtDesc = findViewById(R.id.edtAddDesc)

        btnBack = findViewById(R.id.btnAddBack)
        btnBack.setOnClickListener {
            finish()
        }

        btnAddPlan = findViewById(R.id.btnAddSubmit)
        btnAddPlan.setOnClickListener {
            Toast.makeText(
                this,
                "Name: ${edtTitle.text} | Desc: ${edtDesc.text}",
                Toast.LENGTH_SHORT
            ).show()

            finish()
        }

    }
}