package com.example.dapiton_banse_week2.roomModel.Person;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {
        @ForeignKey(
                entity = UserAccounts.class,
                parentColumns = "user_id",
                childColumns = "user_id",
                onDelete = ForeignKey.SET_NULL
        ),      //-- for adding another foreign key
})
public class Possesions {
    @PrimaryKey
    private int possession_id;
    private int user_id;
    private String possesion_name;
    private double value = 0;
    private String status; // Example: "Owned", "Leased", "Rented", "For Sale"

    public int getPossession_id() {
        return possession_id;
    }

    public void setPossession_id(int possession_id) {
        this.possession_id = possession_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPossesion_name() {
        return possesion_name;
    }

    public void setPossesion_name(String possesion_name) {
        this.possesion_name = possesion_name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @Ignore
    public Possesions(int user_id, String possesion_name, double value, String status) {
        this.user_id = user_id;
        this.possesion_name = possesion_name;
        this.value = value;
        this.status = status;
    }

    public Possesions(int user_id, int possession_id, String possesion_name, double value, String status) {
        this.user_id = user_id;
        this.possession_id = possession_id;
        this.possesion_name = possesion_name;
        this.value = value;
        this.status = status;
    }
}
