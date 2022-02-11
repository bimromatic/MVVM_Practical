package com.bimromatic.login.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bimromatic.base.structure.mvvm.vm.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/12/7
 * desc   :
 * version: 1.0
 */

@HiltViewModel
class LoginVm @Inject constructor(): BaseViewModel() {
    val contentList = MutableLiveData<MutableList<String>>()
}