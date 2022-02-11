package com.bimromatic.base.entity

import com.google.gson.annotations.SerializedName

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/12/7
 * desc   : 基类==>实体类
 * version: 1.0
 */
data class BaseRespondEntity<T> (
    var code:Int = 0,
    var msg: String? = null,
    var data: T? = null,
    var state: State = State.Error
)

enum class State {
    Success, Error
}

