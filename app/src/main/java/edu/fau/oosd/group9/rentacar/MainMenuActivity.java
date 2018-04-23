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

    //get AppModel instance
    private final AppModel modelInstance = AppModel.getInstance();

    /**
     * On creation of the activity by the user, run this code. Maps the UI elements (view) to the
     * controller and initializes action listeners for UI elements.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        //map UI element to UI reference and display current logged in user
        TextView currentUserView = findViewById(R.id.current_user);
        currentUserView.setText(modelInstance.getCurrentUser().getUserEmailAddress());

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

        //listen for press of Existing Reservations button
        Button existingReservationsButton = (Button) findViewById(R.id.existing_reservations_button);
        existingReservationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if button is pressed, start the existing reservations activity
                Intent intent = new Intent(MainMenuActivity.this, ManageReservationsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //listen for press of Settings button
        Button settingsButton = (Button) findViewById(R.id.settings_button);
        settingsButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //if button is pressed, start the settings activity
                Intent intent = new Intent(MainMenuActivity.this, SettingsActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}