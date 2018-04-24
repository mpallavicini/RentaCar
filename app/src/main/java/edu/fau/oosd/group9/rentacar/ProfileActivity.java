package edu.fau.oosd.group9.rentacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * The view/edit profile activity.
 * @author Justin + Marco + Ohm
 */
public class ProfileActivity extends AppCompatActivity {

    //references to text fields that hold values to be updated from view later
    EditText userName;
    EditText userAddress;
    EditText userPhone;
    EditText userLicense;

    //get AppModel instance
    private final AppModel modelInstance = AppModel.getInstance();
    //get the current user
    private UserProfile currentUser = modelInstance.getCurrentUser();

    /**
     * On creation of the activity by the user, run this code. Maps the UI elements (view) to the
     * controller and initializes action listeners for UI elements.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //map UI references to UI elements
        userName = findViewById(R.id.edit_user_name);
        userAddress = findViewById(R.id.edit_user_address);
        userPhone = findViewById(R.id.edit_user_phone);
        userLicense = findViewById(R.id.edit_user_license);
        TextView textView = (TextView)findViewById(R.id.profile_email_view);

        //display user's email address
        textView.setText(modelInstance.getCurrentUser().getUserEmailAddress(), TextView.BufferType.EDITABLE);

        //display the user's name as long as it is not empty in the profile
        //listen for changes and store locally to submit later
        EditText editText = (EditText)userName;
        if(modelInstance.getNameFromUserProfile() == "")
        {
            userName = findViewById(R.id.edit_user_name);
        }
        else{
            editText.setText(modelInstance.getNameFromUserProfile(), TextView.BufferType.EDITABLE);
        }

        //display the user's address as long as it is not empty in the profile
        //listen for changes and store locally to submit later
        EditText editText2 = (EditText)userAddress;
        if(modelInstance.getAddressFromUserProfile() == "")
        {
            userAddress = findViewById(R.id.edit_user_address);
        }
        else{
            editText2.setText(modelInstance.getAddressFromUserProfile(), TextView.BufferType.EDITABLE);
        }

        //display the user's phone number as long as it is not empty in the profile
        //listen for changes and store locally to submit later
        EditText editText3 = (EditText)userPhone;
        if(modelInstance.getPhoneFromUserProfile() == "")
        {
            userPhone = findViewById(R.id.edit_user_phone);
        }
        else{
            editText3.setText(modelInstance.getPhoneFromUserProfile(), TextView.BufferType.EDITABLE);
        }

        //display the user's driver license number as long as it is not empty in the profile
        //listen for changes and store locally to submit later
        EditText editText4 = (EditText)userLicense;
        if(modelInstance.getDriverFromUserProfile() == "")
        {
            userLicense = findViewById(R.id.edit_user_license);
        }
        else{
            editText4.setText(modelInstance.getDriverFromUserProfile(), TextView.BufferType.EDITABLE);
        }

        //listen for press of CANCEL button and go back to Settings
        Button cancelButton = (Button) findViewById(R.id.profile_cancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if button is pressed, go to Settings activity
                Intent intent = new Intent(ProfileActivity.this, SettingsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //listen for press of SUBMIT button and call attemptSubmit()
        Button submitButton = (Button) findViewById(R.id.profile_submit);
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
            currentUser.setUserName(name);
            currentUser.setUserAddress(address);
            currentUser.setUserPhone(phone);
            currentUser.setUserDL(license);

            //if successful, start the next activity
            Intent intent = new Intent(ProfileActivity.this, SettingsActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
