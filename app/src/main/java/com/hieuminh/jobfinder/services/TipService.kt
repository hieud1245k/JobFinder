package com.hieuminh.jobfinder.services

import com.hieuminh.jobfinder.models.Tip
import retrofit2.Call
import retrofit2.http.GET

interface TipService {
    @GET("tips/")
    fun getTipList(): Call<ArrayList<Tip>>
}
