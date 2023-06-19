package com.example.poplibattemp2.mvp.model.repo.retrofit

import com.example.poplibattemp2.mvp.model.api.IDataSource
import com.example.poplibattemp2.mvp.model.cache.IGithubUsersCache
import com.example.poplibattemp2.mvp.model.network.INetworkStatus
import com.example.poplibattemp2.mvp.model.repo.IGithubUsersRepo
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitGithubUsersRepo(val api: IDataSource, val networkStatus: INetworkStatus, val cache: IGithubUsersCache) :
    IGithubUsersRepo {
    override fun getUsers() = networkStatus.isOnlineSingle().flatMap { isOnline ->
        if (isOnline) {
            api.getUsers()
                .flatMap { users ->
                    cache.putUsers(users).toSingleDefault(users)
                }
        } else {
            cache.getUsers()
        }
    }.subscribeOn(Schedulers.io())
}