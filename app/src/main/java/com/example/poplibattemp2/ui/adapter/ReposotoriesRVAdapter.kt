package com.example.poplibattemp2.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.poplibattemp2.databinding.ItemRepositoryBinding
import com.example.poplibattemp2.mvp.presenter.list.IRepositoryListPresenter
import com.example.poplibattemp2.mvp.view.list.RepositoryItemView
import kotlinx.android.extensions.LayoutContainer


class ReposotoriesRVAdapter(val presenter: IRepositoryListPresenter) :
    RecyclerView.Adapter<ReposotoriesRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder{
        val binding: ItemRepositoryBinding = ItemRepositoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.pos = position
        holder.binding.tvName.setOnClickListener{ presenter.itemClickListener?.invoke(holder) }
        //holder.containerView.setOnClickListener { presenter.itemClickListener?.invoke(holder) }
        presenter.bindView(holder)
    }


    class ViewHolder(var binding: ItemRepositoryBinding) : RecyclerView.ViewHolder(binding.root), LayoutContainer, RepositoryItemView {
        override var pos = -1
        override fun setName(text: String) = with(containerView) { binding.tvName.text = text }
        override var containerView: View? = binding.root



    }
}


