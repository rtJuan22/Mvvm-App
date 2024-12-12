package com.juan.mvvmp1.domain

import com.juan.mvvmp1.data.model.DataResponse
import com.juan.mvvmp1.data.model.LoginDTO
import com.juan.mvvmp1.data.model.UserModel
import com.juan.mvvmp1.data.repositories.LoginRepository

class PostLoginUseCase {
    private val loginRepository = LoginRepository()
    suspend  operator fun invoke(loginDTO: LoginDTO): DataResponse<UserModel>{
        return loginRepository.login(loginDTO)
    }
}