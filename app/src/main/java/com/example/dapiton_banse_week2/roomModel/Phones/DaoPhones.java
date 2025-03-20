package com.example.dapiton_banse_week2.roomModel.Phones;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DaoPhones {

    @Insert
    void insertPhone(PhoneSpecs phone);

    @Update
    void updatePhone(PhoneSpecs phone);

    @Delete
    void deletedPhone(PhoneSpecs phone);

    //-- List all the phones
    @Query("Select * from PhoneSpecs")
    List<PhoneSpecs> getAllPhones();

    @Query("Select * from PhoneSpecs where phone_id = :id")
    List<PhoneSpecs> getPhonesByID(int id);

}
