package com.reyndev.simpleplan.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.reyndev.simpleplan.R
import com.reyndev.simpleplan.adapter.PlanAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var fabAdd: View
    private lateinit var fabEdit: View
    private lateinit var tvStatus: TextView
    private lateinit var recyclerView: RecyclerView

    private var isResumed = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fabAdd = findViewById(R.id.fab_add_plan)
        fabAdd.setOnClickListener {
            isResumed = false

            val intent = Intent(this, AddPlanActivity::class.java)
            startActivity(intent)
        }

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = PlanAdapter(this)
        recyclerView.setHasFixedSize(false)
    }

    override fun onResume() {
        super.onResume()

        if (!isResumed) {
            finish()
            startActivity(intent)

            isResumed = true
        }
    }
}