package com.bimromatic.base.untils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.bimromatic.base.app.BaseApplication
import java.lang.reflect.Field

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2022/1/13
 * desc   : 解决 Android 自身的 Bug
 * version: 1.0
 * Link    :
 */
class AndroidBugFixUtils {
    /**
     * 解决 InputMethodManager 造成的内存泄露
     *
     * 使用方式：
     * ```
     * override fun onDestroy() {
     *     AndroidBugFixUtils().fixSoftInputLeaks(this)
     *     super.onDestroy()
     * }
     * ```
     */
    open  fun fixSoftInputLeaks(activity: Activity) {
        val imm =
            BaseApplication.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val leakViews = arrayOf("mLastSrvView", "mCurRootView", "mServedView", "mNextServedView")
        for (leakView in leakViews) {
            try {
                val leakViewField: Field =
                    InputMethodManager::class.java.getDeclaredField(leakView) ?: continue
                if (!leakViewField.isAccessible) leakViewField.isAccessible = true
                val view: Any? = leakViewField.get(imm)
                if (view !is View) continue
                if (view.rootView == activity.window.decorView.rootView) {
                    leakViewField.set(imm, null)
                }
            } catch (t: Throwable) {
            }
        }
    }


    private var field: Field? = null
    private var hasField = true

    /**
     * 处理华为手机mlastsrvview内存泄露的FixMemLeakUtils工具类:
     */
    open fun fixLeak(context: Context) {
        if (!hasField) {
            return
        }
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            ?: return
        val arr = arrayOf("mLastSrvView")
        for (param in arr) {
            try {
                if (field == null) {
                    try {
                        field = imm.javaClass.getDeclaredField(param)
                    } catch (e: NoSuchFieldException) {
                        e.printStackTrace()
                    }
                }
                if (field == null) {
                    hasField = false
                }
                if (field != null) {
                    field!!.isAccessible = true
                    field!![imm] = null
                }
            } catch (t: Throwable) {
                t.printStackTrace()
            }
        }
    }
}