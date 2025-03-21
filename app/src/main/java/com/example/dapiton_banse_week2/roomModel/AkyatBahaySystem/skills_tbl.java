package com.example.dapiton_banse_week2.roomModel.AkyatBahaySystem;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class skills_tbl {
    @PrimaryKey(autoGenerate = true)
    private int skill_id;
    private String skill_name;
    private String description;

    public int getSkill_id() {
        return skill_id;
    }

    public void setSkill_id(int skill_id) {
        this.skill_id = skill_id;
    }

    public String getSkill_name() {
        return skill_name;
    }

    public void setSkill_name(String skill_name) {
        this.skill_name = skill_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public skills_tbl(String skill_name, String description) {
        this.skill_name = skill_name;
        this.description = description;
    }

    public skills_tbl(int skill_id, String skill_name, String description) {
        this.skill_id = skill_id;
        this.skill_name = skill_name;
        this.description = description;
    }
}
