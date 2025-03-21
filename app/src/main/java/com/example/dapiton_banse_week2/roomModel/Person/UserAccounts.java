package com.example.dapiton_banse_week2.roomModel.Person;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class UserAccounts {
    @PrimaryKey(autoGenerate = true)
    private int user_id;
    private String username;
    private String password;
    private String userType = "Guest";

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    @Ignore
    public UserAccounts(int user_id, String username, String password, String userType) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public UserAccounts(String username, String password, String userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }
}
