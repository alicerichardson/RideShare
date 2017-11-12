package com.example.alicerichardson.rideshare;

import java.util.Comparator;

/**
 * Created by adaschnake on 11/11/17.
 */

public class ADate implements Comparable<ADate> {

    private int year;
    private int month;
    private int day;

    public ADate(int year, int month, int day)
    {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public String toString()
    {
        String result = "";
        switch(month){
            case 1:
                result+="January ";
                break;
            case 2:
                result+="February ";
                break;
            case 3:
                result+="March ";
                break;
            case 4:
                result+="April ";
                break;
            case 5:
                result+="May ";
                break;
            case 6:
                result+="June ";
                break;
            case 7:
                result+="July ";
                break;
            case 8:
                result+="August ";
                break;
            case 9:
                result+="September ";
                break;
            case 10:
                result+="October ";
                break;
            case 11:
                result+="November ";
                break;
            case 12:
                result+="December ";
                break;
        }
        result += day + ", "+year;
        return result;
    }

    @Override
    public int compareTo(ADate aDate) {
        return 0;
    }
}
