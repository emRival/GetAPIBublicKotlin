package com.rival.getapipublic.api

import com.rival.getapipublic.response.ResponseAnime
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("v1")
    fun getAnime(): Call<ResponseAnime>
}