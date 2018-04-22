package edu.fau.oosd.group9.rentacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * The main menu.
 */
public class MainMenuActivity extends AppCompatActivity {

    TextView currentUserText;

    /**
     * On creation of the activity by the user, run this code. Maps the UI elements (view) to the
     * controller and initializes action listeners for UI elements.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        currentUserText = findViewById(R.id.current_user);

        //listen for press of Make a Reservation button and go to ReservOneActivity
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

        //listen for press of Log Out button and go to LoginActivity
        Button logOutButton = (Button) findViewById(R.id.log_out_button);
        logOutButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //if button is pressed, start the reservation activity
                Intent intent = new Intent(MainMenuActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String currentUser = extras.getString("currentUser");
            currentUserText.setText(currentUser);
        }


    }
}