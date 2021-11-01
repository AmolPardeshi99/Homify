package dev.dominators.homify.ui.homepage.diffutil

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import dev.dominators.homify.R
import dev.dominators.homify.databinding.NewworkItemLayoutBinding


class NewJobAdapter(
    private val newJobDataList:List<NewJobData>
) : RecyclerView.Adapter<NewJobAdapter.NewJobViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewJobViewHolder {
       return NewJobViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),
           R.layout.newwork_item_layout,parent,false))
    }

    override fun onBindViewHolder(holder: NewJobViewHolder, position: Int) {
        val newJobData = newJobDataList[position]
        holder.setData(newJobData)
    }

    override fun getItemCount(): Int {
        return newJobDataList.size
    }


    class NewJobViewHolder(private val itemview : NewworkItemLayoutBinding) :
        RecyclerView.ViewHolder(itemview.root) {

        fun setData(newJobData: NewJobData) {
            itemview.jobDataModel = newJobData
        }
    }


}

//
//
//fun updateData(newJobDataList:List<NewJobData>){
//    val diffUtilCallBack = NewJobDiffUtilCallBack(jobList,newJobDataList)
//    val diffResult = DiffUtil.calculateDiff(diffUtilCallBack)
//    jobList.clear()
//    jobList.addAll(newJobDataList)
//    diffResult.dispatchUpdatesTo(this)
//}
