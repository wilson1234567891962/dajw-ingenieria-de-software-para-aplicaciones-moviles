package com.co.retrofit.app.feature.view.fragments.album

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.co.base.retrofit.delegate.viewModelProvider
import com.co.retrofit.app.databinding.FragmentAlbumCreationBinding
import com.co.retrofit.app.feature.viewmodel.album.AlbumCreationViewModel


class AlbumCreation: Fragment() {

    private val albumCreationViewModel by viewModelProvider(AlbumCreationViewModel::class)
    private var mBinding: FragmentAlbumCreationBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentAlbumCreationBinding.inflate(inflater, container, false)
        return mBinding!!.root
    }

}