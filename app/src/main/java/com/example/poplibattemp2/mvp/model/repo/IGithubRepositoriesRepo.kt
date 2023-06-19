package com.example.poplibattemp2.mvp.model.repo

import com.example.poplibattemp2.mvp.model.entity.GithubRepository
import com.example.poplibattemp2.mvp.model.entity.GithubUser
import io.reactivex.rxjava3.core.Single

interface IGithubRepositoriesRepo {
    fun getRepositories(user: GithubUser): Single<List<GithubRepository>>
}