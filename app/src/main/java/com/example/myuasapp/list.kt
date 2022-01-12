package com.example.myuasapp

import android.os.Bundle
import android.util.Log
import com.example.myuasapp.retrofit.api
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class list : Fragment() {
    private val apikonek by lazy { api().endpoint}
    private lateinit var Adapter: Adapter
    private lateinit var listjaket : RecyclerView

    override fun onCreateView (
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        listjaket = view.findViewById(R.id.list)
        setupList()

    }

    private fun setupList() {
        Adapter = Adapter(arrayListOf())
        listjaket.adapter = Adapter
    }

    override fun onStart(){
        super.onStart()
        getjaket()
    }
    private fun getjaket(){

        apikonek.data().enqueue(object : Callback<DataModel> {
            override fun onResponse(call: Call<DataModel>, response: Response<DataModel>) {
                if (response.isSuccessful){
                    val listData = response.body()!!.jaket
                    Adapter.setData(listData)

                }else{
                    Toast.makeText(
                        activity,
                        "gagal get data",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onFailure(call: Call<DataModel>, t: Throwable) {
                Log.e("reportActivity", t.toString())
            }

        })
    }

}