package com.bimromatic.base.base.state

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2022/1/14
 * desc   :
 * version: 1.0
 * Link    :
 */
enum class NetState {
    STATE_UNSTART,//未知
    STATE_LOADING,//加载中
    STATE_SUCCESS,//成功
    STATE_EMPTY,//数据为null
    STATE_FAILED,//接口请求成功但是服务器返回error
    STATE_ERROR//请求失败
}