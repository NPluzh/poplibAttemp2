package com.example.poplibattemp2.di.module

import android.widget.ImageView
import com.example.poplibattemp2.mvp.model.cache.image.IImageCache
import com.example.poplibattemp2.mvp.model.cache.image.room.RoomImageCache
import com.example.poplibattemp2.mvp.model.entity.room.Database
import com.example.poplibattemp2.mvp.model.image.IImageLoader
import com.example.poplibattemp2.mvp.model.network.INetworkStatus
import com.example.poplibattemp2.ui.App
import com.example.poplibattemp2.ui.image.GlideImageLoader
import dagger.Module
import dagger.Provides
import java.io.File
import javax.inject.Named
import javax.inject.Singleton

@Module
class ImageModule {

    @Named("cacheDir")
    @Singleton
    @Provides
    fun cacheDir(app: App): File = app.cacheDir

    @Singleton
    @Provides
    fun imageCache(database: Database, @Named("cacheDir") cacheDir: File): IImageCache = RoomImageCache(database, cacheDir)

    @Singleton
    @Provides
    fun imageLoader(cache: IImageCache, networkStatus: INetworkStatus): IImageLoader<ImageView> = GlideImageLoader(cache, networkStatus)

}