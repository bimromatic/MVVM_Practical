package com.bimromatic.base.structure.mvvm.v

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.bimromatic.base.structure.mvvm.vm.BaseViewModel

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/12/3
 * desc   :
 * version: 1.0
 */
abstract class BaseVmFragment<VB:ViewBinding,VM : BaseViewModel>: Fragment() {
}