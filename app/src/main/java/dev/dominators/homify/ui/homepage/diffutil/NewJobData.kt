package dev.dominators.homify.ui.homepage.diffutil

data class NewJobData(
    val createdTime:String,
    val customerName:String,
    val customerAdd:String,
    val newJobTime:String,
    val newJobDate:String,
    val customerMoNo :Int,
    val customerReq:String,
    val paidAmt:Float,
    val advanceAmt:Float,
    val bookingAmt:Float
)
//{
//    override fun equals(other: Any?): Boolean {
//        if (javaClass != other?.javaClass) return false
//        val newJobData = other as NewJobData
//        if (createdTime = newJobTime)
//    }
//}
