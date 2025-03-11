package com.example.testproject

import android.os.Bundle
import android.widget.CheckBox
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.adapter.MyAdapter
import com.example.testproject.fragment.LoginFragment
import com.example.testproject.fragment.RegisterFragment

class MainActivity : AppCompatActivity() {
    var  backPressedTime=0
    override fun onCreate(savedInstanceState: Bundle?) {
        // private var backPressedTime: Long = 0
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        loadFragment(LoginFragment())

    }

    fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.login_container,
                fragment
            )  // add fragment_container is in activity_main.xml
            .addToBackStack(null)
            .commit()
    }


    //handling backpressed
    override fun onBackPressed() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.login_container)

        if (currentFragment is LoginFragment) {

            if (backPressedTime + 2000 > System.currentTimeMillis()) {
                finish()
            } else {
                Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show()
                backPressedTime = System.currentTimeMillis().toInt()
            }
        } else {
            //deprectied method
            super.onBackPressed()
        }
    }

}