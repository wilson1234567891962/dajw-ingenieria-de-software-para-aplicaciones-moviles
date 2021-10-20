package com.co.retrofit.app.feature.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.co.retrofit.app.databinding.ItemAlbumLayoutBinding
import com.co.retrofit.app.feature.model.dto.Album


class AlbumAdapter(private val fragment: Fragment) :
    RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    private var album: List<Album> = listOf()

    /**
     * Inflates the item views which is designed in xml layout file
     *
     * create a new
     * {@link ViewHolder} and initializes some private fields to be used by RecyclerView.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemAlbumLayoutBinding =
            ItemAlbumLayoutBinding.inflate(LayoutInflater.from(fragment.context), parent, false)
        return ViewHolder(binding)
    }

    /**
     * Binds each item in the ArrayList to a view
     *
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     *
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val dto = album[position]

        // Load the dish image in the ImageView.
        Glide.with(fragment)
            .load(dto.image)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.ivDishImage)

        holder.tvTitle.text ="Nombre: ${dto.title}"
        holder.tvArtist.text ="Artista: ${dto.artist}"
    }

    /**
     * Gets the number of items in the list
     */
    override fun getItemCount(): Int {
        return album.size
    }

    fun albumList(list: List<Album>) {
        album = list
        notifyDataSetChanged()
    }

    /**
     * A ViewHolder describes an item view and metadata about its place within the RecyclerView.
     */
    class ViewHolder(view: ItemAlbumLayoutBinding) : RecyclerView.ViewHolder(view.root) {
        // Holds the TextView that will add each item to
        val ivDishImage = view.ivDishImage
        val tvTitle = view.tvDishTitle
        val tvArtist = view.tvArtist
    }
}