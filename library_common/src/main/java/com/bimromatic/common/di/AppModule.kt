package com.bimromatic.common.di

import android.app.Application
import com.bimromatic.base.app.BaseApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2022/1/11
 * desc   :
 * version: 1.0
 * Link    :
 */

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun providerAppInstance(application: Application):BaseApplication{
        return application as BaseApplication
    }

}