package com.reyndev.simpleplan.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.reyndev.simpleplan.R
import com.reyndev.simpleplan.data.DataSource
import com.reyndev.simpleplan.models.Plan

class AddPlanActivity : AppCompatActivity() {
    private lateinit var btnBack: ImageButton
    private lateinit var btnAddPlan: Button
    private lateinit var edtTitle: EditText
    private lateinit var edtDesc: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_plan)

        edtTitle = findViewById(R.id.edt_add_title)
        edtDesc = findViewById(R.id.edt_add_desc)

        btnBack = findViewById(R.id.btn_add_back)
        btnBack.setOnClickListener {
            finish()
        }

        btnAddPlan = findViewById(R.id.btn_add_submit)
        btnAddPlan.setOnClickListener {
            val plan = Plan(
                edtTitle.text.toString(),
                edtDesc.text.toString(),
                false
            )

            DataSource.addPlan(plan)

            finish()
        }

    }
}