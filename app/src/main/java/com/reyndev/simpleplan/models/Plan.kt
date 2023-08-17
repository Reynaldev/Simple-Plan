package com.reyndev.simpleplan.models

data class Plan(
    var desc: String,
    var isDone: Boolean
) {
    var id: Int = 0
}