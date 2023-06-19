package com.example.poplibattemp2.ui

import android.app.Application
import com.example.poplibattemp2.di.AppComponent
import com.example.poplibattemp2.di.DaggerAppComponent
import com.example.poplibattemp2.di.module.AppModule
import com.example.poplibattemp2.di.repository.RepositorySubcomponent
import com.example.poplibattemp2.di.user.UserSubcomponent

class App : Application(){

    lateinit var appComponent: AppComponent
        private set

    var userSubcomponent: UserSubcomponent? = null
        private set

    var repositorySubcomponent: RepositorySubcomponent? = null
        private set

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    fun initUserSubcomponent() = appComponent.userSubcomponent().also {
        userSubcomponent = it
    }

    fun initRepositorySubcomponent() = userSubcomponent?.repositorySubcomponent().also {
        repositorySubcomponent = it
    }


}
