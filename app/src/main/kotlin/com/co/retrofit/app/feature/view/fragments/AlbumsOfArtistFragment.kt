package com.co.retrofit.app.feature.view.fragments


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.co.base.retrofit.delegate.viewModelProvider
import com.co.retrofit.app.R
import com.co.retrofit.app.databinding.FragmentAlbumsOfArtistBinding
import com.co.retrofit.app.feature.model.dto.Album
import com.co.retrofit.app.feature.view.adapter.AlbumOfArtistAdapter
import com.co.retrofit.app.feature.viewmodel.AlbumsOfArtistViewModel


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AlbumsOfArtistFragment : Fragment() {

    private var _binding: FragmentAlbumsOfArtistBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: AlbumsOfArtistViewModel
    private lateinit var recyclerView: RecyclerView
    private var viewModelAdapter: AlbumOfArtistAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAlbumsOfArtistBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModelAdapter = AlbumOfArtistAdapter()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.albumsOfArtistRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = viewModelAdapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onActivityCreated()"
        }
        activity.actionBar?.title = getString(R.string.title_albums_of_artist)

        val args: AlbumsOfArtistFragmentArgs by navArgs()
        Log.d("Args", args.artistId.toString())
        viewModel = ViewModelProvider(this, AlbumsOfArtistViewModel.Factory(activity.application, args.artistId)).get(AlbumsOfArtistViewModel::class.java)
        viewModel.albumsOfArtist.observe(viewLifecycleOwner, Observer<List<Album>> {
            it.apply {
                viewModelAdapter!!.albums_of_artist = this
                if(this.isEmpty()){
                    binding.txtNoComments.visibility = View.VISIBLE
                }else{
                    binding.txtNoComments.visibility = View.GONE
                }
            }
        })
        viewModel.eventNetworkError.observe(viewLifecycleOwner, Observer<Boolean> { isNetworkError ->
            if (isNetworkError) onNetworkError()
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onNetworkError() {
        if(!viewModel.isNetworkErrorShown.value!!) {
            Toast.makeText(activity, "Network Error", Toast.LENGTH_LONG).show()
            viewModel.onNetworkErrorShown()
        }
    }
}