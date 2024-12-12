package com.juan.mvvmp1.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juan.mvvmp1.data.model.LoginDTO
import com.juan.mvvmp1.data.model.UserModel
import com.juan.mvvmp1.domain.PostLoginUseCase
import kotlinx.coroutines.launch

class LoginViewModel:ViewModel() {
    val userModel = MutableLiveData<UserModel>()
    val message = MutableLiveData<String?>()
    val isLoading = MutableLiveData<Boolean>()

    val postLoginUseCase = PostLoginUseCase()

    fun onCreate(loginDTO: LoginDTO){
        viewModelScope.launch {
            isLoading.postValue(true)
            val response = postLoginUseCase(loginDTO)
            if(response.status == ""){
                userModel.postValue(response.data)
            }

            when(response.status){
                "success" -> {
                    userModel.postValue(response.data)
                    isLoading.postValue(false)
                }
                "error" ->{
                    if (response.message != null){
                        message.postValue(response.message)
                        isLoading.postValue(false)
                    }
                }
                "invalid" ->{
                    message.postValue(response.message)
                    isLoading.postValue(false)
                }
                else ->{
                    message.postValue("Error con el servidor")
                    isLoading.postValue(false)
                }
            }
        }
    }
}