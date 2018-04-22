package edu.fau.oosd.group9.rentacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * The fifth page of the reservation wizard.
 */
public class ReservFiveActivity extends AppCompatActivity {

    //create UI references
    EditText userName;
    EditText userAddress;
    EditText userPhone;
    EditText userLicense;

    /**
     * On creation of the activity by the user, run this code. Maps the UI elements (view) to the
     * controller and initializes action listeners for UI elements.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserv_five);


        //map UI references to UI elements
        userName = findViewById(R.id.user_name);
        userAddress = findViewById(R.id.user_address);
        userPhone = findViewById(R.id.user_phone);
        userLicense = findViewById(R.id.user_license);

        //listen for press of BACK button and go to ReservFourActivity
        Button backButton = (Button) findViewById(R.id.reservfive_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if button is pressed, start the previous activity
                Intent intent = new Intent(ReservFiveActivity.this, ReservFourActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //listen for press of SUBMIT button and call attemptSubmit()
        Button submitButton = (Button) findViewById(R.id.reservfive_submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptSubmit();
            }
        });
    }

    /**
     * Attempts submit. Checks for errors (empty fields). If there are errors, they are presented
     * and no actual submit is made.
     */
    private void attemptSubmit() {

        //stores values at the time of submit attempt
        String name = userName.getText().toString();
        String address = userAddress.getText().toString();
        String phone = userPhone.getText().toString();
        String license = userLicense.getText().toString();

        //reset error flags
        boolean cancel = false;
        View focusView = null;

        //check for valid name
        if (TextUtils.isEmpty(name)) {
            userName.setError("This field is required");
            focusView = userName;
            cancel = true;
        }

        //check for valid address
        if (TextUtils.isEmpty(address)) {
            userAddress.setError("This field is required");
            focusView = userName;
            cancel = true;
        }

        //check for valid phone
        if (TextUtils.isEmpty(phone)) {
            userPhone.setError("This field is required");
            focusView = userName;
            cancel = true;
        }

        //check for valid license
        if (TextUtils.isEmpty(license)) {
            userLicense.setError("This field is required");
            focusView = userName;
            cancel = true;
        }

        if (cancel) {
            //if there's an error, don't attempt submit; focus on error
            focusView.requestFocus();
        } else {
            //if there is no error, save the data
            //TODO: save the user's entries

            //if successful, start the next activity
            Intent intent = new Intent(ReservFiveActivity.this, MainMenuActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
