package com.bimromatic.common.di

import com.bimromatic.common.util.cvs.VersionStatus
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2022/1/11
 * desc   :
 * version: 1.0
 * Link    :
 */
@Module//它的初始声明和刚才的EngineModule非常相似，只不过这里没有将它声明成抽象类，因为我们不会在这里定义抽象函数。
@InstallIn(SingletonComponent::class)
class DINetworkModule {
    /**
     * [OkHttpClient]依赖提供方法
     *
     * @return OkHttpClient
     */
    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        // 日志拦截器部分
        //val isDebug = BuildConfig.VERSION_TYPE != VersionStatus.RELEASE
        return OkHttpClient.Builder()
            .connectTimeout(15L * 1000L, TimeUnit.MILLISECONDS)
            .readTimeout(20L * 1000L, TimeUnit.MILLISECONDS)
            //.addInterceptor(AuthInterceptor())
            //.addInterceptor(HttpInterceptor(isDebug))//加入有优先级，先加入先执行
            .retryOnConnectionFailure(true)
            .build()
    }

    /**
     * 项目主要服务器地址的[Retrofit]依赖提供方法
     *
     * @param okHttpClient OkHttpClient OkHttp客户端
     * @return Retrofit
     */
    @Singleton
    @Provides
    fun provideMainRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            //.baseUrl(NetBaseUrlConstant.MAIN_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
}