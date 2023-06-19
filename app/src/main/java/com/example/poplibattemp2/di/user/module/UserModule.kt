package com.example.poplibattemp2.di.user.module

import com.example.poplibattemp2.di.user.UserScope
import com.example.poplibattemp2.mvp.model.api.IDataSource
import com.example.poplibattemp2.mvp.model.cache.IGithubUsersCache
import com.example.poplibattemp2.mvp.model.cache.room.RoomGithubUsersCache
import com.example.poplibattemp2.mvp.model.entity.room.Database
import com.example.poplibattemp2.mvp.model.network.INetworkStatus
import com.example.poplibattemp2.mvp.model.repo.IGithubUsersRepo
import com.example.poplibattemp2.mvp.model.repo.retrofit.RetrofitGithubUsersRepo
import dagger.Module
import dagger.Provides

@Module
open class UserModule {

    @Provides
    fun usersCache(database: Database): IGithubUsersCache {
        return RoomGithubUsersCache(database)
    }


    @UserScope
    @Provides
    open fun usersRepo(api: IDataSource, networkStatus: INetworkStatus, cache: IGithubUsersCache): IGithubUsersRepo {
        return RetrofitGithubUsersRepo(api, networkStatus, cache)
    }
}