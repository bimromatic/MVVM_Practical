package com.bimromatic.common.structure.mvvm.v

import androidx.viewbinding.ViewBinding
import com.bimromatic.library_base.structure.mvvm.v.BaseVmActivity
import com.bimromatic.library_base.structure.mvvm.vm.BaseViewModel

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/12/10
 * desc   :
 * version: 1.0
 * Link    :
 */
abstract class BaseActivity<VB:ViewBinding,VM:BaseViewModel>: BaseVmActivity<VB,VM> (){
}