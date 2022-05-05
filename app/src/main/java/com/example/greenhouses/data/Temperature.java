package com.example.greenhouses.data;

public class Temperature {
    private int id;
    private float dagre;
    private String date;
    private String time;

    public Temperature() {
    }

    public Temperature(int id, float dagre, String date, String time) {
        this.id = id;
        this.dagre = dagre;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getDagre() {
        return dagre;
    }

    public void setDagre(float dagre) {
        this.dagre = dagre;
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
