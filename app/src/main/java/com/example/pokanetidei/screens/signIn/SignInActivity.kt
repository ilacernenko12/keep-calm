package com.example.pokanetidei.screens.signIn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.pokanetidei.R
import com.example.pokanetidei.database.UsersEntity
import com.example.pokanetidei.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    private lateinit var viewModel: SignInViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater). also { setContentView(R.layout.activity_sign_in) }
        viewModel = initViewModel()

        val newUser = UsersEntity(1, binding.etUsername.text.toString(), binding.etEmail.text.toString(), binding.etPassword.text.toString())

        binding.btnSubmit.setOnClickListener {
            viewModel.insertNewUser(newUser)
        }
    }

    private fun initViewModel() : SignInViewModel = ViewModelProvider(
        this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)
    )[SignInViewModel::class.java]
}