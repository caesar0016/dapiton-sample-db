package com.example.dapiton_banse_week2.roomModel.AkyatBahaySystem;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DaoAkyatBahay {
    //------------------------------------- Insert sections per tables -----------------------------------

    @Insert
    void insertBurglar(Burglars burglar);

    @Insert
    void insertSkill(skills_tbl skill);

    @Insert
    void insertBurglarSkills_tbl(BurglarSkills_tbl burg_skills);

    //------------------------------------- Update sections per tables -----------------------------------

    @Update
    void updateBurglar(Burglars burglar);

    @Update
    void updateSkill(skills_tbl skill);

    @Update
    void updateBurglarSkills(BurglarSkills_tbl burg_skills);

    //-------------------------- This is the list sections sections ----------------------------


    //-- Gets all the Burglars
    @Query("Select * from Burglars")
    List<Burglars> getListBurglars();

    //-- Search for a specific Burglars
    @Query("Select * from Burglars where burglar_id = :id")
    List<Burglars> getSpecicBurglar(int id);

    //-- Gets all active skills
    @Query("Select * from skills_tbl")
    List<skills_tbl> getListSkills();

    //-- Gets all the burglar matching with skills;
    @Query("Select * from burglarskills_tbl")
    List<BurglarSkills_tbl> getBurglarWithSkills();

    //-- Getting specific
    @Query("Select * from burglarskills_tbl where burglar_id = id")
    List<BurglarSkills_tbl> specificBurglarwithSkills(int id);


    //------------------------------------- Delete sections per tables -----------------------------------
    @Query("Delete from BurglarSkills_tbl where burglar_id = :burglar_id and skill_id = :skill_id")
    void delSkillsBurglar(int burglar_id, int skill_id);

    @Delete
    void deleteBurglar(Burglars burglar);

    @Delete
    void deleteSkills(skills_tbl skills);

}
