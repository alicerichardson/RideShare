package com.example.alicerichardson.rideshare;

import java.util.Date;

/**
 * Created by alicerichardson on 11/11/17.
 */

public class Ride implements Comparable<Ride>{

    public String to;
    public String from;
    public int time;
    public Date date;
    public int seats;
    public boolean pets;
    public boolean luggage;
    public boolean smoking;
    public boolean food;
    public boolean money;

<<<<<<< Updated upstream
    public Ride(String to, String from, int time, Date date, int seats, boolean[] preferences){
=======
    public Ride(String to, String from, String time, Date date, int seats, boolean[] preferences){
>>>>>>> Stashed changes

        this.to = to;
        this.from = from;
        this.time = time;
        this.date = date;
        this.seats = seats;
<<<<<<< Updated upstream
        pets = preferences[0];
        luggage = preferences[1];
        smoking = preferences[2];
        food = preferences[3];
        money = preferences[4];
=======
        this.pets = pets;
        this.luggage = luggage;
        this.smoking = smoking;
        this.food = food;
        this.money = money;

>>>>>>> Stashed changes
    }

    public int compareTo(Ride ride){
        if(ride.date.compareTo(date) > 0){
            return 1;
        }
        else if (ride.date.compareTo(date) < 0){
            return -1;
        }
        else {
            return 0;
        }
    }





}
