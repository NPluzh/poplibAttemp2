package com.example.poplibattemp2.navigation

import com.example.poplibattemp2.mvp.model.entity.GithubRepository
import com.example.poplibattemp2.mvp.model.entity.GithubUser
import com.example.poplibattemp2.ui.fragment.RepositoryFragment
import com.example.poplibattemp2.ui.fragment.UserFragment
import com.example.poplibattemp2.ui.fragment.UsersFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class Screens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
    override fun user(user: GithubUser) = FragmentScreen { UserFragment.newInstance(user) }
    override fun repository(repo: GithubRepository) = FragmentScreen { RepositoryFragment.newInstance(repo) }
}


/*
class UsersScreen() : SupportAppScreen() {
    override fun getFragment() = UsersFragment.newInstance()
}

class UserScreen(val user: GithubUser) : SupportAppScreen() {
    override fun getFragment() = UserFragment.newInstance(user)
}

class RepositoryScreen(val user: GithubRepository) : SupportAppScreen() {
    override fun getFragment() = RepositoryFragment.newInstance(user)
}*/