package edu.fau.oosd.group9.rentacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Activity for Exisiting Reservations page.
 * @author Ohm
 */
public class ManageReservationsActivity extends AppCompatActivity {

    //get AppModel instance
    private final AppModel modelInstance = AppModel.getInstance();
    //get current logged in user
    private final UserProfile currentUser = modelInstance.getCurrentUser();

    /**
     * On creation of the activity by the user, run this code. Maps the UI elements (view) to the
     * controller and initializes action listeners for those UI elements.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservations);

        RadioGroup radioGrp = findViewById(R.id.radiogroup);
        final ArrayList<Reservation> existingReservations = currentUser.getUserReservations();
        addRadioButtons(existingReservations, radioGrp);

        //listen for press of Edit Reservation button
        Button viewReservationButton = (Button) findViewById(R.id.view_reservation_button);
        viewReservationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if button is pressed, start the view reservation activity
                //only if at least one reservation exists for the current user
                //else notify user and do not proceed further
                if(existingReservations.isEmpty()) {
                    Toast.makeText(ManageReservationsActivity.this,
                            "No Reservations Exist for the Current User", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(ManageReservationsActivity.this, ViewReservationActivity.class);
                    Bundle b = new Bundle();
                    b.putString("SELECTED_RESERVATION", Integer.toString(getRadioBtnSelected()));
                    intent.putExtra("activityBdl", b);
                    startActivity(intent);
                    finish();
                }
            }
        });

        //listen for press of Main Menu button
        Button mainMenuButton = (Button) findViewById(R.id.main_menu_button2);
        mainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if button is pressed, start the Main Menu activity
                Intent intent = new Intent(ManageReservationsActivity.this, MainMenuActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    /**
     * To add Radio Buttons dynamically to the View depending on number of existing reservations
     * in the currentUser's profile
     * @param listOfReservations list of currentUser's reservations
     * @param radioGroup reference to RadiGroup view in which Radio Buttons to be contained
     */
    public void addRadioButtons(ArrayList<Reservation> listOfReservations, RadioGroup radioGroup) {

        //for (int row = 0; row < 1; row++) {
        //RadioGroup ll = new RadioGroup(this);
        radioGroup.setOrientation(LinearLayout.VERTICAL);

        for (Reservation aReservation : listOfReservations) {
            RadioButton radio_btn = new RadioButton(this);
            radio_btn.setId((listOfReservations.indexOf(aReservation)));
            String textToDisplay = aReservation.getPickUpDate() + " @ "
                    + aReservation.getPickUpTime() + " from " + aReservation.getPickUpLocation();
            radio_btn.setText(textToDisplay);
            radio_btn.setTextSize(18);
            radioGroup.addView(radio_btn);
        }
        //((ViewGroup) findViewById(R.id.radiogroup)).addView(ll);
        //}
    }

    /**
     * Returns the selected Radio Button representing the particular reservation
     * User desires to see
     * @return ID of the Radio Button selected
     */
    public int getRadioBtnSelected() {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        int selectedRadioBtn = radioGroup.getCheckedRadioButtonId();
        return selectedRadioBtn;
    }
}
