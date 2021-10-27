package com.example.p2mvc;
// Modelo
public class Student {
    // Variables miebro
    private int mNoControl;
    private String mName;
    private int mScore;

    public Student(int noControl, String name, int score) {
        mNoControl = noControl;
        mName = name;
        mScore = score;
    }

    public int getNoControl() {
        return mNoControl;
    }

    public void setNoControl(int noControl) {
        mNoControl = noControl;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getScore() {
        return mScore;
    }

    public void setScore(int score) {
        mScore = score;
    }
}
