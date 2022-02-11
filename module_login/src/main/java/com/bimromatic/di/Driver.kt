package com.bimromatic.di

import com.bimromatic.base.app.BaseApplication
import javax.inject.Inject
import javax.inject.Singleton

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2022/1/11
 * desc   :
 * version: 1.0
 * Link    :
 */

//无参构造函数的依赖注入方式
@Singleton
class Driver @Inject constructor(val application: BaseApplication) {

}