package com.example.dapiton_banse_week2.roomModel.Phones;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PhoneSpecs {
    @PrimaryKey(autoGenerate = true)
    private int phone_id;
    private String brand;
    private String name;
    private String color;
    private int storage;

    public int getPhone_id() {
        return phone_id;
    }

    public PhoneSpecs(String brand, String name, String color, int storage) {
        this.brand = brand;
        this.name = name;
        this.color = color;
        this.storage = storage;
    }

    public PhoneSpecs(int phone_id, String brand, String name, String color, int storage) {
        this.phone_id = phone_id;
        this.brand = brand;
        this.name = name;
        this.color = color;
        this.storage = storage;
    }

    public void setPhone_id(int phone_id) {
        this.phone_id = phone_id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }
}
