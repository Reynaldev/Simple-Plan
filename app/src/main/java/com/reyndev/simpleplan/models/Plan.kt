package com.reyndev.simpleplan.models

data class Plan(
    var title: String,
    var desc: String,
    var isDone: Boolean
) {
    var id: Int = 0
}