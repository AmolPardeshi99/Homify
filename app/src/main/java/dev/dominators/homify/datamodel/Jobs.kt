package dev.dominators.homify.datamodel

import java.io.Serializable

data class Jobs(
    val address:String,
    val contact:String,
    val createdAt:String,
    val date:String,
    val name:String,
    val time:String,
    val type:String,
    val id:String
):Serializable