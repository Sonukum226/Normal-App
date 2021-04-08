package com.example.a2starter.Repository;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;


import androidx.room.Room;

import com.example.a2starter.Dao.iceCreamDao;
import com.example.a2starter.Database.iceCreamDatabase;
import com.example.a2starter.Modal.iceCream;

public class iceCreamRepository {
    private String DB_NAME="ICE_CREAM";
    private iceCreamDao iceCreamDao;
    private iceCreamDatabase Ice_database;

    public iceCreamRepository(Context context)
    {
        Ice_database= Room.databaseBuilder(context,iceCreamDatabase.class,DB_NAME).build();
    }

    public void insert(int id,String ice_cream, String description,int price,int quantity)
    {
        iceCream data=new iceCream();
        data.setId(id);
        data.setNmae(ice_cream);
        data.setDescription(description);
        data.setPrice(price);
        data.setQuantity(quantity);

        iceCreamDao.insert(data);
    }

    public int update(int id,int quantity){
      return  iceCreamDao.update(id,quantity);

    }

}
