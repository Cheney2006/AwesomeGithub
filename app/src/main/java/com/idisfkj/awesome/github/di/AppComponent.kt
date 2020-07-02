package com.idisfkj.awesome.github.di

import android.content.Context
import com.idisfkj.awesome.componentbridge.di.ViewModelBuilderModule
import com.idisfkj.awesome.github.ui.main.di.MainComponent
import com.idisfkj.awesome.github.ui.welcome.di.WelcomeComponent
import com.idisfkj.awesome.home.fragment.di.HomeFragmentComponent
import com.idisfkj.awesome.network.di.NetworkModule
import com.idisfkj.awesome.notification.fragment.di.NotificationFragmentComponent
import com.idisfkj.awesome.user.fragment.di.UserFragmentComponent
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

/**
 * Created by idisfkj on 2020/6/16.
 * Email: idisfkj@gmail.com.
 */
@Singleton
@Component(
    modules = [
        SubComponentModule::class,
        NetworkModule::class,
        ViewModelBuilderModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }

    fun welcomeComponent(): WelcomeComponent.Factory

    fun mainComponent(): MainComponent.Factory

    fun homeFragmentComponent(): HomeFragmentComponent.Factory

    fun userFragmentComponent(): UserFragmentComponent.Factory

    fun notificationFragmentComponent(): NotificationFragmentComponent.Factory

}

@Module(
    subcomponents = [
        WelcomeComponent::class,
        MainComponent::class,
        HomeFragmentComponent::class,
        UserFragmentComponent::class,
        NotificationFragmentComponent::class
    ]
)
object SubComponentModule

