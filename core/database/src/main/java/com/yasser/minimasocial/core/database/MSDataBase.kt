package com.yasser.minimasocial.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yasser.minimasocial.core.database.dao.PostDao
import com.yasser.minimasocial.core.database.dao.UserDao
import com.yasser.minimasocial.core.database.model.PostEntity
import com.yasser.minimasocial.core.database.model.UserEntity

@Database(
    entities = [
        PostEntity::class,
        UserEntity::class
    ],
    version = 1,
    exportSchema = false
)
internal abstract class MSDataBase : RoomDatabase() {

    abstract fun postDao(): PostDao
    abstract fun userDao(): UserDao

}