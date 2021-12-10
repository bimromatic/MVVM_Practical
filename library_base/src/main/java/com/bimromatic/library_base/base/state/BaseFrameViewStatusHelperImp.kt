package com.bimromatic.library_base.base.state

import android.os.Bundle

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/12/10
 * desc   : 视图，activity，fragment重建帮助类
 * version: 1.0
 * Link    :
 */
open class BaseFrameViewStatusHelperImp(parentViewStatusHelper: ViewStatusHelper? = null):ViewStatusHelper(parentViewStatusHelper) {

    /**
     * 重建标记key 以包名保存数据可以防止嵌套层级出现重复Key
     */
    private val KEY_RECREATE =
        "com.bimromatic.library_base.base.state.Recreate"

    /**
     * 是否重建
     */
    var isRecreate = false
        private set


    /**
     * 恢复状态
     */
    override fun onRestoreInstanceStatus(savedInstanceState: Bundle?) {
        super.onRestoreInstanceStatus(savedInstanceState)
        isRecreate = savedInstanceState?.getBoolean(KEY_RECREATE) ?: false
    }

    /**
     * 保存状态
     */
    override fun onSaveInstanceState(bundle: Bundle) {
        super.onSaveInstanceState(bundle)
        bundle.putBoolean(KEY_RECREATE, true)
    }
}