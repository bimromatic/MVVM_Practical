package com.bimromatic.library_base.base

import android.view.View
import androidx.fragment.app.Fragment

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/12/3
 * desc   :
 * version: 1.0
 */
abstract class BaseFragment:Fragment() {
    abstract val layoutId:Int
    var mViewBinding: View? = null

}