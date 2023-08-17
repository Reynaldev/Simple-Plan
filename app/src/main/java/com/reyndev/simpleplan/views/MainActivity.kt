package com.reyndev.simpleplan.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.reyndev.simpleplan.R
import com.reyndev.simpleplan.adapter.PlanAdapter
import com.reyndev.simpleplan.data.DataSource

class MainActivity : AppCompatActivity() {
    private lateinit var fabAdd: View
    private lateinit var tvStatus: TextView
    private lateinit var recyclerView: RecyclerView

    private var isResumed = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Recycler view
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.setHasFixedSize(false)

        // Floating Action Button "Add"
        fabAdd = findViewById(R.id.fab_add_plan)
        fabAdd.setOnClickListener {
            isResumed = false

            startActivity(Intent(this, AddPlanActivity::class.java))
        }

        // Status text
        tvStatus = findViewById(R.id.plan_status)

        updateActivity()
    }

    override fun onResume() {
        super.onResume()

        if (!isResumed) {
            updateActivity()

            isResumed = true
        }
    }

    private fun updateActivity() {
        // Recycler view
        recyclerView.adapter = PlanAdapter(this)

        // Status text
        if (DataSource.getPlanSize() > 0)
            tvStatus.text = "You have ${DataSource.getPlanSize()} plan(s), good luck!"
        else
            tvStatus.text = "You have no plans for today."
    }
}