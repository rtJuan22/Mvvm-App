package com.juan.mvvmp1.data.repositories

import com.juan.mvvmp1.data.model.DataResponse
import com.juan.mvvmp1.data.model.LoginDTO
import com.juan.mvvmp1.data.model.UserModel
import com.juan.mvvmp1.data.model.UserProvider
import com.juan.mvvmp1.data.network.LoginService

class LoginRepository {
    private val loginService = LoginService()
    suspend fun login(loginDTO: LoginDTO): DataResponse<UserModel>{
        val response = loginService.login(loginDTO)
        if(response.status == "success"){
            UserProvider.user = response.data
        }
        return response
    }
}