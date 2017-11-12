package com.example.alicerichardson.rideshare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Queue;

/**
 * Created by alicerichardson on 11/11/17.
 */

public class SelectionActivity extends AppCompatActivity{

    public Queue<Ride> results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        int results_length = results.size();
        for(int i = 0; i < results_length; i++) {
            Button email = new Button(this);
            email.setId(i);
            final int id = email.getId();
            email.setText("Send Email");
            email = ((Button) findViewById(id));
            email.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view)  {
                    Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                    String emailRecipient = results.poll().email;
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, emailRecipient);
                    //startActivity(Intent.createChooser(emailIntent, "Send your message in: "));
                }
            });
        }
    }
}
