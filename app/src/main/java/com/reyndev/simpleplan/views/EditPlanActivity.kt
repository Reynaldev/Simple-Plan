package com.reyndev.simpleplan.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.reyndev.simpleplan.R
import com.reyndev.simpleplan.data.DataSource
import com.reyndev.simpleplan.data.DataSource.Companion.deletePlan
import com.reyndev.simpleplan.models.Plan

class EditPlanActivity : AppCompatActivity() {
    private lateinit var edtEditPlan: TextView
    private lateinit var btnBack: ImageButton
    private lateinit var btnDelete: Button
    private lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_plan)

        // Views
        edtEditPlan = findViewById(R.id.edt_edit_desc)
        btnBack = findViewById(R.id.btn_edit_back)
        btnDelete = findViewById(R.id.btn_edit_delete)
        btnSubmit = findViewById(R.id.btn_edit_submit)

        // Intent
        val pos = intent?.extras?.getInt("POS")
        edtEditPlan.text = intent?.extras?.getString("DESC").toString()

        // OnClickListener
        btnBack.setOnClickListener { finish() }
        btnDelete.setOnClickListener {
            DataSource.deletePlan(pos!!)

            Toast.makeText(this, "Plan discarded", Toast.LENGTH_SHORT).show()

            finish()
        }
        btnSubmit.setOnClickListener {
            val plan = DataSource.getPlan(pos!!)
            plan.desc = edtEditPlan.text.toString()

            DataSource.editPlan(pos, plan)

            Toast.makeText(this, "Plan changed", Toast.LENGTH_SHORT).show()

            finish()
        }
    }
}