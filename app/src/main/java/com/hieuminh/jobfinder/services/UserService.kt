package com.hieuminh.jobfinder.services

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserService {
    @POST("users/signin")
    fun signIn(@Body params: Map<String, String>): Call<JsonObject>

    @GET("users/signup")
    fun signUp(@Body params: Map<String, String>): Call<JsonObject>

    @GET("users/profile")
    fun profile(): Call<JsonObject>
}
