package com.example.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.todo.fragment.AddFragment
import com.example.todo.fragment.CheckListFragment
import com.example.todo.fragment.HomeFragment
import com.example.todo.fragment.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bottomNavigationView = findViewById(R.id.bottom)

        // Set the default fragment (e.g., HomeFragment)
        val defaultFragment = HomeFragment() // Replace with your actual HomeFragment class
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, defaultFragment)
            .commit()

        // Set up BottomNavigationView item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    replaceFragment(HomeFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.checklist -> {
                    replaceFragment(CheckListFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.profile -> {
                    replaceFragment(ProfileFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                else -> return@setOnNavigationItemSelectedListener false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, fragment)
            .addToBackStack(null)  // Optional: Add fragment to back stack
            .commit()
    }
}