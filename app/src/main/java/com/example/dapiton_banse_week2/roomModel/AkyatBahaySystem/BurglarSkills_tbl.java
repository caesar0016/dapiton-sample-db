package com.example.dapiton_banse_week2.roomModel.AkyatBahaySystem;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {
        @ForeignKey(
                entity = Burglars.class,
                parentColumns = "burglar_id",
                childColumns = "burglar_id",
                onDelete = ForeignKey.CASCADE
        ),
        @ForeignKey(
                entity = skills_tbl.class,
                parentColumns = "skill_id",
                childColumns = "skill_id",
                onDelete = ForeignKey.CASCADE
        )
})
public class BurglarSkills_tbl {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int burglar_id;
    private int skill_id;
    private int levels = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBurglar_id() {
        return burglar_id;
    }

    public void setBurglar_id(int burglar_id) {
        this.burglar_id = burglar_id;
    }

    public int getSkill_id() {
        return skill_id;
    }

    public void setSkill_id(int skill_id) {
        this.skill_id = skill_id;
    }

    public int getLevels() {
        return levels;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }

    public BurglarSkills_tbl(int burglar_id, int skill_id, int levels) {
        this.burglar_id = burglar_id;
        this.skill_id = skill_id;
        this.levels = levels;
    }

    public BurglarSkills_tbl(int id, int burglar_id, int skill_id, int levels) {
        this.id = id;
        this.burglar_id = burglar_id;
        this.skill_id = skill_id;
        this.levels = levels;
    }
}
