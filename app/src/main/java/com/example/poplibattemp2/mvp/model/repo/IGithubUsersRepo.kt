package com.example.poplibattemp2.mvp.model.repo

import com.example.poplibattemp2.mvp.model.entity.GithubUser
import io.reactivex.rxjava3.core.Single

interface IGithubUsersRepo {
    fun getUsers(): Single<List<GithubUser>>
}