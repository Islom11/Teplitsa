package com.example.greenhouses.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Data {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int idDB;
    private String owner;
    private String createAt;
    private float tempUpsta;
    private float tempDowns;
    private float tempGround;
    private float tempStreet;
    private float humGreen;
    private float humGround;
    private String date;
    private String time;

    public Data(int idDB, String owner, String createAt, float tempUpsta, float tempDowns, float tempGround, float tempStreet, float humGreen, float humGround, String date, String time) {
        this.idDB = idDB;
        this.owner = owner;
        this.createAt = createAt;
        this.tempUpsta = tempUpsta;
        this.tempDowns = tempDowns;
        this.tempGround = tempGround;
        this.tempStreet = tempStreet;
        this.humGreen = humGreen;
        this.humGround = humGround;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public int getIdDB() {
        return idDB;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdDB(int idDB) {
        this.idDB = idDB;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public float getTempUpsta() {
        return tempUpsta;
    }

    public void setTempUpsta(float tempUpsta) {
        this.tempUpsta = tempUpsta;
    }

    public float getTempDowns() {
        return tempDowns;
    }

    public void setTempDowns(float tempDowns) {
        this.tempDowns = tempDowns;
    }

    public float getTempGround() {
        return tempGround;
    }

    public void setTempGround(float tempGround) {
        this.tempGround = tempGround;
    }

    public float getTempStreet() {
        return tempStreet;
    }

    public void setTempStreet(float tempStreet) {
        this.tempStreet = tempStreet;
    }

    public float getHumGreen() {
        return humGreen;
    }

    public void setHumGreen(float humGreen) {
        this.humGreen = humGreen;
    }

    public float getHumGround() {
        return humGround;
    }

    public void setHumGround(float humGround) {
        this.humGround = humGround;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
