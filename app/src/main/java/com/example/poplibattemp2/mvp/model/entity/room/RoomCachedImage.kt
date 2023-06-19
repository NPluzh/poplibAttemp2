package com.example.poplibattemp2.mvp.model.entity.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class RoomCachedImage(
    @PrimaryKey val url: String,
    val localPath: String
)