package com.example.dapiton_banse_week2.roomModel.Person;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DaoUserAccounts {
    //---------------- Insert Section for the database ---------------------------///
    @Insert
    void insertAccount(UserAccounts user);
    @Insert
    void insertPossesions(Possesions possessions);

    //---------------- Display data from the database ---------------------------///

    //--- list all the accounts except the user_id who's currently login
    @Query("Select * from UserAccounts where user_id != :userID")
    List<UserAccounts> getAllAccountsExcept(int userID);

    //-- Get all active possesions
    @Query("Select * from possesions")
    List<Possesions> getAllPossesions();

    //-- Get possesions by id of person
    @Query("Select * from possesions where user_id = :user_id")
    List<Possesions> getPossesionByID(int user_id);

    @Query("Select * from UserAccounts")
    List<UserAccounts> getAllAccounts();

    @Query("Select * from UserAccounts where user_id = :user_id Limit 1")
    UserAccounts getUserByID(int user_id);

    //---------------- Update data from the database ---------------------------///
    @Update
    void updateAccount(UserAccounts user);
    @Query("Update Possesions set user_id = :user_id, possesion_name = :possessionName, value = :value, status = :status where possession_id = :id")
    void updatePossesions(int id, int user_id, String possessionName, double value, String status);

    //---------------- Delete data from the database ---------------------------///

    @Delete
    void deleteAccount(UserAccounts user);

    @Query("Delete from possesions where possession_id = :id")
    void deletePossesions(int id);



}
