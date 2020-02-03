package com.example.practiceapp;

import java.util.Date;

class Score {
    private int score;
    private String title;
    private String date;

    public Score(int score, String title, String date) {
        this.score = score;
        this.title = title;
        this.date = date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
