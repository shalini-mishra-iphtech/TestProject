package com.example.testproject.model

import androidx.lifecycle.ViewModel
import com.example.testproject.MainActivity
import com.example.testproject.fragment.HomeFragment
import com.example.testproject.fragment.LoginFragment
import com.example.testproject.fragment.RegisterFragment

class LoginViewModel :ViewModel(){
    fun goToHome(activity: MainActivity) {
        activity.loadFragment(HomeFragment())
    }

    fun goToRegister(activity: MainActivity) {
        activity.loadFragment(RegisterFragment())
    }

    fun goToLogin(activity: MainActivity) {
        activity.loadFragment(LoginFragment())
    }
}