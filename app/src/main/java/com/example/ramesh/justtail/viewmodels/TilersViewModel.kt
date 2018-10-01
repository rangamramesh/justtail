package com.example.ramesh.justtail.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.ramesh.justtail.R
import com.example.ramesh.justtail.models.Tiler

class TilersViewModel:ViewModel() {
   var tilersList=ArrayList<Tiler>()
   var mutableTilersList=MutableLiveData<ArrayList<Tiler>>()
   var selectedTiler=MutableLiveData<Tiler>()

   fun getTilers():MutableLiveData<ArrayList<Tiler>> {
       getTilersList()
       mutableTilersList.value=tilersList
       return mutableTilersList
   }

    private fun getTilersList() {
        tilersList.add(Tiler("Ramesh Tailors","8332072402","HiTech city, Hyderabad",5, R.drawable.one))
        tilersList.add(Tiler("Kurre Raymonds fitters","7396565649","HiTech city, Hyderabad",4,R.drawable.two))
        tilersList.add(Tiler("Pushpa local tailor","7379373764","HiTech city, Hyderabad",5,R.drawable.three))
        tilersList.add(Tiler("Surya international Tailors","7379373764","HiTech city, Hyderabad",5,R.drawable.four))
        tilersList.add(Tiler("Dariya formal traders","7883987772","HiTech city, Hyderabad",3,R.drawable.one))
        tilersList.add(Tiler("Teja casual traders","8247874633","HiTech city, Hyderabad",3,R.drawable.two))
        tilersList.add(Tiler("Mamatha modern tailors","9323763267","HiTech city, Hyderabad",4,R.drawable.three))
        tilersList.add(Tiler("Lakshman local tailor ","6823782375","HiTech city, Hyderabad",2,R.drawable.four))
        tilersList.add(Tiler("Lakshmi casual traders","6823782375","HiTech city, Hyderabad",3,R.drawable.one))
    }

    fun setSelectedTiler(tiler:Tiler){
        selectedTiler.value=tiler
    }

    fun getSelecetdTiler():MutableLiveData<Tiler>{
        return selectedTiler
    }
}