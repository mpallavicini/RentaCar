package edu.fau.oosd.group9.rentacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    EditText userName;
    EditText userAddress;
    EditText userPhone;
    EditText userLicense;

    //get AppModel instance
    private final AppModel modelInstance = AppModel.getInstance();
    //get the current user
    private UserProfile currentUser = modelInstance.getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //map UI references to UI elements
        userName = findViewById(R.id.edit_user_name);
        userAddress = findViewById(R.id.edit_user_address);
        userPhone = findViewById(R.id.edit_user_phone);
        userLicense = findViewById(R.id.edit_user_license);

        TextView textView = (TextView)findViewById(R.id.textView23);
        textView.setText(modelInstance.getCurrentUser().getUserEmailAddress(), TextView.BufferType.EDITABLE);

        EditText editText = (EditText)findViewById(R.id.edit_user_name);
        if(modelInstance.getNameFromUserProfile() == "")
        {
            //editText.setText("Name", TextView.BufferType.EDITABLE);
            userName = findViewById(R.id.edit_user_name);
        }
        else{
            editText.setText(modelInstance.getNameFromUserProfile(), TextView.BufferType.EDITABLE);
        }

        EditText editText2 = (EditText)findViewById(R.id.edit_user_address);
        if(modelInstance.getAddressFromUserProfile() == "")
        {
            //editText2.setText("Address", TextView.BufferType.EDITABLE);
            userAddress = findViewById(R.id.edit_user_address);
        }
        else{
            editText2.setText(modelInstance.getAddressFromUserProfile(), TextView.BufferType.EDITABLE);
        }


        EditText editText3 = (EditText)findViewById(R.id.edit_user_phone);
        if(modelInstance.getPhoneFromUserProfile() == "")
        {
            //editText3.setText("Phone", TextView.BufferType.EDITABLE);
            userPhone = findViewById(R.id.edit_user_phone);
        }
        else{
            editText3.setText(modelInstance.getPhoneFromUserProfile(), TextView.BufferType.EDITABLE);
        }

        EditText editText4 = (EditText)findViewById(R.id.edit_user_license);
        if(modelInstance.getDriverFromUserProfile() == "")
        {
            //editText4.setText("Driver", TextView.BufferType.EDITABLE);
            userLicense = findViewById(R.id.edit_user_license);
        }
        else{
            editText4.setText(modelInstance.getDriverFromUserProfile(), TextView.BufferType.EDITABLE);
        }

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
