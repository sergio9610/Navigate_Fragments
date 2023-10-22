package com.example.fragment20232.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragment20232.R
import com.example.fragment20232.databinding.ActivityMainBinding
import com.example.fragment20232.ui.bottom.BottomNavigationActivity
import com.example.fragment20232.ui.masterdetail.MasterDetailActivity
import com.example.fragment20232.ui.navdrawer.NavigationDrawerActivity
import com.example.fragment20232.ui.tabbed.TabbedActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)
        //setContentView(R.layout.activity_main)

        mainBinding.mainNavigationButton.setOnClickListener {
            val intent = Intent(this, BottomNavigationActivity::class.java)
            startActivity(intent)
        }

        mainBinding.mainSwipeTabsNavigationButton.setOnClickListener {
            val intent = Intent(this, TabbedActivity::class.java)
            startActivity(intent)
        }

        mainBinding.mainNavigationDrawerButton.setOnClickListener {
            val intent = Intent(this, NavigationDrawerActivity::class.java)
            startActivity(intent)
        }

        mainBinding.mainMasterDetailButton.setOnClickListener {
            val intent = Intent(this, MasterDetailActivity::class.java)
            startActivity(intent)
        }
    }
}