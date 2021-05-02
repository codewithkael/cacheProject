package com.codewithkael.masoudcachesystem.persistence;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.codewithkael.masoudcachesystem.ImageModel;


@Database(entities = {ImageModel.class},version = 3)

public abstract class LocationDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "image_db";

    private static LocationDatabase instance;

   public static LocationDatabase getInstance(final Context context){
        if (instance == null) {
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    LocationDatabase.class,
                    DATABASE_NAME
            ).fallbackToDestructiveMigration().build();

        }
        return instance;
    }

    public abstract LocationDao getLocationDao();

}
