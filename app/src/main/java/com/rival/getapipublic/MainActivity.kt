package com.rival.getapipublic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rival.getapipublic.adapter.AnimeAdapter
import com.rival.getapipublic.api.ApiConfig
import com.rival.getapipublic.response.ResponseAnime
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recy_anime = findViewById<RecyclerView>(R.id.rc_anime)

        ApiConfig.getService().getAnime().enqueue(object : Callback<ResponseAnime> {
            override fun onResponse(call: Call<ResponseAnime>, response: Response<ResponseAnime>) {
                if (response.isSuccessful) {
                    val responseAnime = response.body()
                    val dataAnime = responseAnime?.data
                    val animeAdapter = AnimeAdapter(dataAnime)

                    recy_anime.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        setHasFixedSize(true)
                        animeAdapter.notifyDataSetChanged()
                        adapter = animeAdapter
                    }
                }
            }

            override fun onFailure(call: Call<ResponseAnime>, t: Throwable) {
                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })
    }
}