package com.juan.mvvmp1.data.network

import com.juan.mvvmp1.data.model.DataResponse
import com.juan.mvvmp1.data.model.LoginDTO
import com.juan.mvvmp1.data.model.UserModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginAppClient {
    @POST("sign_in")
    suspend fun login(
        @Body loginDTO: LoginDTO
    ): Response<DataResponse<UserModel>>
}