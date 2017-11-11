package com.example.alicerichardson.rideshare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Date;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by adaschnake on 11/11/17.
 */


public class PostActivity extends AppCompatActivity {

    Spinner toSpinner;
    Spinner fromSpinner;
    String[] results;
    EditText seats;
    CheckBox pets;
    CheckBox luggage;
    CheckBox smoking;
    CheckBox food;
    CheckBox money;
    HashMap<String, TreeSet> ridesMap;
    DatePicker datePicker;
    TimePicker timePicker;
    EditText timeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        populateSpinner(R.id.to_spinner);
        populateSpinner(R.id.from_spinner);

        fromSpinner = (Spinner) findViewById(R.id.from_spinner);
        toSpinner = (Spinner) findViewById(R.id.to_spinner);
        Button goButton = (Button) findViewById(R.id.go_button);
        seats = (EditText) findViewById(R.id.seatsText);
        pets = (CheckBox) findViewById(R.id.petBox);
        luggage = (CheckBox) findViewById(R.id.luggageBox);
        smoking = (CheckBox) findViewById(R.id.smokingBox);
        food = (CheckBox) findViewById(R.id.foodBox);
        money = (CheckBox) findViewById(R.id.moneyBox);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        timeText = (EditText) findViewById(R.id.time_text);


        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                createNewRide();
            }
        });
    }

    private void populateSpinner(int newSpinID) {
        Spinner spinner = (Spinner) findViewById(newSpinID);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.locations_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    public void createNewRide()
    {
        //get info from spinners, date/time, check boxes
        results = getSpinnerResultsArray();
        int numSeats = Integer.parseInt(seats.getText().toString());
        String time = timeText.getText().toString();
        //create new ride and add to
        // if destination is not yet in map
        if (ridesMap.containsKey(results[1])) {
            // add it to map with a new (empty) tree
            ridesMap.put(results[1], new TreeSet<Ride>());
        }
        // add ride to corresponding tree
        ridesMap.get(results[1]).add( new Ride(results[1], results[0], time, getDate(), numSeats, getCheckBoxResultsArray()));
        //show success toast

        //return to home screen
    }

    private String[] getSpinnerResultsArray()
    {
        //put the results from the spinners into an array
        String[] results =  {fromSpinner.getSelectedItem().toString(), toSpinner.getSelectedItem().toString()};
        return results;
    }

    private boolean[] getCheckBoxResultsArray()
    {
        boolean[] results = {pets.isChecked(), luggage.isChecked(), smoking.isChecked(), food.isChecked(), money.isChecked()};
        return results;
    }

    private Date getDate()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(new Date(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth()));
        return new Date(date);
    }

//    private String getTime()
//    {
//        return timePicker.getHour() + ";" + timePicker.getMinute();
//    }
}
