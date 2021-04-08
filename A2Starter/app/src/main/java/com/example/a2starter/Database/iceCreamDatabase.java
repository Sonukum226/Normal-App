package com.example.a2starter.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.a2starter.Dao.iceCreamDao;
import com.example.a2starter.Modal.iceCream;

@Database(entities = {iceCream.class},version =1,exportSchema = false)
public abstract class iceCreamDatabase extends RoomDatabase {
    private static iceCreamDatabase database;
    public static final String DATABASE_NAME="iceCream";


    public synchronized static iceCreamDatabase getInstance(Context context){
        //Check condition

        if (database==null){
            //when databse is null , initialize it
            database=Room.databaseBuilder(context.getApplicationContext(),iceCreamDatabase.class,DATABASE_NAME)
                    .allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return database;
    }

    public abstract iceCreamDao iceCreamDao();//to call Dao class



}
