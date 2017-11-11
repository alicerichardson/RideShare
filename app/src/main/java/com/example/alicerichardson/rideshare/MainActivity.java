package com.example.alicerichardson.rideshare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by alicerichardson on 11/11/17.
 */

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button hostingButton = (Button) findViewById(R.id.hosting_button);
        Button lookingButton = (Button) findViewById(R.id.looking_button);


        hostingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                post();
                           }
        });

        lookingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                request();
                            }
        });
    }

    public void post()
    {
        startActivity(new Intent(this, PostActivity.class));
    }

    public void request()
    {
        startActivity(new Intent(this, RequestActivity.class));
    }
}
