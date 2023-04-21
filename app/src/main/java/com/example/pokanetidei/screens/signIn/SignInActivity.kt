package com.example.pokanetidei.screens.signIn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.pokanetidei.R
import com.example.pokanetidei.database.entity.UsersEntity
import com.example.pokanetidei.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity(R.layout.activity_sign_in) {

    private val binding: ActivitySignInBinding by viewBinding(ActivitySignInBinding::bind)
    private val viewModel: SignInViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding.btnSubmit.setOnClickListener {
            val newUser = UsersEntity(
                0,
                binding.etUsername.text.toString(),
                binding.etEmail.text.toString(),
                binding.etPassword.text.toString()
            )

            viewModel.insertNewUser(newUser)
        }
        initObservers()
    }

    private fun initObservers() {

        binding.etUsername.addTextChangedListener {
            viewModel.onUserNameChanged(it.toString())
        }

        viewModel.username.observe(this) { username ->
            binding.etPassword.setText("")
        }
    }
}