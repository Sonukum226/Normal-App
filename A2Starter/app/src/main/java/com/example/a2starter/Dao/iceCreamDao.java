package com.example.a2starter.Dao;

import android.provider.UserDictionary;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.a2starter.Modal.iceCream;

import java.util.List;

@Dao
public interface iceCreamDao {

   // The selected on conflict strategy ignores a new word if it's exactly the same as one already in the list.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(iceCream iceCream);

    @Query("UPDATE iceCream SET quantity =:quantity WHERE id = :id")
    int update(int id,int quantity);

//    @Query("SELECT * FROM iceCream")
//    LiveData<List<iceCream>> getAlliceCream();

    @Delete
    void deleteAll(List<iceCream> iceCream);

}
