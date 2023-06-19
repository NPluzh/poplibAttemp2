package com.example.poplibattemp2.di.repository.module

import com.example.poplibattemp2.di.repository.RepositoryScope
import com.example.poplibattemp2.mvp.model.api.IDataSource
import com.example.poplibattemp2.mvp.model.cache.IGithubRepositoriesCache
import com.example.poplibattemp2.mvp.model.cache.room.RoomGithubRepositoriesCache
import com.example.poplibattemp2.mvp.model.entity.room.Database
import com.example.poplibattemp2.mvp.model.network.INetworkStatus
import com.example.poplibattemp2.mvp.model.repo.IGithubRepositoriesRepo
import com.example.poplibattemp2.mvp.model.repo.retrofit.RetrofitGithubRepositoriesRepo
import dagger.Module
import dagger.Provides

@Module
open class RepositoryModule {

    @Provides
    fun repositoriesCache(database: Database): IGithubRepositoriesCache {
        return RoomGithubRepositoriesCache(database)
    }

    @RepositoryScope
    @Provides
    fun repositoriesRepo(api: IDataSource, networkStatus: INetworkStatus, cache: IGithubRepositoriesCache): IGithubRepositoriesRepo {
        return RetrofitGithubRepositoriesRepo(api, networkStatus, cache)
    }
}