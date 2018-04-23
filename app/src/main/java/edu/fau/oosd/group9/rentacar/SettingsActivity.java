package edu.fau.oosd.group9.rentacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * A simple Settings menu with buttons.
 */
public class SettingsActivity extends AppCompatActivity {

    /**
     * On creation of the activity by the user, run this code. Initializes action listeners
     * for button UI elements from the view.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //listen for press of Log Out button
        Button logOutButton = (Button) findViewById(R.id.log_out_button);
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if button is pressed, start the login
                Intent intent = new Intent(SettingsActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //listen for press of View/Edit Profile button
        Button profileButton = (Button) findViewById(R.id.profile_button);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if button is pressed, start the profile activity
                Intent intent = new Intent(SettingsActivity.this, ProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //listen for press of Change Password button
        Button passwordButton = (Button) findViewById(R.id.change_password_button);
        passwordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if button is pressed, start the profile activity
                Intent intent = new Intent(SettingsActivity.this, PasswordActivity.class);
                startActivity(intent);
                finish();
            }
        });


        //listen for press of Main Menu button
        Button mainMenuButton = (Button) findViewById(R.id.main_menu_button);
        mainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if button is pressed, start the reservation activity
                Intent intent = new Intent(SettingsActivity.this, MainMenuActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
