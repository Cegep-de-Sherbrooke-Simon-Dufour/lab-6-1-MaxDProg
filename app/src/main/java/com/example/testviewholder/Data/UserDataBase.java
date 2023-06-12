package com.example.testviewholder.Data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version =2)
public abstract class UserDataBase  extends RoomDatabase {

    public abstract UserDAO getDAO();

}
