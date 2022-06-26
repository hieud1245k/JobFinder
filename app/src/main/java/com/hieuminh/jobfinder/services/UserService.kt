package com.hieuminh.jobfinder.services

import com.google.gson.JsonObject
import com.hieuminh.jobfinder.models.response.LoginRes
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface UserService {
    @POST("users/sign-in")
    fun signIn(@Body params: Map<String, @JvmSuppressWildcards Any>): Call<JsonObject>

    @POST("users/sign-up")
    fun signUp(@Body params: Map<String, @JvmSuppressWildcards Any>): Call<JsonObject>

    @GET("users/profile")
    fun profile(): Call<JsonObject>

    @PUT("users/active-user")
    fun activeAccount(@Body params: Map<String, @JvmSuppressWildcards Any>): Call<LoginRes>

    @POST("users/verify-mail")
    fun verifyEmail(@Body params: Map<String, @JvmSuppressWildcards Any>): Call<JsonObject>

    @PUT("users/reset-password")
    fun resetPassword()
}
