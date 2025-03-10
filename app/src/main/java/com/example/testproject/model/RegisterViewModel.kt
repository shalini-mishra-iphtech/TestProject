package com.example.testproject.model

import androidx.lifecycle.ViewModel
import com.example.testproject.MainActivity
import com.example.testproject.fragment.LoginFragment

class RegisterViewModel:ViewModel() {
    fun goToLogin(activity: MainActivity) {
        activity.loadFragment(LoginFragment())
    }
}