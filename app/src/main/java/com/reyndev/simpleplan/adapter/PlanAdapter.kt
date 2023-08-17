package com.reyndev.simpleplan.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.reyndev.simpleplan.R
import com.reyndev.simpleplan.data.DataSource
import com.reyndev.simpleplan.models.Plan

class PlanAdapter(private val context: Context) : RecyclerView.Adapter<PlanAdapter.PlanViewHolder>() {

    class PlanViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        var planId: Int = 0
        val planDesc: TextView = view.findViewById(R.id.plan_desc)

        init {
            view.setOnClickListener {
                // Intent to EditPlanActivity
                Toast.makeText(view.context, "Item ID: $planId", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanViewHolder {
        val viewAdapter = LayoutInflater.from(parent.context)
            .inflate(R.layout.plan_item, parent, false)

        return PlanViewHolder(viewAdapter)
    }

    override fun getItemCount(): Int = DataSource.getPlanSize()

    override fun onBindViewHolder(holder: PlanViewHolder, position: Int) {
        val item = DataSource.getPlan(position)

        holder.planId = item.id
        holder.planDesc.text = item.desc
    }
}