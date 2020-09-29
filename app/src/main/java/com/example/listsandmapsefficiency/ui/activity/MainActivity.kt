package com.example.listsandmapsefficiency.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.listsandmapsefficiency.R
import com.example.listsandmapsefficiency.databinding.ActivityMainBinding
import com.example.listsandmapsefficiency.interfaces.Calculable
import com.example.listsandmapsefficiency.interfaces.LoadingDialogListener
import com.example.listsandmapsefficiency.interfaces.NumberCallback
import com.example.listsandmapsefficiency.ui.dialog.LoadingDialog
import com.example.listsandmapsefficiency.ui.dialog.PutNumberDialog
import com.example.listsandmapsefficiency.ui.fragment.adapter.FragmentPagerAdapter
import com.example.listsandmapsefficiency.util.Constants
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.lang.IllegalStateException

class MainActivity : AppCompatActivity(), NumberCallback, LoadingDialogListener {

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    private val loadingDialog: LoadingDialog = LoadingDialog.newInstance()
    private val tabTitles = arrayOf(R.string.lists, R.string.maps)
    private lateinit var binding: ActivityMainBinding
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.apply {
            setContentView(root)
            this@MainActivity.tabLayout = tabLayout

            viewPager.adapter = FragmentPagerAdapter(this@MainActivity)

            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.setText(tabTitles[position])
                viewPager.setCurrentItem(tab.position, true)
            }.attach()

            btnShowDialog.setOnClickListener {
                PutNumberDialog().show(supportFragmentManager, Constants.OPEN_DIALOG)
            }
        }
    }

    /**
     * Receive data from PutNumberDialog
     * and send data to current (resumed) fragment
     */
    override fun putNumber(number: Int) {
        for (fragment in supportFragmentManager.fragments) {
            if (fragment is Calculable && fragment.isResumed) {
                (fragment as? Calculable)?.calculate(number)
            }
        }
    }

    override fun showLoadingDialog() {
        loadingDialog.show(supportFragmentManager, Constants.START_LOADING)
    }

    override fun dismissLoadingDialog() {
        val dialog: LoadingDialog? =
            supportFragmentManager.findFragmentByTag(Constants.START_LOADING) as? LoadingDialog

        try {
            if (dialog!!.getShownStatus()) {
                dialog.dismiss()
            }
        } catch (e: NullPointerException) {
            Log.e(TAG, "NullPointerException: ${e.printStackTrace()}")
        } catch (e: IllegalStateException) {
            Log.e(TAG, "IllegalStateException: ${e.printStackTrace()}")
        }
    }
}