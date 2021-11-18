package com.co.retrofit.app.feature.view.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.co.base.retrofit.delegate.viewModelProvider
import com.co.base.retrofit.extension.hideLoader
import com.co.base.retrofit.extension.showLoader
import com.co.retrofit.app.R
import com.co.retrofit.app.databinding.FragmentArtistListBinding
import com.co.retrofit.app.feature.view.activities.Maintenance
import com.co.retrofit.data.model.dto.Artist
import com.co.retrofit.app.feature.view.adapter.ArtistAdapter
import com.co.retrofit.app.feature.viewmodel.ArtistViewModel
import com.co.retrofit.data.model.dto.Album


class ArtistListFragment : Fragment(R.layout.fragment_artist_list) {

    private val artistViewModel by viewModelProvider(ArtistViewModel::class)
    private var _binding: FragmentArtistListBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private var viewModelAdapter: ArtistAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        _binding = FragmentArtistListBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModelAdapter = ArtistAdapter(this@ArtistListFragment)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        recyclerView = binding.artistRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = viewModelAdapter

        recyclerView.apply {
            layoutManager = GridLayoutManager(requireActivity(), 2)
        }

        showFloating()

    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onActivityCreated()"
        }
        activity.actionBar?.title = getString(R.string.title_artist)
        getArtist()
    }

    private fun getArtist() {
        artistViewModel.getArtistCache()
            .observeSingleData(this, ::processArtist)
            .observeErrorThrowable(this, ::observeErrorThrowable)
    }

    private fun processArtist(artist: List<Artist>) {
        if (artist.isNotEmpty()) {
            viewModelAdapter!!.artists = artist
        }
    }
    @Suppress("UNUSED_PARAMETER")
    private fun observeErrorThrowable(error: Throwable){
        val intent = Intent(this.activity, Maintenance::class.java)
        startActivity(intent)
    }

    private fun showFloating() {
        artistViewModel.setStateFloating(false)
    }
}