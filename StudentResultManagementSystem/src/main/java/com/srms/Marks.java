package com.srms;

public class Marks {
    private int maths;
    private int science;
    private int english;

    // Set marks
    public void setMarks(int maths, int science, int english) {
        this.maths = maths;
        this.science = science;
        this.english = english;
    }

    // Get marks
    public int getMaths() {
        return maths;
    }

    public int getScience() {
        return science;
    }

    public int getEnglish() {
        return english;
    }
}
