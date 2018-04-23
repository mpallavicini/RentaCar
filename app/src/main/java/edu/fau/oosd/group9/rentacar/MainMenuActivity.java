package edu.fau.oosd.group9.rentacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainMenuActivity extends AppCompatActivity {

    //reference to current user textview
    private TextView currentUserView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        //map UI element to UI reference and display current logged in user
        currentUserView = findViewById(R.id.current_user);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            currentUserView.setText(extras.getString("currentUser"));

        }

        //listen for press of Make a Reservation button
        Button makeReservationButton = (Button) findViewById(R.id.make_a_reservation_button);
        makeReservationButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //if button is pressed, start the reservation activity
                Intent intent = new Intent(MainMenuActivity.this, ReservOneActivity.class);
                startActivity(intent);
                finish();
            }
        });

/*        //listen for press of Settings button
        Button existingReservationsButton = (Button) findViewById(R.id.existing_reservations_button);
        existingReservationsButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //if button is pressed, start the reservation activity
                Intent intent = new Intent(MainMenuActivity.this, ExistingReservationsActivity.class);
                startActivity(intent);
                finish();
            }
        });*/

        //listen for press of Settings button
        Button settingsButton = (Button) findViewById(R.id.settings_button);
        settingsButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //if button is pressed, start the reservation activity
                Intent intent = new Intent(MainMenuActivity.this, SettingsActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}