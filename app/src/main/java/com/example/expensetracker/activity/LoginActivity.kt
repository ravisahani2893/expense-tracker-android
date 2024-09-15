package com.example.expensetracker.activity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.expensetracker.R
import com.example.expensetracker.databinding.ActivityLoginBinding
import com.example.expensetracker.model.login.LoginRequest
import com.example.expensetracker.network.model.DataResponse
import com.example.expensetracker.preference.SharedPreference
import com.example.expensetracker.utils.AppUtils
import com.example.expensetracker.viewmodel.LoginViewModel



class LoginActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initializeResources()
        initViewModel()
    }
    private fun initializeResources() {
        binding.btnLogin.setOnClickListener(this)
    }

    private fun initViewModel(){
        viewModel=ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    private fun isValid(): Boolean {
        if (isEmpty(binding.etUserEmployeeCode.text.toString())) {
            AppUtils.showToastMessage(this, getString(R.string.enter_username_error_text))
            return false
        } else if (isEmpty(binding.etUserPassword.text.toString())) {
            AppUtils.showToastMessage(this, getString(R.string.enter_password_error_text))
            return false
        }
        return true
    }

    private fun isEmpty(data: String): Boolean {
        return TextUtils.isEmpty(data)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {

            R.id.tv_forgot_password -> {

            }

            R.id.btn_login -> {

                AppUtils.hideSoftKeyboard(this)
                userLogin()

            }

        }
    }

    fun userLogin(){
        if(isValid()){
            val request = LoginRequest(binding.etUserEmployeeCode.text.toString(),
                binding.etUserPassword.text.toString())

            viewModel.login(request).observe(this) {

                when (it.status) {

                    DataResponse.Status.LOADING -> {
                        AppUtils.showProgressDialog(baseContext, false)
                    }

                    DataResponse.Status.ERROR -> {
                        AppUtils.hideProgressDialog()
                    }

                    DataResponse.Status.SUCCESS -> {
                        AppUtils.hideProgressDialog()
                        SharedPreference(this).saveUser(it.data)
                        val homeIntent = Intent(this,HomeActivity::class.java)
                        homeIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(homeIntent)
                    }

                    else -> {

                    }

                }
            }
        }
    }

}