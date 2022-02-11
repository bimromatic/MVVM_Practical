package com.bimromatic.di

import com.bimromatic.di.anno.BindElectricEngine
import com.bimromatic.di.anno.BindGasEngine
import javax.inject.Inject
import javax.inject.Named

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2022/1/11
 * desc   :
 * version: 1.0
 * Link    :
 */

//@Inject (这里的作用其实是让hilt 这个构造函数 可以提供 truck 实例)
//todo Truck的构造函数中所依赖的所有其他对象都支持依赖注入了，那么Truck才可以被依赖注入
class Truck @Inject constructor(val driver: Driver,@Named("electric")val electricengine: Engine) {



//    @Inject//这里和在构造函数的道理是一样的
//    @BindGasEngine
//    lateinit var gasengine: Engine
//
//
//    @Inject//这里和在构造函数的道理是一样的
//    @BindElectricEngine
//    lateinit var electricengine: Engine

    fun deliver(){
        //gasengine.start()
        //gasengine.shutdown()
        println("Truck is delivering cargo.$driver")

        electricengine.start()
        electricengine.shutdown()
    }
}