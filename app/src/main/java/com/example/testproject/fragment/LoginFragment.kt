package com.example.testproject.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.testproject.MainActivity
import com.example.testproject.R
import com.example.testproject.model.LoginViewModel


class LoginFragment : Fragment() {

  private lateinit var signInBtn: Button
  private lateinit var signUp:TextView
 // private lateinit var signUpR:TextView

    private val loginViewModel = LoginViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_login, container, false)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        signInBtn=view.findViewById(R.id.login)
        signUp=view.findViewById(R.id.tvSignUp)
       // signUpR=view.findViewById(R.id.tvSignUpR)

        signInBtn.setOnClickListener{
            loginViewModel.goToHome(requireActivity() as MainActivity)
        }
        signUp.setOnClickListener{
            loginViewModel.goToRegister(requireActivity() as MainActivity)
        }
        /*
       signUpR.setOnClickListener{
           loginViewModel.goToLogin(requireActivity() as MainActivity)
       }
       */

    }




}