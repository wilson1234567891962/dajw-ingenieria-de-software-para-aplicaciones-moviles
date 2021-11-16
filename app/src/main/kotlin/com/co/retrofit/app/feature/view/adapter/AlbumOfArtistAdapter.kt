package com.co.retrofit.app.feature.view.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.co.retrofit.app.R
import com.co.retrofit.app.databinding.AlbumOfArtistItemBinding
import com.co.retrofit.app.feature.model.dto.Album

class   AlbumOfArtistAdapter : RecyclerView.Adapter<AlbumOfArtistAdapter.AlbumOfArtistViewHolder>(){

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
            it.albumOfArtist = albums_of_artist[position]
        }
    }

    override fun getItemCount(): Int {
        return albums_of_artist.size
    }


    class AlbumOfArtistViewHolder(val viewDataBinding: AlbumOfArtistItemBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {
        companion object {
            @LayoutRes
            val LAYOUT = R.layout.album_of_artist_item
        }
    }


}