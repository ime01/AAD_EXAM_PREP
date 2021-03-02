package com.example.android.codelabs.paging.stateflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.android.codelabs.paging.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_state_flow.*
import kotlinx.coroutines.flow.collect

class StateFlowActivity : AppCompatActivity() {

    private val viewModel: StateFlowViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_state_flow)

        login_button.setOnClickListener {
            viewModel.login(user_name.text.toString(), user_password.text.toString())

        }

        lifecycleScope.launchWhenStarted {
            viewModel.loginUiState.collect {
                when(it){
                    is StateFlowViewModel.LoginUiState.Success->{
                        Snackbar.make(user_name, "You Logged In Successfully", Snackbar.LENGTH_LONG).show()
                        progressBar.isVisible = false
                    }
                    is StateFlowViewModel.LoginUiState.Error->{
                        Snackbar.make(user_name, it.message, Snackbar.LENGTH_LONG).show()
                        progressBar.isVisible = false

                    }
                    is StateFlowViewModel.LoginUiState.Loading->{
                        progressBar.isVisible = true

                    }
                    else-> Unit

                }

            }
        }


    }


}