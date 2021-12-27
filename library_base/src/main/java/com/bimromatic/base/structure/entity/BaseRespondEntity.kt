package com.bimromatic.base.structure.entity

import com.google.gson.annotations.SerializedName

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/12/7
 * desc   :
 * version: 1.0
 */
class BaseRespondEntity<T> {

    @SerializedName("errorCode")
    var code = -1
    @SerializedName("errorMsg")
    var msg: String? = null
    var data: T? = null
    var state: State = State.Error
}

enum class State {
    Success, Error
}

