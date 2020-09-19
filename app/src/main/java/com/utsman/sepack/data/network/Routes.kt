package com.utsman.sepack.data.network

import com.utsman.sepack.data.model.Reqres
import retrofit2.http.GET

interface Routes {

    @GET("/api/users")
    suspend fun user(): Reqres

}