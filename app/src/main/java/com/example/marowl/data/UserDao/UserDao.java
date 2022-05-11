package com.example.marowl.data.UserDao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.marowl.entities.User;

@Dao
public interface UserDao {
    @Insert
    void registerUser(User user);
}
