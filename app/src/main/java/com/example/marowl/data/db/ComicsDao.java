package com.example.marowl.data.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.marowl.model.Comics;

import java.util.List;

@Dao
public interface ComicsDao {
@Query("SELECT*FROM comics")
List<Comics> getComics();



}
