package com.example.alicerichardson.rideshare;

import java.util.Date;

/**
 * Created by alicerichardson on 11/11/17.
 */

public class Request {

    public int to;
    public int from;
    public int time;
    public Date date;
    public int seats;
    public boolean pets;
    public boolean luggage;
    public boolean smoking;
    public boolean food;

    public Request(int to, int from, int time, Date date, int seats, boolean pets, boolean luggage, boolean smoking, boolean food){
        this.to = to;
        this.from = from;
        this.time = time;
        this.date = date;
        this.seats = seats;
        this.pets = pets;
        this.luggage = luggage;
        this.smoking = smoking;
        this.food = food;
    }

    public int compare(Ride ride){
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
