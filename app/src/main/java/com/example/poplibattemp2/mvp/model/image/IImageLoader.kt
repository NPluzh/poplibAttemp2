package com.example.poplibattemp2.mvp.model.image

interface IImageLoader<T> {
    fun loadInto(url: String, container: T)
}