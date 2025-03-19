package com.example.dapiton_banse_week2.roomModel.PrisonerSystem;

import androidx.room.PrimaryKey;

public class Crime {
    @PrimaryKey(autoGenerate = true)
    private int crime_id;
    private String crimeName;
    private String description;

    public Crime(int crime_id, String crimeName, String description) {
        this.crime_id = crime_id;
        this.crimeName = crimeName;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Crime{" +
                "crime_id=" + crime_id +
                ", crimeName='" + crimeName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public int getCrime_id() {
        return crime_id;
    }

    public void setCrime_id(int crime_id) {
        this.crime_id = crime_id;
    }

    public String getCrimeName() {
        return crimeName;
    }

    public void setCrimeName(String crimeName) {
        this.crimeName = crimeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
