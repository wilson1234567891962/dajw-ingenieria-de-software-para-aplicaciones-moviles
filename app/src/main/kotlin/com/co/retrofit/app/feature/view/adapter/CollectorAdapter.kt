package com.co.retrofit.app.feature.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.co.retrofit.app.R
import com.co.retrofit.app.databinding.CollectorItemBinding
import com.co.retrofit.app.feature.model.dto.Collector
import com.co.retrofit.app.feature.view.fragments.CollectorFragmentDirections


class CollectorAdapter(private  val fragment: Fragment):
    RecyclerView.Adapter<CollectorAdapter.CollectorViewHolder>(){

    var collectors :List<Collector> = emptyList()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectorViewHolder {
        val withDataBinding: CollectorItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            CollectorViewHolder.LAYOUT,
            parent,
            false)
        return CollectorViewHolder(withDataBinding)
    }

    override fun onBindViewHolder(holder: CollectorViewHolder, position: Int) {

        holder.viewDataBinding.also {
            it.collector = collectors[position]


        }
        holder.headerLabelInitials.text = collectors[position].name.first().toString()

        holder.viewDataBinding.root.setOnClickListener {
            val action = CollectorFragmentDirections.actionNavigationCollectorToNavigationAlbumOfCollector(collectors[position].collectorId, collectors[position])
            // Navigate using that action
            holder.viewDataBinding.root.findNavController().navigate(action)
        }


    }

    override fun getItemCount(): Int {
        return collectors.size
    }


    class CollectorViewHolder( val viewDataBinding: CollectorItemBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {
        val headerLabelInitials = viewDataBinding.headerLabelInitials
        companion object {
            @LayoutRes
            val LAYOUT = R.layout.collector_item
        }

    }

}