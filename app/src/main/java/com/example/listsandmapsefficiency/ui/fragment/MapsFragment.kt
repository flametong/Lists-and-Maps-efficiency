package com.example.listsandmapsefficiency.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import butterknife.BindViews
import butterknife.ButterKnife
import butterknife.Unbinder
import com.example.listsandmapsefficiency.App
import com.example.listsandmapsefficiency.repository.CustomSharedPreferences
import com.example.listsandmapsefficiency.R
import com.example.listsandmapsefficiency.interfaces.Calculable
import com.example.listsandmapsefficiency.interfaces.LoadingDialogListener
import com.example.listsandmapsefficiency.util.Constants
import com.example.listsandmapsefficiency.util.LoadingState
import com.example.listsandmapsefficiency.viewmodel.MapsViewModel
import javax.inject.Inject

class MapsFragment : Fragment(), Calculable {

    companion object {
        fun newInstance(): MapsFragment {
            val args = Bundle()
            val fragment = MapsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var mViewModel: MapsViewModel
    private lateinit var mUnbinder: Unbinder

    @BindViews(
        R.id.tvTreeMap1,
        R.id.tvTreeMap2,
        R.id.tvTreeMap3,
        R.id.tvHashMap1,
        R.id.tvHashMap2,
        R.id.tvHashMap3
    )
    lateinit var tvMaps: List<@JvmSuppressWildcards TextView>

    @Inject
    lateinit var sharedPref: CustomSharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        mUnbinder = ButterKnife.bind(this, view)
        super.onViewCreated(view, savedInstanceState)

        for (i in tvMaps.indices) {
            tvMaps[i].text = sharedPref.loadData(Constants.listOfMapKeys[i])
        }

        mViewModel = ViewModelProvider(this).get(MapsViewModel::class.java)

        mViewModel.loadingState.observe(this) {
            when (it.status) {
                LoadingState.Status.RUNNING -> {
                    (activity as? LoadingDialogListener)?.showLoadingDialog()
                }
                LoadingState.Status.SUCCESS -> {
                    (activity as? LoadingDialogListener)?.dismissLoadingDialog()
                }
                LoadingState.Status.FAILED -> {
                    Toast.makeText(
                        context,
                        R.string.loading_failed,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        mViewModel.getResultListData().observe(this) {
            showData(postDataList = it)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mUnbinder.unbind()
    }

    override fun calculate(number: Int) {
        mViewModel.startCalculation(Constants.listOfMapKeys, number)
    }

    private fun showData(postDataList: ArrayList<Int>) {
        tvMaps[postDataList[0]].text = postDataList[1].toString()
    }
}