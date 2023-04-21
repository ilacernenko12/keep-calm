package com.example.pokanetidei.screens.signIn

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pokanetidei.App
import com.example.pokanetidei.database.entity.UsersEntity
import com.example.pokanetidei.database.UserRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignInViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: UserRepositoryImpl = UserRepositoryImpl(App.room.usersDao)

    private val _username = MutableLiveData<String>("")
    val username: LiveData<String> = _username

    fun onUserNameChanged(userName: String) {
        _username.value = userName
    }

    fun insertNewUser(user: UsersEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(user)
    }
}