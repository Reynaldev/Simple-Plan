package com.reyndev.simpleplan.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.reyndev.simpleplan.R
import com.reyndev.simpleplan.adapter.PlanAdapter
import com.reyndev.simpleplan.data.DataSource
import java.util.Calendar
import java.util.Date
import java.util.GregorianCalendar

class MainActivity : AppCompatActivity() {
    private lateinit var fabAdd: FloatingActionButton
    private lateinit var tvGreet: TextView
    private lateinit var tvStatus: TextView
    private lateinit var recyclerView: RecyclerView

    private var isResumed = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Recycler view
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.setHasFixedSize(false)

        // Greet text
        tvGreet = findViewById(R.id.plan_greet)

        // Status text
        tvStatus = findViewById(R.id.plan_status)

        // Floating Action Button "Add"
        fabAdd = findViewById(R.id.fab_add_plan)
        fabAdd.setOnClickListener {
            startActivity(Intent(this, AddPlanActivity::class.java))
        }

        updateActivity()
    }

    override fun onResume() {
        super.onResume()

        if (!isResumed) {
            updateActivity()

            isResumed = true
        }
    }

    override fun onPause() {
        super.onPause()

        isResumed = false
    }

    private fun updateActivity() {
        // Recycler view
        recyclerView.adapter = PlanAdapter(this)

        // Greet text
        val calendar = GregorianCalendar().also { it.time = Date() }
        val currentTime = calendar.get(Calendar.HOUR_OF_DAY)

        if (currentTime in 4..12)
            tvGreet.text = resources.getString(R.string.greet_morning)
        else if(currentTime in 13..18)
            tvGreet.text = resources.getString(R.string.greet_afternoon)
        else
            tvGreet.text = resources.getString(R.string.greet_evening)

        // Status text
        if (DataSource.getPlanSize() > 0)
            tvStatus.text = "You have ${DataSource.getPlanSize()} plan(s), good luck!"
        else
            tvStatus.text = "You have no plans for today."
    }
}