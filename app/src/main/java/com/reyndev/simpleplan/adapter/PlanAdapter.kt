package com.reyndev.simpleplan.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.reyndev.simpleplan.R
import com.reyndev.simpleplan.data.DataSource
import com.reyndev.simpleplan.models.Plan
import com.reyndev.simpleplan.views.EditPlanActivity

class PlanAdapter(private val context: Context) : RecyclerView.Adapter<PlanAdapter.PlanViewHolder>() {

    class PlanViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val planDesc: TextView = view.findViewById(R.id.plan_desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanViewHolder {
        val viewAdapter = LayoutInflater.from(parent.context)
            .inflate(R.layout.plan_item, parent, false)

        return PlanViewHolder(viewAdapter)
    }

    override fun getItemCount(): Int = DataSource.getPlanSize()

    override fun onBindViewHolder(holder: PlanViewHolder, position: Int) {
        val item = DataSource.getPlan(position)
        val context = holder.itemView.context

        holder.planDesc.text = item.desc

        holder.itemView.setOnClickListener {
            val intent = Intent(context, EditPlanActivity::class.java)
            intent.putExtra("POS", position)
            intent.putExtra("DESC", holder.planDesc.text)
            context.startActivity(intent)
        }
    }
}