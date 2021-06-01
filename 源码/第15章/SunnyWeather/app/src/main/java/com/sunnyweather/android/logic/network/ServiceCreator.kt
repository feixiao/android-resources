package com.sunnyweather.android.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// 使用object关键字让ServiceCreator成为了一个单例类
object ServiceCreator {

    // 注意这些都是用private修饰符来声明的，相当于对于外部而言它们都是不可见的。
    private const val BASE_URL = "https://api.caiyunapp.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // 一个外部可见的create()方法，并接收一个Class类型的参数。
    // 当在外部调用这个方法时，实际上就是调用了Retrofit对象的create()方法，从而创建出相应Service接口的动态代理对象
    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    // 又定义了一个不带参数的create()方法，并使用inline关键字来修饰方法，使用reified关键字来修饰泛型，这是泛型实化的两大前提条件
    inline fun <reified T> create(): T = create(T::class.java)

}
