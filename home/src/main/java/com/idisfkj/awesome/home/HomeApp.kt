package com.idisfkj.awesome.home

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.idisfkj.awesome.common.utils.SPUtils
import com.idisfkj.awesome.componentbridge.app.DefaultAppBridge
import com.idisfkj.awesome.componentbridge.di.AppComponentFactory
import com.idisfkj.awesome.componentbridge.provider.BridgeProviders
import com.idisfkj.awesome.home.di.AppComponent
import com.idisfkj.awesome.home.di.DaggerAppComponent
import timber.log.Timber

/**
 * Created by idisfkj on 2019-09-03.
 * Email : idisfkj@gmail.com.
 */
class HomeApp : Application(), AppComponentFactory<AppComponent> {

    override fun onCreate() {
        super.onCreate()
        SPUtils.init(this)
        initTimber()
        initRouter()
        // register bridges
        BridgeProviders.instance.register(DefaultAppBridge::class.java)
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initRouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }

    override fun create(): AppComponent = DaggerAppComponent.factory().create(this)
}