package com.example.alicerichardson.rideshare;

import android.net.Uri;
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

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Date;
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
    EditText emailText;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

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
        //timePicker = (TimePicker) findViewById(R.id.timePicker);
        timeText = (EditText) findViewById(R.id.time_text);
        emailText = (EditText) findViewById(R.id.email_text);


        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                createNewRide();
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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

    public void createNewRide() {
        //get info from spinners, date/time, check boxes
        results = getSpinnerResultsArray();
        int numSeats = Integer.parseInt(seats.getText().toString());
        int time = Integer.parseInt(timeText.getText().toString());
        String email = emailText.getText().toString();
        ADate date = new ADate(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
        //create new ride and add to
        // if destination is not yet in map
        if (ridesMap.containsKey(results[1])) {
            // add it to map with a new (empty) tree
            ridesMap.put(results[1], new TreeSet<Ride>());
        }
        // add ride to corresponding tree
        ridesMap.get(results[1]).add(new Ride(results[1], results[0], time, date, numSeats, getCheckBoxResultsArray(), email));
        //show success toast

        //return to home screen
    }

    private String[] getSpinnerResultsArray() {
        //put the results from the spinners into an array
        String[] results = {fromSpinner.getSelectedItem().toString(), toSpinner.getSelectedItem().toString()};
        return results;
    }

    private boolean[] getCheckBoxResultsArray() {
        boolean[] results = {pets.isChecked(), luggage.isChecked(), smoking.isChecked(), food.isChecked(), money.isChecked()};
        return results;
    }

//    private ADate getDate() {
//        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        //String date = dateFormat.format(new ADate());
//        return new ADate(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
//    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Post Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

//    private String getTime()
//    {
//        return timePicker.getHour() + ";" + timePicker.getMinute();
//    }
}
