package com.delnortedevs.roompractice.db;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "TvShow")
public class TvShow {

    @PrimaryKey(autoGenerate = true)
    private long show_id;
    private String name;
    private String category;
    private int score;

    public TvShow(String name, String category, int score) {
        this.name = name;
        this.category = category;
        this.score = score;
    }

    public long getShow_id() {
        return show_id;
    }

    public void setShow_id(long show_id) {
        this.show_id = show_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
