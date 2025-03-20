package com.example.dapiton_banse_week2.roomModel.Person;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DaoUserAccounts {

    @Insert
    void insertAccount(UserAccounts user);

    @Query("Select * from UserAccounts")
    List<UserAccounts> getAllAccounts();

    //--- list all the accounts except the user_id who's currently login
    @Query("Select * from UserAccounts where user_id != :userID")
    List<UserAccounts> getAllAccountsExcept(int userID);

    @Query("Select * from UserAccounts where user_id = :user_id Limit 1")
    UserAccounts getUserByID(int user_id);

    @Update
    void updateAccount(UserAccounts user);

    @Delete
    void deleteAccount(UserAccounts user);

}
