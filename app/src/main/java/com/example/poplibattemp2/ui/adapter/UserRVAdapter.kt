package com.example.poplibattemp2.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.poplibattemp2.R
import com.example.poplibattemp2.databinding.ItemUserBinding
import com.example.poplibattemp2.mvp.model.image.IImageLoader
import com.example.poplibattemp2.mvp.presenter.list.IUserListPresenter
import com.example.poplibattemp2.mvp.view.list.UserItemView
import kotlinx.android.extensions.LayoutContainer
import javax.inject.Inject

class UsersRVAdapter(val presenter: IUserListPresenter) : RecyclerView.Adapter<UsersRVAdapter.ViewHolder>() {

    @Inject
    lateinit var imageLoader: IImageLoader<ImageView>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder{
        val biding: ItemUserBinding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(biding)
    }


    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.pos = position
        holder.containerView.setOnClickListener { presenter.itemClickListener?.invoke(holder) }
        presenter.bindView(holder)
    }

    override fun onViewRecycled(holder: ViewHolder) {
        super.onViewRecycled(holder)
        holder.removeAvatar()
    }

   inner class ViewHolder(var binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root),
        LayoutContainer, UserItemView {
        override var pos = -1
        override val containerView: View = binding.root
       override fun setLogin(text: String) = with(containerView) { binding.tvLogin.text = text }
        override fun loadAvatar(url: String) = with(containerView) { imageLoader.loadInto(url, binding.ivAvatar) }
        fun removeAvatar() = with(containerView) { binding.ivAvatar.setImageDrawable(null)

        }
    }
}