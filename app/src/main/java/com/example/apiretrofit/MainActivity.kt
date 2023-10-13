package com.example.apiretrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apiretrofit.adapter.MyAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: MyAdapter
    var BASE_URL = "https://api.itbook.store/1.0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        getAllData()

    }

    private fun getAllData() {

        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        var retrofitData = retrofit.getData()

        retrofit.equals(object : Callback<List<Book>> {
            override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                var data = response.body()!!
                myAdapter = MyAdapter(baseContext,data)
                recyclerView.adapter = myAdapter
                Log.d("data",data.toString())
            }

            override fun onFailure(call: Call<List<Book>>, t: Throwable) {

            }

        })

    }
}