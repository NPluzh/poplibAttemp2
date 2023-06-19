package com.example.poplibattemp2.di.module

import com.example.poplibattemp2.mvp.model.api.IDataSource
import com.example.poplibattemp2.mvp.model.cache.IGithubRepositoriesCache
import com.example.poplibattemp2.mvp.model.cache.IGithubUsersCache
import com.example.poplibattemp2.mvp.model.network.INetworkStatus
import com.example.poplibattemp2.mvp.model.repo.IGithubRepositoriesRepo
import com.example.poplibattemp2.mvp.model.repo.IGithubUsersRepo
import com.example.poplibattemp2.mvp.model.repo.retrofit.RetrofitGithubRepositoriesRepo
import com.example.poplibattemp2.mvp.model.repo.retrofit.RetrofitGithubUsersRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {

    @Singleton
    @Provides
    fun usersRepo(api: IDataSource, networkStatus: INetworkStatus, cache: IGithubUsersCache): IGithubUsersRepo =
        RetrofitGithubUsersRepo(api, networkStatus, cache)

    @Singleton
    @Provides
    fun repositoriesRepo(api: IDataSource, networkStatus: INetworkStatus, cache: IGithubRepositoriesCache): IGithubRepositoriesRepo =
        RetrofitGithubRepositoriesRepo(api, networkStatus, cache)

}