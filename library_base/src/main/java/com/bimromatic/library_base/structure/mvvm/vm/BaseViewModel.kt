package com.bimromatic.library_base.structure.mvvm.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/12/3
 * desc   : viewmodel+liveData { VM层 }
 * version: 1.0
 */
open class BaseViewModel:ViewModel() {

    //loading
    val loadingLiveData = SingleLiveData<Boolean>()
    //异常
    val errorLiveData = SingleLiveData<String>()

    /**
     * @param request 正常逻辑
     * @param error 异常处理
     * @param showLoading 请求网络时是否展示Loading
     */
    fun launchRequest(
        showLoading: Boolean = true,
        error: suspend (String) -> Unit = { errMsg ->
            //默认异常处理，子类可以进行覆写
            errorLiveData.postValue(errMsg)
        }, request: suspend () -> Unit
    ) {
        //是否展示Loading
        if (showLoading) {
            loadStart()
        }

        //使用viewModelScope.launch开启协程
        viewModelScope.launch(Dispatchers.IO) {
            try {
                request()
            } catch (e: Exception) {
                error(e.message ?: "")
            } finally {
                if (showLoading) {
                    loadFinish()
                }
            }
        }
    }

    private fun loadStart() {
        loadingLiveData.postValue(true)
    }

    private fun loadFinish() {
        loadingLiveData.postValue(false)
    }
}