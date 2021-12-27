package com.bimromatic.base.untils.network

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/12/10
 * desc   :
 * version: 1.0
 * Link    :
 */
enum class NetworkTypeEnum {

    /**
     * 使用蜂窝移动网络传输
     */
    TRANSPORT_CELLULAR,

    /**
     * 使用Wi-Fi传输
     */
    TRANSPORT_WIFI,

    /**
     * 使用蓝牙传输
     */
    TRANSPORT_BLUETOOTH,

    /**
     * 使用以太网传输
     */
    TRANSPORT_ETHERNET,

    /**
     * 使用 VPN 传输
     */
    TRANSPORT_VPN,

    /**
     * 使用 Wi-Fi Aware 传输
     */
    TRANSPORT_WIFI_AWARE,

    /**
     * 使用 LoWPAN 传输
     */
    TRANSPORT_LOWPAN,

    /**
     * 其他
     */
    OTHER
}