package com.example.poplibattemp2.mvp.model.cache

import com.example.poplibattemp2.mvp.model.entity.GithubUser
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface IGithubUsersCache {
    fun getUsers(): Single<List<GithubUser>>
    fun putUsers(users: List<GithubUser>) : Completable
}