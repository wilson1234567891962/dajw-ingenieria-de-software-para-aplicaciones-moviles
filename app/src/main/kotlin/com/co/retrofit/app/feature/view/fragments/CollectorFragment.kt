package com.co.retrofit.app.feature.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.co.base.retrofit.delegate.viewModelProvider
import com.co.retrofit.app.R
import com.co.retrofit.app.feature.viewmodel.AlbumViewModel
import com.co.retrofit.app.feature.viewmodel.CollectorViewModel

class CollectorFragment: Fragment() {

    private val collectorViewModel by viewModelProvider(CollectorViewModel::class)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_collector, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showFloating()
    }

    private fun showFloating() {
        collectorViewModel.setStateFloating(false)
    }
}