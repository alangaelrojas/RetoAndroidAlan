package com.alan.retoandroidalan.features.user.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.alan.retoandroidalan.R
import com.alan.retoandroidalan.core.BaseFragment
import com.alan.retoandroidalan.core.BaseViewModel
import com.alan.retoandroidalan.core.BaseViewModel.BaseFlowState
import com.alan.retoandroidalan.core.BaseViewModel.BaseFlowState.*
import com.alan.retoandroidalan.databinding.FragmentLoginBinding
import com.alan.retoandroidalan.features.tasks.TasksActivity
import com.alan.retoandroidalan.features.user.create.CreateAccountFragment
import com.alan.retoandroidalan.features.user.login.lifecycle.LoginViewModel

class LoginFragment : BaseFragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(viewModelStore, defaultViewModelProviderFactory)[LoginViewModel::class.java]

        viewModel.baseFlowState.observe(viewLifecycleOwner, {
            when(it){
                is OnLoading -> {
                    Toast.makeText(requireContext(), "Iniciando sesion", Toast.LENGTH_SHORT).show()
                }
                is OnLoginSuccess -> {
                    TasksActivity.startActivity(requireContext())
                }
                is OnError -> {
                    Toast.makeText(requireContext(), getString(it.error), Toast.LENGTH_SHORT).show()
                }
            }
        })

        binding.btnLogin.setOnClickListener {
            val user = binding.tieUser.text.toString()
            val password = binding.tiePassword.text.toString()
            viewModel.initSession(user, password)
        }

        binding.btnSignUp.setOnClickListener {
            changeFragment(R.id.login_container, CreateAccountFragment())
        }
    }
}