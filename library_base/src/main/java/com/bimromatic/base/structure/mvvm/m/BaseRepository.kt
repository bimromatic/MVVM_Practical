package com.bimromatic.base.structure.mvvm.m

import com.bimromatic.base.structure.entity.BaseRespondEntity
import com.bimromatic.base.structure.entity.State

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/12/6
 * desc   :
 * version: 1.0
 */
class BaseRepository {
    suspend fun <T : Any> executeRequest(
        block: suspend () -> BaseRespondEntity<T>
    ): BaseRespondEntity<T> {
        val baseData = block.invoke()
        if (baseData.code == 0) {
            //正确
            baseData.state = State.Success
        } else {
            //错误
            baseData.state = State.Error
        }
        return baseData
    }
}