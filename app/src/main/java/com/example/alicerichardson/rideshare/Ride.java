package com.example.alicerichardson.rideshare;

import java.util.Date;

/**
 * Created by alicerichardson on 11/11/17.
 */

public class Ride{

    public int to;
    public int from;
    public int time;
    public Date date;
    public int seats;
    public boolean pets;
    public boolean luggage;
    public boolean smoking;
    public boolean food;

    public Ride(int to, int from, int time, Date date, int seats, boolean pets, boolean luggage, boolean smoking, boolean food){

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

//    DatePicker dp;
//    Date date;
//    protected void convertDatePicker() {

//        date = (DatePicker) findViewById(R.id.datePicker);
//        date = new Date();
//        next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
//                String dateFormat = dateformat.format(new Date(date.getYear(), date.getMonth(), date.getDayOfMonth()));
//                String nowDate = new SimpleDateFormat("yyyy-MM-dd").format(currentDate);
//                if (dateFormat.compareTo(nowDate) < 0) {
//                    Toast.makeText(getApplicationContext(), "The date is too old", Toast.LENGTH_LONG);
//                } else {
//                    Intent i = new Intent(UserMenu.this, UserMenuTime.class);
//                    i.putExtra("date", dateFormat);
//                    startActivity(i);
//                }
//            }
//        });
//    }



}
