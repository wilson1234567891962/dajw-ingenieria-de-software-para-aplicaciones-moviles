package com.co.retrofit.app.feature.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.co.retrofit.app.R
import com.co.retrofit.app.databinding.AlbumOfCollectorItemBinding
import com.co.retrofit.app.feature.model.dto.Album

class   AlbumsOfCollectorAdapter(private val fragment: Fragment) : RecyclerView.Adapter<AlbumsOfCollectorAdapter.AlbumsOfCollectorViewHolder>(){

    var albums_of_collector :List<Album> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumsOfCollectorViewHolder {
        val withDataBinding: AlbumOfCollectorItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            AlbumsOfCollectorViewHolder.LAYOUT,
            parent,
            false)
        return AlbumsOfCollectorViewHolder(withDataBinding)
    }

    override fun onBindViewHolder(holder: AlbumsOfCollectorViewHolder, position: Int) {

        holder.viewDataBinding.also {

            val albumImg = albums_of_collector[position]

            Glide.with(fragment)
                .load(albumImg.cover.toUri().buildUpon().scheme("https").build())
                .apply(RequestOptions.circleCropTransform().placeholder(R.drawable.loading_animation).diskCacheStrategy(DiskCacheStrategy.ALL).error(R.drawable.ic_broken_image))
                .into(holder.ivDishImage)

            it.albumOfCollector = albums_of_collector[position]
        }
    }

    override fun getItemCount(): Int {
        return albums_of_collector.size
    }


    class AlbumsOfCollectorViewHolder(val viewDataBinding: AlbumOfCollectorItemBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {
        val ivDishImage = viewDataBinding.ivDishImage
        companion object {
            @LayoutRes
            val LAYOUT = R.layout.album_of_collector_item
        }
    }


}