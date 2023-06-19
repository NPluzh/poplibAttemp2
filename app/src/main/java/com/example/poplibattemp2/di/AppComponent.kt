package com.example.poplibattemp2.di

import com.example.poplibattemp2.di.module.*
import com.example.poplibattemp2.di.user.UserSubcomponent
import com.example.poplibattemp2.mvp.presenter.MainPresenter
import com.example.poplibattemp2.ui.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        AppModule::class,
        DatabaseModule::class,
        CiceroneModule::class,
        ImageModule::class
    ]
)
interface AppComponent {
    fun userSubcomponent() : UserSubcomponent

    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
}