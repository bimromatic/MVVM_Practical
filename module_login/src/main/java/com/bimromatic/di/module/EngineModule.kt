package com.bimromatic.di.module

import com.bimromatic.di.ElectricEngine
import com.bimromatic.di.Engine
import com.bimromatic.di.GasEngine
import com.bimromatic.di.anno.BindElectricEngine
import com.bimromatic.di.anno.BindGasEngine
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Named

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2022/1/11
 * desc   :
 * version: 1.0
 * Link    :
 */
@Module
@InstallIn(ActivityComponent::class)
abstract class EngineModule {

    @Binds//@Bind注解，这样Hilt才能识别它
    //@BindGasEngine
    @Named("gas")
    //这里解释下为什么用抽象函数：(/**因为我们并不需实现具体的函数体*/)
    //抽象函数的返回值必须是Engine，表示用于给Engine类型的接口提供实例。那么提供什么实例给它呢？抽象函数接收了什么参数，就提供什么实例给它
    abstract fun bindEngine(gasEngine: GasEngine):Engine

    @Binds//@Bind注解，这样Hilt才能识别它
    //@BindElectricEngine
    @Named("electric")
    abstract fun bindElectricEngine(electricEngine: ElectricEngine):Engine

}