package edu.fau.oosd.group9.rentacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * The second page of the reservation wizard for selecting vehicle class.
 */
public class ReservTwoActivity extends AppCompatActivity {

    //flag for making sure the user selects an option
    private int OPTION_FLAG = 0;

    /**
     * On creation of the activity by the user, run this code. Maps the UI elements (view) to the
     * controller and initializes action listeners for those UI elements.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserv_two);

        final AppModel modelInstance = AppModel.getInstance();
        final Reservation lastReservation = modelInstance.getCurrentUser().getLastReservation();

        //Initialize vehicles
        final VehClass_Compact cv = new VehClass_Compact();
        final VehClass_MidSize ms = new VehClass_MidSize();
        final VehClass_Crossover co = new VehClass_Crossover();
        final VehClass_SUV suv = new VehClass_SUV();
        final VehClass_Truck truck = new VehClass_Truck();

        //listen for press of NEXT button and call attemptNext()
        Button nextButton = (Button) findViewById(R.id.reservtwo_next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptNext();
            }
        });

        //listen for the selection of compact radio button, then send data to model based off
        //  vehicle class
        RadioButton compactButton = (RadioButton) findViewById(R.id.radioButton1);
        compactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OPTION_FLAG = 1;
                if(modelInstance.isEmptyFromCarList())
                {
                    modelInstance.addToCarList(cv);
                }
                else {
                    modelInstance.removeFromCarList();
                    modelInstance.addToCarList(cv);
                }
                lastReservation.setReservedCar(cv);
            }
        });

        //listen for the selection of compact radio button, then send data to model based off
        //  vehicle class
        RadioButton midButton = (RadioButton) findViewById(R.id.radioButton2);
        midButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OPTION_FLAG = 1;
                if(modelInstance.isEmptyFromCarList())
                {
                    modelInstance.addToCarList(ms);
                }
                else {
                    modelInstance.removeFromCarList();
                    modelInstance.addToCarList(ms);
                }
                lastReservation.setReservedCar(ms);
            }
        });

        //listen for the selection of compact radio button, then send data to model based off
        //  vehicle class
        RadioButton crossButton = (RadioButton) findViewById(R.id.radioButton3);
        crossButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OPTION_FLAG = 1;
                if(modelInstance.isEmptyFromCarList())
                {
                    modelInstance.addToCarList(co);
                }
                else {
                    modelInstance.removeFromCarList();
                    modelInstance.addToCarList(co);
                }
                lastReservation.setReservedCar(co);
            }
        });

        //listen for the selection of compact radio button, then send data to model based off
        //  vehicle class
        RadioButton suvButton = (RadioButton) findViewById(R.id.radioButton4);
        suvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OPTION_FLAG = 1;
                if(modelInstance.isEmptyFromCarList())
                {
                    modelInstance.addToCarList(suv);
                }
                else {
                    modelInstance.removeFromCarList();
                    modelInstance.addToCarList(suv);
                }
                lastReservation.setReservedCar(suv);
            }
        });

        //listen for the selection of compact radio button, then send data to model based off
        //  vehicle class
        RadioButton truckButton = (RadioButton) findViewById(R.id.radioButton5);
        truckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OPTION_FLAG = 1;
                if(modelInstance.isEmptyFromCarList()) {
                    modelInstance.addToCarList(truck);
                }
                else {
                    modelInstance.removeFromCarList();
                    modelInstance.addToCarList(truck);
                }
                lastReservation.setReservedCar(truck);
            }
        });
    }

    /**
     * Attempts to go to the next activity. Checks to make sure user entered information in all
     * fields. If not, notify the user and don't go to the next activity.
     */
    private void attemptNext() {

        //if a selection hasn't been made, display error toast to user
        if (OPTION_FLAG == 0)
        {
            Toast.makeText(ReservTwoActivity.this,
                    "Please select a vehicle class", Toast.LENGTH_LONG).show();
        }
        else //if button is pressed, start the next reservation activity
        {
            Intent intent = new Intent(ReservTwoActivity.this, ReservThreeActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
