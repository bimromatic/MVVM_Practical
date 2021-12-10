package com.bimromatic.library_base.app

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/12/10
 * desc   :
 * version: 1.0
 * Link    :
 */
data class InitDepend(
    val mainThreadDepends: MutableList<() -> String>,
    val workerThreadDepends: MutableList<() -> String>
)
