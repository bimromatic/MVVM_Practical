package com.bimromatic.di

import javax.inject.Inject

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2022/1/11
 * desc   :
 * version: 1.0
 * Link    :
 */
class ElectricEngine @Inject constructor() :Engine {
    override fun start() {
        println("ElectricEngine engine start")
    }

    override fun shutdown() {
        println("ElectricEngine engine shutdown")
    }
}