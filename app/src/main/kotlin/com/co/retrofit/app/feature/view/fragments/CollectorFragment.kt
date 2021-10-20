package com.co.retrofit.app.feature.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.co.retrofit.app.R
import com.co.retrofit.app.feature.viewmodel.CollectorViewModel

class CollectorFragment: Fragment() {

    private lateinit var collectorViewModel: CollectorViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        collectorViewModel = ViewModelProvider(this).get(CollectorViewModel::class.java)
        return inflater.inflate(R.layout.fragment_collector, container, false)
    }
}