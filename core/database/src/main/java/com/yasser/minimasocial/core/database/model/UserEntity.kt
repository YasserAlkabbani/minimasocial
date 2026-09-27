package com.yasser.minimasocial.core.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("user")
data class UserEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "phone") val phone: String,
    @ColumnInfo(name = "emailVerified") val emailVerified: Boolean,
    @ColumnInfo(name = "current_user") val currentUser: Boolean,
)