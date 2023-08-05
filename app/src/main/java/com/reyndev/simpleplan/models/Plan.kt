package com.reyndev.simpleplan.models

data class Plan(
    val id: Int,
    var name: String,
    var desc: String,
    var isDone: Boolean
)