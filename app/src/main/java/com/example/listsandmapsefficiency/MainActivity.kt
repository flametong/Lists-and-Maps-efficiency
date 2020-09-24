package com.example.listsandmapsefficiency

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.listsandmapsefficiency.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    private lateinit var viewPager: ViewPager2
    private lateinit var binding: ActivityMainBinding
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.apply {
            setContentView(root)
            this@MainActivity.tabLayout = tabLayout
            this@MainActivity.viewPager = viewPager

            btnShowDialog.setOnClickListener {
                PutNumberDialog().show(supportFragmentManager, Constants.OPEN_DIALOG)
            }
        }
    }
}