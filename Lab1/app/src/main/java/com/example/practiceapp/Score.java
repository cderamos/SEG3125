package com.example.practiceapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

class Score implements Parcelable {
    private int score;
    private String title;
    private String date;

    public Score(int score, String title, String date) {
        this.score = score;
        this.title = title;
        this.date = date;
    }

    protected Score(Parcel in) {
        score = in.readInt();
        title = in.readString();
        date = in.readString();
    }

    public static final Creator<Score> CREATOR = new Creator<Score>() {
        @Override
        public Score createFromParcel(Parcel in) {
            return new Score(in);
        }

        @Override
        public Score[] newArray(int size) {
            return new Score[size];
        }
    };

    public void setDate(String date) {
        this.date = date;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(score);
        parcel.writeString(title);
        parcel.writeString(date);
    }
}
