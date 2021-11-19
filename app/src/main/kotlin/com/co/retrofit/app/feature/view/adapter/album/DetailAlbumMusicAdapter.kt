package com.co.retrofit.app.feature.view.adapter.album

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.co.retrofit.app.databinding.ItemDetailMusicAlbumLayoutBinding
import com.co.retrofit.data.model.dto.Music

class DetailAlbumMusicAdapter(private val fragment: Fragment, private val listener: (Music) -> Unit) :
    RecyclerView.Adapter<DetailAlbumMusicAdapter.ViewHolder>() {

    private var albumMusic: List<Music> = listOf()

    /**
     * Inflates the item views which is designed in xml layout file
     *
     * create a new
     * {@link ViewHolder} and initializes some private fields to be used by RecyclerView.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemDetailMusicAlbumLayoutBinding =
            ItemDetailMusicAlbumLayoutBinding.inflate(LayoutInflater.from(fragment.context), parent, false)
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

        val dto = albumMusic[position]
        holder.tvTitle.text ="Cancion: ${dto.name}"
        holder.itemView.setOnClickListener { listener(dto) }
    }

    /**
     * Gets the number of items in the list
     */
    override fun getItemCount(): Int {
        return albumMusic.size
    }

    fun albumList(list: List<Music>) {
        albumMusic = list
        notifyDataSetChanged()
    }

    /**
     * A ViewHolder describes an item view and metadata about its place within the RecyclerView.
     */
    class ViewHolder(view: ItemDetailMusicAlbumLayoutBinding) : RecyclerView.ViewHolder(view.root) {
        val tvTitle = view.nameAlbumList
    }
}