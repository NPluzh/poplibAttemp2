package com.example.poplibattemp2.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poplibattemp2.R
import com.example.poplibattemp2.databinding.FragmentUserBinding
import com.example.poplibattemp2.di.repository.RepositorySubcomponent
import com.example.poplibattemp2.mvp.model.entity.GithubUser
import com.example.poplibattemp2.mvp.model.entity.room.Database
import com.example.poplibattemp2.mvp.presenter.UserPresenter
import com.example.poplibattemp2.mvp.view.UserView
import com.example.poplibattemp2.navigation.IScreens
import com.example.poplibattemp2.ui.App
import com.example.poplibattemp2.ui.BackButtonListener
import com.example.poplibattemp2.ui.adapter.ReposotoriesRVAdapter
import com.github.terrakok.cicerone.Router
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class UserFragment : MvpAppCompatFragment(), UserView, BackButtonListener {

    private var _binding: FragmentUserBinding? = null
    private val binding
        get() = _binding!!

    @Inject
    lateinit var database: Database
    @Inject
    lateinit var router: Router
    @Inject
    lateinit var screens: IScreens

    val presenter: UserPresenter by moxyPresenter {
        val user = arguments?.getParcelable<GithubUser>(USER_ARG) as GithubUser

        UserPresenter(user).apply {
            App.instance.initRepositorySubcomponent()?.inject(this)
        }
    }

    var adapter: ReposotoriesRVAdapter? = null

    companion object {
        private const val USER_ARG = "user"

        fun newInstance(user: GithubUser) = UserFragment().apply {
            arguments = Bundle().apply {
                putParcelable(USER_ARG, user)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        FragmentUserBinding.inflate(inflater, container, false).also {
            _binding = it
        }.root

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun init() {
        binding.rvRepositories.layoutManager = LinearLayoutManager(context)
        adapter = ReposotoriesRVAdapter(presenter.repositoriesListPresenter)
        binding.rvRepositories.adapter = adapter
    }

    override fun setLogin(text: String) {
        binding.tvLogin.text = text
    }

    override fun release() {

    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()
}