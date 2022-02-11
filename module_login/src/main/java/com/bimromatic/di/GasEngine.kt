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
class GasEngine @Inject constructor():Engine {
    override fun start() {
        println("GasEngine engine start")
    }

    override fun shutdown() {
        println("GasEngine engine shutdown")
    }
}