package com.example.chapter3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // get the UI objects from the res folder, layout folder, activity_main xml file
        final EditText tickets=(EditText)findViewById(R.id.txtTickets);
        final Spinner group = (Spinner)findViewById(R.id.txtGroup);
        Button cost = (Button)findViewById(R.id.btnCost);

        // when the user click or tap the button on the touchscreen
        // listen to the user actions
        // get the UI object from the activity_main xml file (TextView) because we want to display
        // the calculation result here
        // go to edit text object to get the user input and convert the data from string to int
        // using parseInt() method and calculate the total cost
        // create decimal format object called currency to display the result in currency and 2 decimal places
        // go to the drop down list or spinner object and get the band name choose by the user
        // display the calculations result in currency format and the band name

        cost.setOnClickListener(new View.OnClickListener() {
            final TextView result = ((TextView)findViewById(R.id.txtResult));
            @Override
            public void onClick(View v) {
                numberOfTickets = Integer.parseInt(tickets.getText( ).toString( ));
                totalCost = costPerTicket * numberOfTickets;
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                groupChoice = group.getSelectedItem( ).toString( );
                result.setText("Cost for " + groupChoice + " is " + currency.format(totalCost));
            }
        });
    }
}