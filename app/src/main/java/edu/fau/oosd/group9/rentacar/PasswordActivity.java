package edu.fau.oosd.group9.rentacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PasswordActivity extends AppCompatActivity {

    EditText userPassword;


    //get AppModel instance
    private final AppModel modelInstance = AppModel.getInstance();
    //get the current user
    private UserProfile currentUser = modelInstance.getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {







        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        //map UI references to UI element
        userPassword = findViewById(R.id.editText2);



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
        String password = userPassword.getText().toString();


        //reset error flags
        boolean cancel = false;
        View focusView = null;

        //check for valid name
        if (TextUtils.isEmpty(password)) {
            userPassword.setError("This field is required");
            focusView = userPassword;
            cancel = true;
        }

        if (cancel) {
            //if there's an error, don't attempt submit; focus on error
            focusView.requestFocus();
        } else {
            //if there is no error, save the data
            currentUser.setUserPassword(password);

            //if successful, start the next activity
            Intent intent = new Intent(PasswordActivity.this, SettingsActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
