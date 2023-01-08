package com.example.csi_dmce.database

import androidx.room.*

@Dao
interface UserDAO {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE user_id = :id")
    fun getUserById(id: Int): User

    @Query("SELECT EXISTS (SELECT * FROM user WHERE email = :user_email and password_hash = :user_passwd_hash)")
    fun exists(user_email: String, user_passwd_hash :String) : Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Delete
    fun delete(user: User)
}