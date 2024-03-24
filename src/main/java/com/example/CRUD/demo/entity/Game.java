package com.example.CRUD.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="game_title")
    private String gameTitle;

    @Column(name="game_rating")
    private char gameRating;

    @Column(name="hours_to_beat")
    private int hoursToBeat;

    public Game(){};

    public Game(String gameTitle, char gameRating, int hoursToBeat){
        this.gameTitle = gameTitle;
        this.gameRating = gameRating;
        this.hoursToBeat = hoursToBeat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public char getGameRating() {
        return gameRating;
    }

    public void setGameRating(char gameRating) {
        this.gameRating = gameRating;
    }

    public int getHoursToBeat() {
        return hoursToBeat;
    }

    public void setHoursToBeat(int hoursToBeat) {
        this.hoursToBeat = hoursToBeat;
    }

    @Override
    public String toString(){
        return String.join(" ", String.valueOf(id), gameTitle, String.valueOf(gameRating), String.valueOf(hoursToBeat));
    }
}
