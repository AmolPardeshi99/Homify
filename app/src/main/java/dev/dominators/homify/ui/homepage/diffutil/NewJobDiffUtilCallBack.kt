package dev.dominators.homify.ui.homepage.diffutil

import androidx.recyclerview.widget.DiffUtil
import dev.dominators.homify.datamodel.NewJobData

class NewJobDiffUtilCallBack(
    private val oldJobList: List<NewJobData>,
    private val newJobList: List<NewJobData>
):DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldJobList.size
    }

    override fun getNewListSize(): Int {
        return newJobList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldJobList[oldItemPosition].customerName == newJobList[newItemPosition].customerName
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldJobList[oldItemPosition] == newJobList[newItemPosition]
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}