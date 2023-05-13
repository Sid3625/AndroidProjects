package com.example.scango;

import androidx.room.Database;
import androidx.room.RoomDatabase;


//@Database(entities = {PopularProduct.class}, version = 1)


@Database(entities = {Product.class}, version = 1)
public abstract class AppDatabase2 extends RoomDatabase
{
    public abstract ProductDao ProductDao();
}

