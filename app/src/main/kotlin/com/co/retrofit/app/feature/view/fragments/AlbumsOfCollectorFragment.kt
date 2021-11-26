package com.co.retrofit.app.feature.view.fragments


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.co.base.retrofit.delegate.viewProvider
import com.co.retrofit.app.R
import com.co.retrofit.app.databinding.FragmentAlbumsOfCollectorBinding
import com.co.retrofit.app.feature.RetrofitApplication
import com.co.retrofit.app.feature.model.dto.Album
import com.co.retrofit.app.feature.view.adapter.AlbumsOfCollectorAdapter
import com.co.retrofit.app.feature.viewmodel.AlbumsOfCollectorViewModel


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AlbumsOfCollectorFragment : Fragment() {

    private var _binding: FragmentAlbumsOfCollectorBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: AlbumsOfCollectorViewModel
    private lateinit var recyclerView: RecyclerView
    private var viewModelAdapter: AlbumsOfCollectorAdapter? = null
    private val back: View by viewProvider(R.id.back_detail_collector)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAlbumsOfCollectorBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModelAdapter = AlbumsOfCollectorAdapter(this@AlbumsOfCollectorFragment)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        recyclerView = binding.albumsOfCollectorRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = viewModelAdapter
        setUpListenerEvent()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onActivityCreated()"
        }
        activity.actionBar?.title = getString(R.string.title_albums_of_collector)

        val args: AlbumsOfCollectorFragmentArgs by navArgs()

        //val date = LocalDate.parse(args.artist.creationDate, DateTimeFormatter.ISO_DATE)

        activity.findViewById<TextView>(R.id.collector_name).apply{text=args.collector.name }
        activity.findViewById<TextView>(R.id.collector_email).apply{text=args.collector.email }
        activity.findViewById<TextView>(R.id.collector_telephone).apply{text=args.collector.telephone}
        activity.findViewById<TextView>(R.id.header_label_initials_detail).apply { text = args.collector.name.first().toString()}


        Log.d("Args", args.collectorId.toString())

        viewModel = ViewModelProvider(this, AlbumsOfCollectorViewModel.Factory(activity.application as RetrofitApplication, args.collectorId, args.collector)).get(AlbumsOfCollectorViewModel::class.java)
        viewModel.albumsOfCollector.observe(viewLifecycleOwner, Observer<List<Album>> {
            it.apply {
                viewModelAdapter!!.albums_of_collector = this
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

    private fun setUpListenerEvent() {
        back.setOnClickListener(this::backPressed)
    }
    @Suppress("UNUSED_PARAMETER")
    private fun backPressed(view: View) {
        val navController = this.activity?.findNavController(R.id.nav_host_fragment)
        navController?.navigate(R.id.navigation_collector)
    }
}