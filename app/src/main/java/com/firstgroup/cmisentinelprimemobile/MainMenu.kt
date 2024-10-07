package com.firstgroup.cmisentinelprimemobile

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainMenu : AppCompatActivity() {

    private val settingsFragment = SettingsFragment()
    private val indicatorsFragment = IndicatorsFragment()
    private val statisticsFragment = StatisticsFragment()
    private val homeFragment = HomeFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_menu)

        val navigation: BottomNavigationView = findViewById(R.id.bottom_navigation)

        val fragmentToLoad = intent.getStringExtra("fragmentToLoad")

        when (fragmentToLoad) {
            "SettingsFragment" -> loadFragment(settingsFragment)
            "IndicatorsFragment" -> loadFragment(indicatorsFragment)
            "StatisticsFragment" -> loadFragment(statisticsFragment)
            "HomeFragment" -> loadFragment(homeFragment)
            else -> loadFragment(homeFragment)
        }

        navigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.settingsFragment -> {
                    loadFragment(settingsFragment)
                    true
                }
                R.id.indicatorsFragment -> {
                    loadFragment(indicatorsFragment)
                    true
                }
                R.id.statisticsFragment -> {
                    loadFragment(statisticsFragment)
                    true
                }
                R.id.homeFragment -> {
                    loadFragment(homeFragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameContainer, fragment)
            .commit()
    }
}