package com.example.dapiton_banse_week2.roomModel.PrisonerSystem;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "prisoner_tbl",
        foreignKeys = {
                @ForeignKey(
                    entity = Crime.class,
                    parentColumns = "crime_id",
                    childColumns = "crime_id",
                        onDelete = ForeignKey.CASCADE
                )
        }
)

public class Prisoner {
    @PrimaryKey(autoGenerate = true)
    private int prisoner_id;
    private String prisoner_name;
    private String gender;
    private int age;
    private boolean isReleased = false;
    private int crime_id;

    public int getPrisoner_id() {
        return prisoner_id;
    }

    public void setPrisoner_id(int prisoner_id) {
        this.prisoner_id = prisoner_id;
    }

    public String getPrisoner_name() {
        return prisoner_name;
    }

    public void setPrisoner_name(String prisoner_name) {
        this.prisoner_name = prisoner_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isReleased() {
        return isReleased;
    }

    public void setReleased(boolean released) {
        isReleased = released;
    }

    public int getCrime_id() {
        return crime_id;
    }

    public void setCrime_id(int crime_id) {
        this.crime_id = crime_id;
    }

    @Override
    public String toString() {
        return "Prisoner{" +
                "prisoner_id=" + prisoner_id +
                ", prisoner_name='" + prisoner_name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", isReleased=" + isReleased +
                ", crime_id=" + crime_id +
                '}';
    }

    public Prisoner(int prisoner_id, String prisoner_name, String gender, int age, boolean isReleased, int crime_id) {
        this.prisoner_id = prisoner_id;
        this.prisoner_name = prisoner_name;
        this.gender = gender;
        this.age = age;
        this.isReleased = isReleased;
        this.crime_id = crime_id;
    }
}
