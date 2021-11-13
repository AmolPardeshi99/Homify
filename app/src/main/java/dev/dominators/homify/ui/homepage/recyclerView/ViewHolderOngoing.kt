package dev.dominators.homify.ui.homepage.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import dev.dominators.homify.R
import dev.dominators.homify.databinding.ItemlayoutOngoingBinding
import dev.dominators.homify.datamodel.Jobs

class ViewHolderOngoing(var itemlayoutOngoingBinding: ItemlayoutOngoingBinding):RecyclerView.ViewHolder(itemlayoutOngoingBinding.root) {

    fun setDataToItem(jobs: Jobs){
     itemlayoutOngoingBinding.job = jobs
    }
}

class AdapterOnGoing(private val list: List<Jobs>):RecyclerView.Adapter<ViewHolderOngoing>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderOngoing {
//        var view = LayoutInflater.from(parent.context).inflate(R.layout.itemlayout_ongoing,parent,false)
        return ViewHolderOngoing(DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.itemlayout_ongoing,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolderOngoing, position: Int) {
       val job = list[position]
        holder.setDataToItem(job)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}