package com.juan.mvvmp1.data.network

import com.juan.mvvmp1.core.RetrofitHelper
import com.juan.mvvmp1.data.model.DataResponse
import com.juan.mvvmp1.data.model.LoginDTO
import com.juan.mvvmp1.data.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginService {
    private val retrofittwo = RetrofitHelper.getRetrofitTwo()
    suspend fun login(loginDTO: LoginDTO): DataResponse<UserModel>{
        return withContext(Dispatchers.IO){
            val response = retrofittwo.create(LoginAppClient::class.java).login(loginDTO)
            response.body() ?:
            DataResponse(UserModel("",""),"error","error")
        }
    }
}