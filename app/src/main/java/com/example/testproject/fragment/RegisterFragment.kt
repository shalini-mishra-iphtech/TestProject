package com.example.testproject.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.testproject.MainActivity
import com.example.testproject.R
import com.example.testproject.model.LoginViewModel
import com.example.testproject.model.RegisterViewModel


class RegisterFragment : Fragment() {
    private lateinit var signUpR:TextView
    private val loginViewModel = RegisterViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_register, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         signUpR=view.findViewById(R.id.tvSignUpR)

        signUpR.setOnClickListener{
            loginViewModel.goToLogin(requireActivity() as MainActivity)
        }

    }



}