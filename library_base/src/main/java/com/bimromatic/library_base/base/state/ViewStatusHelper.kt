package com.bimromatic.library_base.base.state

import android.os.Bundle

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/12/10
 * desc   : 采用了一种链式调用，所有对象持有自己父级帮助类，进行场景回复时先恢复链头的数据
 * version: 1.0
 * Link    :
 */
abstract class ViewStatusHelper(val parentViewStatusHelper: ViewStatusHelper?) {

    open fun onRestoreInstanceStatus(savedInstanceState: Bundle?) {
        parentViewStatusHelper?.onRestoreInstanceStatus(savedInstanceState)
    }

    open fun onSaveInstanceState(bundle: Bundle) {
        parentViewStatusHelper?.onSaveInstanceState(bundle)
    }
}