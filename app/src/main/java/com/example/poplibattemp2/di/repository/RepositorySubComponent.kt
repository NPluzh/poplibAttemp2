package com.example.poplibattemp2.di.repository

import com.example.poplibattemp2.di.repository.module.RepositoryModule
import com.example.poplibattemp2.mvp.presenter.RepositoryPresenter
import com.example.poplibattemp2.mvp.presenter.UserPresenter
import dagger.Subcomponent

@RepositoryScope
@Subcomponent(
    modules = [
        RepositoryModule::class
    ]
)
interface RepositorySubcomponent {
    fun inject(userPresenter: UserPresenter)
    fun inject(repositoryPresenter: RepositoryPresenter)
}