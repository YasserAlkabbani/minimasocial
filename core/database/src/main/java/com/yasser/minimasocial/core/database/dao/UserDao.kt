package com.yasser.minimasocial.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.yasser.minimasocial.core.database.model.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Upsert
    suspend fun upsertUser(user: UserEntity)

    @Query("SELECT * FROM user WHERE current_user = 1")
    suspend fun getCurrentUser(): UserEntity

    @Query("SELECT * FROM user WHERE id = :userID")
    suspend fun getUserByID(userID: String): UserEntity

}