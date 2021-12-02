package com.co.retrofit.app.feature.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.co.base.retrofit.delegate.viewModelProvider
import com.co.retrofit.app.R
import com.co.retrofit.app.databinding.FragmentCollectorBinding
import com.co.retrofit.app.feature.RetrofitApplication
import com.co.retrofit.app.feature.model.dto.Collector
import com.co.retrofit.app.feature.view.adapter.CollectorAdapter

import com.co.retrofit.app.feature.viewmodel.CollectorViewModel

class CollectorFragment: Fragment(R.layout.fragment_collector) {

    private val collectorViewModel by viewModelProvider(CollectorViewModel::class)
    private var _binding: FragmentCollectorBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: CollectorViewModel
    private lateinit var recyclerView: RecyclerView
    private var viewModelAdapter: CollectorAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        _binding = FragmentCollectorBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModelAdapter = CollectorAdapter(this@CollectorFragment)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        recyclerView = binding.collectorRecyclerView
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
        viewModel = ViewModelProvider(this, CollectorViewModel.Factory(activity.application as RetrofitApplication)).get(
            CollectorViewModel::class.java)
        //this.activity?.showLoader()
        viewModel.collectors.observe(viewLifecycleOwner, Observer<List<Collector>> {
            it.apply {
                viewModelAdapter!!.collectors = this
            }
            //this.activity?.hideLoader()
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
        collectorViewModel.setStateFloating(false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}