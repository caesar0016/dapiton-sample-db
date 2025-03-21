package com.example.dapiton_banse_week2.roomModel.AkyatBahaySystem;

import androidx.room.Entity;

@Entity
public class Burglars {
    private int burglar_id;
    private String name;
    private int burglar_level = 0   ;

    public int getBurglar_id() {
        return burglar_id;
    }

    public void setBurglar_id(int burglar_id) {
        this.burglar_id = burglar_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBurglar_level() {
        return burglar_level;
    }

    public void setBurglar_level(int burglar_level) {
        this.burglar_level = burglar_level;
    }

    public Burglars(String name, int burglar_level) {
        this.name = name;
        this.burglar_level = burglar_level;
    }

    public Burglars(int burglar_id, String name, int burglar_level) {
        this.burglar_id = burglar_id;
        this.name = name;
        this.burglar_level = burglar_level;
    }
}
