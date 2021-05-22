package com.example.doggomobile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.doggomobile.api.DoggoDetailResponse
import com.example.doggomobile.presentation.Singleton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DoggoDetailFragment : Fragment() {

    private lateinit var textViewName: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_doggo_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val doggoname = getArguments()?.getString("doggoname")
        view.findViewById<Button>(R.id.button_third).setOnClickListener {
            findNavController().navigate(R.id.returnToDoggoListFragment)
        }

        textViewName = view.findViewById(R.id.doggo_detail)
        callApi()
    }

    private fun callApi() {
        Singleton.doggoApi.getDoggoDetail("1").enqueue(object: Callback<DoggoDetailResponse>{
            override fun onFailure(call: Call<DoggoDetailResponse>, t: Throwable)
            {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<DoggoDetailResponse>, response: Response<DoggoDetailResponse>) {
                if(response.isSuccessful && response.body() != null)
                {
                    textViewName.text = response.body()!!.name
                }

            }

        })
    }
}