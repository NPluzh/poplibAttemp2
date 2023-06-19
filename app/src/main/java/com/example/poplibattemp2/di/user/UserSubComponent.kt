package com.example.poplibattemp2.di.user

import com.example.poplibattemp2.di.repository.RepositorySubcomponent
import com.example.poplibattemp2.di.user.module.UserModule
import com.example.poplibattemp2.mvp.presenter.UsersPresenter
import com.example.poplibattemp2.ui.adapter.UsersRVAdapter
import dagger.Subcomponent

@UserScope
@Subcomponent(
    modules = [
        UserModule::class
    ]
)
interface UserSubcomponent {
    fun repositorySubcomponent(): RepositorySubcomponent

    fun inject(usersPresenter: UsersPresenter)
    fun inject(usersRVAdapter: UsersRVAdapter)
}