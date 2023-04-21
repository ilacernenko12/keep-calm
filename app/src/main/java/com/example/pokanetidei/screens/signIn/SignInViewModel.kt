package com.example.pokanetidei.screens.signIn

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokanetidei.database.UsersDatabase
import com.example.pokanetidei.database.UsersEntity
import com.example.pokanetidei.database.UsersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignInViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: UsersRepository

    init {
        val dao = UsersDatabase.getInstance(application).usersDao
        repository = UsersRepository(dao)
    }

    fun insertNewUser(user: UsersEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(user)
    }
}