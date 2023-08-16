package com.reyndev.simpleplan.data

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.reyndev.simpleplan.models.Plan

class DataSource {
    companion object {
        private val plans: MutableList<Plan> = mutableListOf()
        private var id: Int = 0

        // Add new plan
        fun addPlan(plan: Plan) {
            plan.id = id++

            plans.add(plan)
        }

        // Get a plan element at index
        fun getPlan(index: Int): Plan = plans[index]

        // Return plan by ID
        fun getPlanById(id: Int): Plan = plans.find { it.id == id }!!

        // Return a list of plans
        fun getPlanList(): MutableList<Plan> = plans

        // Return the size of the data
        fun getPlanSize(): Int = plans.size
    }
}