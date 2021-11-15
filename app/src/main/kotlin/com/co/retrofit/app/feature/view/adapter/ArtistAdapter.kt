package com.co.retrofit.app.feature.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.co.retrofit.app.R
import com.co.retrofit.app.databinding.ArtistItemBinding
import com.co.retrofit.data.model.dto.Artist

class ArtistAdapter(private val fragment: Fragment):
    RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder>(){

    var artists :List<Artist> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val withDataBinding: ArtistItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            ArtistViewHolder.LAYOUT,
            parent,
            false)
        return ArtistViewHolder(withDataBinding)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.viewDataBinding.also {
            it.artist = artists[position]
            val artistImg = artists[position]

            Glide.with(fragment)
                .load(artistImg.image)
                .apply(RequestOptions.circleCropTransform())
                .into(holder.ivDishImage)
        }
        // holder.viewDataBinding.root.setOnClickListener {}
    }

    override fun getItemCount(): Int {
        return artists.size
    }


    class ArtistViewHolder( val viewDataBinding: ArtistItemBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {
        val ivDishImage = viewDataBinding.ivDishImage
        companion object {
            @LayoutRes
            val LAYOUT = R.layout.artist_item
        }
    }

}