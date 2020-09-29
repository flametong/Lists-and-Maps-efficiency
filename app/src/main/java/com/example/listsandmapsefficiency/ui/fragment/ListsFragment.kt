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
import com.example.listsandmapsefficiency.R
import com.example.listsandmapsefficiency.interfaces.Calculable
import com.example.listsandmapsefficiency.interfaces.LoadingDialogListener
import com.example.listsandmapsefficiency.repository.CustomSharedPreferences
import com.example.listsandmapsefficiency.util.Constants
import com.example.listsandmapsefficiency.util.LoadingState
import com.example.listsandmapsefficiency.viewmodel.ListsViewModel
import javax.inject.Inject

class ListsFragment : Fragment(), Calculable {

    companion object {
        private val TAG = ListsFragment::class.simpleName

        fun newInstance(): ListsFragment {
            val args = Bundle()
            val fragment = ListsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var mViewModel: ListsViewModel
    private lateinit var mUnbinder: Unbinder

    @BindViews(
        R.id.tvArr1,
        R.id.tvArr2,
        R.id.tvArr3,
        R.id.tvArr4,
        R.id.tvArr5,
        R.id.tvArr6,
        R.id.tvArr7,
        R.id.tvLinked1,
        R.id.tvLinked2,
        R.id.tvLinked3,
        R.id.tvLinked4,
        R.id.tvLinked5,
        R.id.tvLinked6,
        R.id.tvLinked7,
        R.id.tvCOWArr1,
        R.id.tvCOWArr2,
        R.id.tvCOWArr3,
        R.id.tvCOWArr4,
        R.id.tvCOWArr5,
        R.id.tvCOWArr6,
        R.id.tvCOWArr7
    )
    lateinit var tvLists: List<@JvmSuppressWildcards TextView>

    @Inject
    lateinit var sharedPref: CustomSharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lists, container, false)
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        mUnbinder = ButterKnife.bind(this, view)
        super.onViewCreated(view, savedInstanceState)

        for (i in tvLists.indices) {
            tvLists[i].text = sharedPref.loadData(Constants.listOfListsKeys[i])
        }

        mViewModel = ViewModelProvider(this).get(ListsViewModel::class.java)

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
        mViewModel.startCalculation(Constants.listOfListsKeys, number)
    }

    private fun showData(postDataList: ArrayList<Int>) {
        tvLists[postDataList[0]].text = postDataList[1].toString()
    }
}