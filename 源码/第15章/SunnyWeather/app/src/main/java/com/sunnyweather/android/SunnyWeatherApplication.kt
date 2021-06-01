package com.sunnyweather.android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context



// 使用MVVM这种分层架构的设计，由于从ViewModel层开始就不再持有Activity的引用了，因此经常会出现“缺Context”的情况。
class SunnyWeatherApplication : Application() {

    // If you need to write a function that can be called without having a class instance but needs access to the internals of a class (for example, a factory method),
    // you can write it as a member of an object declaration inside that class.
    companion object {

        const val TOKEN = "BNBRvBveaD2VfHVI" // 填入你申请到的令牌值

        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}