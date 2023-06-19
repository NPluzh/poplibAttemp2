package com.example.poplibattemp2.mvp.presenter

import com.example.poplibattemp2.mvp.view.MainView
import com.example.poplibattemp2.navigation.IScreens
import com.example.poplibattemp2.navigation.Screens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import javax.inject.Inject

class MainPresenter() : MvpPresenter<MainView>() {

    @Inject
    lateinit var router: Router

    @Inject lateinit var screens: IScreens

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.users())
    }

    fun backClicked() {
        router.exit()
    }
}

