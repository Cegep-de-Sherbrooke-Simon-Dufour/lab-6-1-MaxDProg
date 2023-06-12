package com.example.testviewholder.DI;

import android.content.Context;

import androidx.room.Room;

import com.example.testviewholder.Data.UserDataBase;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DatabaseProvider {
    @Provides
    public UserDataBase provideDatabase(@ApplicationContext Context context){
        return Room.databaseBuilder(context, UserDataBase.class, "database")
                .fallbackToDestructiveMigration()
                .build();

    }
}
