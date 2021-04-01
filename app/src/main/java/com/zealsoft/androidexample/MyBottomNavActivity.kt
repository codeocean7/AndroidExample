package com.zealsoft.androidexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

class MyBottomNavActivity : AppCompatActivity()
{

    private var mAppBarConfiguration: AppBarConfiguration? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.btm_activity)


        val bottom_nav_home = findViewById<BottomNavigationView>(R.id.bottom_nav_home)

        mAppBarConfiguration = AppBarConfiguration.Builder(R.id.mnHome,
                R.id.mnNotify, R.id.mnProfile).build()

        val navController = Navigation.findNavController(this, R.id.host_fragment)

        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration!!)

        NavigationUI.setupWithNavController(bottom_nav_home, navController)

    }
}