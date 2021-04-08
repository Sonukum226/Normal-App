package com.example.a2starter.Modal;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "iceCream",indices = @Index(value={"id"},unique=true))
public class iceCream {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @SerializedName("name")
    @ColumnInfo(name = "name")
    public String name;

    @SerializedName("description")
    @ColumnInfo(name = "description")
    private String description;

    @SerializedName("price")
    @ColumnInfo(name = "price")
    private float price;

    @SerializedName("quantity")
    @ColumnInfo(name = "quantity")
    private int quantity;

    public iceCream(int id, String nmae, String description, float price, int quantity) {
        this.id = id;
        this.name = nmae;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNmae(String nmae) {
        this.name = nmae;
    }

    public String getNmae() {
        return name;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public iceCream()
    {

    }
}
