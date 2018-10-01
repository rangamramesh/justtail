package com.example.ramesh.justtail.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ramesh.justtail.MainActivity

import com.example.ramesh.justtail.R
import com.example.ramesh.justtail.adapters.TilersListAdapter
import com.example.ramesh.justtail.listeners.ListItemClickListener
import com.example.ramesh.justtail.models.Tiler
import com.example.ramesh.justtail.viewmodels.TilersViewModel
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment(),ListItemClickListener {

    var tilersViewModel=TilersViewModel()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
       var view=inflater.inflate(R.layout.fragment_home, container, false)
        tilersViewModel= ViewModelProviders.of(activity!!).get(TilersViewModel::class.java)

        tilersViewModel.getTilers().observe(activity!!, Observer {
            displayTilers(it,view)
        })
        return view
    }

    private fun displayTilers(it: ArrayList<Tiler>?, view: View) {
        if(activity!=null) {
            var adapter = TilersListAdapter(activity!!, it!!)
            adapter.setOnItemClickListener(this)
            view.tilers_lists.layoutManager = LinearLayoutManager(activity!!)
            view.tilers_lists.adapter = adapter
        }
    }
    override fun onClick(data: Any) {
        tilersViewModel.setSelectedTiler(data as Tiler)
        Log.d(MainActivity::class.java.simpleName,data.name)
    }
}
