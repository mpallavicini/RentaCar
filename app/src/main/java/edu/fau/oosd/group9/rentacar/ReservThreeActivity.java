package edu.fau.oosd.group9.rentacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

/**
 * The third page of the reservation wizard.
 */
public class ReservThreeActivity extends AppCompatActivity {

    /**
     * On creation of the activity by the user, run this code. Maps the UI elements (view) to the
     * controller and initializes action listeners for those UI elements.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final AppModel modelInstance = AppModel.getInstance();
        final Reservation lastReservation = modelInstance.getCurrentUser().getLastReservation();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserv_three);

        //Initialize additional options
        final AddOptions_VehInsurance vi = new AddOptions_VehInsurance();
        final AddOptions_SatelliteRadio sr = new AddOptions_SatelliteRadio();
        final AddOptions_GPS gps = new AddOptions_GPS();


        //listen for press of BACK button and go to ReservTwoActivity
        Button backButton = (Button) findViewById(R.id.reservthree_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if button is pressed, start the reservation activity
                Intent intent = new Intent(ReservThreeActivity.this, ReservTwoActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //listen for press of NEXT button and go to ReservFourActivity
        Button nextButton = (Button) findViewById(R.id.reservthree_next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if button is pressed, start the reservation activity
                Intent intent = new Intent(ReservThreeActivity.this, ReservFourActivity.class);
                startActivity(intent);
                finish();
            }
        });


        final CheckBox vehicleBox = (CheckBox) findViewById(R.id.checkBox);
        vehicleBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (vehicleBox.isChecked()) {
                    modelInstance.addToOptionsList(vi);
                    lastReservation.addAdditionalOptions(vi);
                } else {
                    if (modelInstance.isEmptyFromOptionList()) {
                        //do nothing empty
                    } else {
                        modelInstance.removeFromOptionsList(vi);
                    }
                }
            }
        });

        final CheckBox satelliteBox = (CheckBox) findViewById(R.id.checkBox2);
        satelliteBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (satelliteBox.isChecked()) {
                    modelInstance.addToOptionsList(sr);
                    lastReservation.addAdditionalOptions(sr);
                } else {
                    if (modelInstance.isEmptyFromOptionList()) {
                        //do nothing empty
                    } else {
                        modelInstance.removeFromOptionsList(sr);
                    }
                }
            }
        });

        final CheckBox gpsBox = (CheckBox) findViewById(R.id.checkBox3);
        gpsBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (gpsBox.isChecked()) {
                    modelInstance.addToOptionsList(gps);
                    lastReservation.addAdditionalOptions(gps);
                } else {
                    if (modelInstance.isEmptyFromOptionList()) {
                        //do nothing empty
                    } else {
                        modelInstance.removeFromOptionsList(gps);
                    }
                }
            }
        });
    }
}