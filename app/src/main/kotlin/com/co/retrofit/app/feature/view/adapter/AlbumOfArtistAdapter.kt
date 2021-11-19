package com.co.retrofit.app.feature.view.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.co.retrofit.app.R
import com.co.retrofit.app.databinding.AlbumOfArtistItemBinding
import com.co.retrofit.app.feature.model.dto.Album

class   AlbumOfArtistAdapter(private val fragment: Fragment) : RecyclerView.Adapter<AlbumOfArtistAdapter.AlbumOfArtistViewHolder>(){

    var albums_of_artist :List<Album> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumOfArtistViewHolder {
        val withDataBinding: AlbumOfArtistItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            AlbumOfArtistViewHolder.LAYOUT,
            parent,
            false)
        return AlbumOfArtistViewHolder(withDataBinding)
    }

    override fun onBindViewHolder(holder: AlbumOfArtistViewHolder, position: Int) {

        holder.viewDataBinding.also {

            val artistImg = albums_of_artist[position]

            Glide.with(fragment)
                .load(artistImg.cover)
                .apply(RequestOptions.circleCropTransform())
                .into(holder.ivDishImage)

            it.albumOfArtist = albums_of_artist[position]
        }
    }

    override fun getItemCount(): Int {
        return albums_of_artist.size
    }


    class AlbumOfArtistViewHolder(val viewDataBinding: AlbumOfArtistItemBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {
        val ivDishImage = viewDataBinding.ivDishImage
        companion object {
            @LayoutRes
            val LAYOUT = R.layout.album_of_artist_item
        }
    }


}