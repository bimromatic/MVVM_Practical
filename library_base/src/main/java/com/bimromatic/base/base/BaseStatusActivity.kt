package com.bimromatic.base.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bimromatic.base.base.state.ViewStatusHelper

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/12/3
 * desc   : 基础状态管理Activity
 * version: 1.0
 */
open class BaseStatusActivity:AppCompatActivity() {
    /**
     * 基础状态管理帮助类
     */
    private var mBaseStatusHelper: ViewStatusHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //注册状态帮助类
        mBaseStatusHelper = onRegisterStatusHelper()
        //恢复状态数据
        mBaseStatusHelper?.onRestoreInstanceStatus(savedInstanceState)
    }

    /**
     * 保存状态
     */
    override fun onSaveInstanceState(outState: Bundle) {
        mBaseStatusHelper?.onSaveInstanceState(outState)
        super.onSaveInstanceState(outState)
    }

    /**
     * 注册状态管理帮助类,子类重写此方法以注册帮助类。
     * 每一层都有可能有自己的状态管理帮助类，所以继承重写的时候，需要将super的对象传入自己的帮助类构造函数中
     */
    protected open fun onRegisterStatusHelper(): ViewStatusHelper? {
        return null
    }
}