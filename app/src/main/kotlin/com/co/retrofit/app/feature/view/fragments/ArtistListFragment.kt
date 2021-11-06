package com.co.retrofit.app.feature.view.fragments

import android.os.Bundle
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
import com.co.retrofit.app.feature.model.dto.Artist
import com.co.retrofit.app.feature.view.adapter.ArtistAdapter
import com.co.retrofit.app.feature.viewmodel.ArtistViewModel


class ArtistListFragment : Fragment(R.layout.fragment_artist_list) {

    private val artistViewModel by viewModelProvider(ArtistViewModel::class)
    private var _binding: FragmentArtistListBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ArtistViewModel
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
        viewModel = ViewModelProvider(this, ArtistViewModel.Factory(activity.application)).get(ArtistViewModel::class.java)
        this.activity?.showLoader()
        viewModel.artists.observe(viewLifecycleOwner, Observer<List<Artist>> {
            it.apply {
                viewModelAdapter!!.artists = this
            }
            this.activity?.hideLoader()
        })
        viewModel.eventNetworkError.observe(viewLifecycleOwner, Observer<Boolean> { isNetworkError ->
            if (isNetworkError) onNetworkError()
        })
    }
    private fun onNetworkError() {
        if(!viewModel.isNetworkErrorShown.value!!) {
            Toast.makeText(activity, "Network Error", Toast.LENGTH_LONG).show()
            viewModel.onNetworkErrorShown()
        }
    }



    private fun showFloating() {
        artistViewModel.setStateFloating(false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}