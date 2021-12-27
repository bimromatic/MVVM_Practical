//package com.bimromatic.base.untils.theme
//
//import android.content.Context
//import android.text.format.DateUtils
//import androidx.appcompat.app.AppCompatDelegate
//
///**
// * author : bimromatic
// * e-mail : xxx@xx
// * time   : 2021/12/24
// * desc   : https://zhuanlan.zhihu.com/p/347697316
// * version: 1.0
// * Link    :
// */
//class NightModeUtils constructor(context:Context) {
//
//    private val mSpf = context.getSharedPreferences("config_data", Context.MODE_PRIVATE)
//
//    companion object {
//
//        @Volatile
//        private var INSTANCE: NightModeUtils? = null
//
//        @JvmStatic
//        fun getInstance(context: Context) : NightModeUtils =
//            INSTANCE ?: synchronized(this) {
//                INSTANCE ?: NightModeUtils(context).also {
//                    INSTANCE = it
//                }
//            }
//
//        private const val SPF_THEME_MODE = "theme_mode"
//        private const val SPF_THEME_TIMER = "theme_timer"
//    }
//
//    /** 获取设置 */
//    private fun getSpfThemeMode() : Int = mSpf.getInt(SPF_THEME_MODE, ThemeMode.MODE_FOLLOW_SYSTEM.intValue)
//
//    /** 设置 */
//    private fun setSpfThemeMode(mode: Int) {
//        mSpf.edit().putInt(SPF_THEME_MODE, mode).apply()
//    }
//
//    /** 获取时间设置 */
//    private fun getSpfThemeTimer() : String = mSpf.getString(SPF_THEME_TIMER, null)?: "18:00~08:00"
//
//    /** 设置时间 */
//    private fun setSpfThemeTimer(timer: String) {
//        mSpf.edit().putString(SPF_THEME_TIMER, timer).apply()
//    }
//
//    /** 获取设置好的ThemeMode */
//    fun getThemeMode(): ThemeMode = ThemeMode.parseOfInt(getSpfThemeMode())
//
//    /** 设置模式 */
//    fun setThemeMode(mode: ThemeMode) {
//        setSpfThemeMode(mode.intValue)
//    }
//
//    /** 获取设置好的定时时间 */
//    fun getThemeTime(): ThemeTime {
//        val timeStr = getSpfThemeTimer()
//        return ThemeTime(
//            beginHour = timeStr.split("~")[0].split(":")[0].toInt(),
//            beginMinute = timeStr.split("~")[0].split(":")[1].toInt(),
//            endHour = timeStr.split("~")[1].split(":")[0].toInt(),
//            endMinute = timeStr.split("~")[1].split(":")[1].toInt()
//        )
//    }
//
//    /** 设置定时时间 */
//    fun setThemeTime(time: ThemeTime) {
//        setSpfThemeTimer(time.toTimerString())
//    }
//
//    /**
//     * 应用存储的设置
//     */
//    fun applySetting() {
//        // 检查主题
//        val themeModeInt = getSpfThemeMode()
//        val themeMode = ThemeMode.parseOfInt(themeModeInt)
//        AppCompatDelegate.setDefaultNightMode(when(themeMode) {
//            ThemeMode.MODE_ALWAYS_ON -> AppCompatDelegate.MODE_NIGHT_YES
//            ThemeMode.MODE_ALWAYS_OFF -> AppCompatDelegate.MODE_NIGHT_NO
//            ThemeMode.MODE_FOLLOW_SYSTEM -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
//            else -> {
//                val time = getThemeTime()
//
//                val startTime = time.startTime.replace(":", ".").toFloat()
//                val stopTime = time.stopTime.replace(":", ".").toFloat()
//                val curTime = DateUtils.getCurDateStr("HH.mm").toFloat()
//                if (stopTime > startTime) {
//                    // 结束时间和开始时间都在同一天
//                    if (curTime > startTime && curTime < stopTime) {
//                        AppCompatDelegate.MODE_NIGHT_YES
//                    } else {
//                        AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
//                    }
//                } else {
//                    // 结束时间在开始时间的后一天
//                    if (curTime > startTime || curTime < stopTime) {
//                        AppCompatDelegate.MODE_NIGHT_YES
//                    } else {
//                        AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
//                    }
//                }
//            }
//        })
//    }
//}