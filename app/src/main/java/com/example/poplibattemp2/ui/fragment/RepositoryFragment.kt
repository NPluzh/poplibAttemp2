package com.example.poplibattemp2.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.poplibattemp2.R
import com.example.poplibattemp2.databinding.FragmentRepositoryBinding
import com.example.poplibattemp2.mvp.model.entity.GithubRepository
import com.example.poplibattemp2.mvp.presenter.RepositoryPresenter
import com.example.poplibattemp2.mvp.view.RepositoryView
import com.example.poplibattemp2.ui.App
import com.example.poplibattemp2.ui.BackButtonListener
import com.example.poplibattemp2.ui.adapter.ReposotoriesRVAdapter
import com.github.terrakok.cicerone.Router
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class RepositoryFragment : MvpAppCompatFragment(), RepositoryView, BackButtonListener {

    private var _binding: FragmentRepositoryBinding? = null
    private val binding
        get() = _binding!!

    @Inject
    lateinit var router: Router

    companion object {
        private const val REPOSITORY_ARG = "repository"

        fun newInstance(repository: GithubRepository) = RepositoryFragment().apply {
            arguments = Bundle().apply {
                putParcelable(REPOSITORY_ARG, repository)
            }
        }
    }

    val presenter: RepositoryPresenter by moxyPresenter {
        val repository = arguments?.getParcelable<GithubRepository>(REPOSITORY_ARG) as GithubRepository

        RepositoryPresenter(repository).apply {
            App.instance.repositorySubcomponent?.inject(this)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        FragmentRepositoryBinding.inflate(inflater, container, false).also {
            _binding = it
        }.root

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun init() {}

    override fun setId(text: String) {
        binding.tvId.text = text
    }

    override fun setTitle(text: String) {
        binding.tvTitle.text = text
    }

    override fun setForksCount(text: String) {
        binding.tvForksCount.text = text
    }

    override fun backPressed() = presenter.backPressed()
}