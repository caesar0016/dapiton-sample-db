package com.example.dapiton_banse_week2.roomModel.PrisonerSystem;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DaoPrisoner {
    @Insert
    void insertPrisoner(Prisoner prisoner);

    @Query("Select * from prisoner_tbl")
    List<Prisoner> getAllPrisoners();

    //--Get specific prisoner id
    @Query("Select * from prisoner_tbl where prisoner_id = :prisoner_id")
    Prisoner getPrisonerByID(int prisoner_id);

    @Update
    void updatePrisoner(Prisoner prisoner);

    @Delete
    void deletePrisoner(Prisoner prisoner);

    //--Release the prisoner
    @Query("Update prisoner_tbl set isReleased = 1 where prisoner_id = :prisonerId")
    void releasePrisoner(int prisonerId);

}
