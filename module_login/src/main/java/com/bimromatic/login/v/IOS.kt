package com.bimromatic.login.v

import com.google.auto.service.AutoService

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2022/2/11
 * desc   :
 * version: 1.0
 * Link    :
 */
@AutoService(Book::class)
class IOS :Book {
    override fun name(): String {
        return "ios"
    }

}