package com.example.ramesh.justtail.adapters

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ramesh.justtail.R
import com.example.ramesh.justtail.databinding.TilerBinding
import com.example.ramesh.justtail.listeners.ListItemClickListener
import com.example.ramesh.justtail.models.Tiler
import kotlinx.android.synthetic.main.tailer_item_view.view.*

class TilersListAdapter(context: Context,tilersList:ArrayList<Tiler>):RecyclerView.Adapter<TilersListAdapter.TilersViewHolder>() {
    var lcontext=context
    var tilerList=tilersList.clone() as ArrayList<Tiler>
    var listItemClickListener:ListItemClickListener?=null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TilersListAdapter.TilersViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(lcontext)
        var categoryBinding: TilerBinding = DataBindingUtil.inflate(layoutInflater, R.layout.tailer_item_view, p0, false)
        return TilersViewHolder(categoryBinding)
    }

    override fun getItemCount(): Int {
      return tilerList.size
    }

    override fun onBindViewHolder(holder: TilersViewHolder, p1: Int) {
         holder.bind(tilerList[p1])
    }
    fun setOnItemClickListener(listItemClickListener: ListItemClickListener){
        this.listItemClickListener=listItemClickListener
    }
    inner class TilersViewHolder(val tilerBinding: TilerBinding) :RecyclerView.ViewHolder(tilerBinding.root){
        fun bind(tiler:Tiler){
           this.tilerBinding.tiler=tiler
            itemView.image.setImageResource(tiler.image)
            itemView.image_selected.setImageResource(tiler.image)
           tilerBinding.executePendingBindings()
           itemView.setOnClickListener {
               if(itemView.selected_layout.visibility==View.GONE){
                   itemView.selected_layout.visibility=View.VISIBLE
                   itemView.select_layout.visibility=View.GONE
               }else{
                   itemView.selected_layout.visibility=View.GONE
                   itemView.select_layout.visibility=View.VISIBLE
               }
               listItemClickListener!!.onClick(tiler)
           }
        }
    }


}