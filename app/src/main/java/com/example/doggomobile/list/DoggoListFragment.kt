package com.example.doggomobile.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.loader.content.Loader
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.doggomobile.R
import com.example.doggomobile.api.DoggoDetailResponse
import com.example.doggomobile.api.DoggoListResponse
//import com.example.doggomobile.presentation.Singleton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class DoggoListFragment : Fragment() {

    private lateinit var recyclerView : RecyclerView
    private val adapter = DoggoAdapter(listOf(), ::onClickedDoggo)
   // private val doggoViewModel : DoggoListViewModel by activityViewModels()
    private lateinit var loader : ProgressBar
    private lateinit var texterror : TextView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_doggo_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView =  view.findViewById(R.id.dog_recyclerview)
        loader = view.findViewById(R.id.loader)
        texterror = view.findViewById(R.id.texterror)

        recyclerView.apply {
            layoutManager =  LinearLayoutManager(context)
            adapter = this@DoggoListFragment. adapter
        }


       /* doggoViewModel.doggoList.observe(viewLifecycleOwner, Observer {doggoModel ->
            loader.isVisible = doggoModel is DoggoModel.DoggoLoader
            texterror.isVisible = doggoModel is DoggoModel.DoggoFailure
            if(doggoModel is DoggoModel.DoggoSuccess) adapter.updateList(doggoModel.doggolist)

        })*/

        /*val dogList = arrayListOf<Doggo>().apply {
            add(Doggo("Golden Retriever"))
            add(Doggo("Yuski"))
            add(Doggo("Chihuahua"))
            add(Doggo("Berger Allemand"))
         }
        adapter.updateList(dogList)*/
    }
    private fun onClickedDoggo(doggo: DoggoListResponse) {
        val doggoName = doggo.name
        val bundle = Bundle()
        bundle.putString("doggoname",doggoName)

        val fragment = Fragment()
        fragment.setArguments(bundle)
        findNavController().navigate(R.id.navigateToDoggoDetailFragment)
    }
}