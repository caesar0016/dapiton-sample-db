package com.example.dapiton_banse_week2.roomModel;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class person {
    @PrimaryKey(autoGenerate = true)
    private int person_id;
    private String firstName;
    private String lastName;
    private String age;
    private String birthday;

}
