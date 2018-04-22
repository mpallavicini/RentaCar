package edu.fau.oosd.group9.rentacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * The third page of the reservation wizard.
 */
public class ReservThreeActivity extends AppCompatActivity {

    /**
     * On creation of the activity by the user, run this code. Maps the UI elements (view) to the
     * controller and initializes action listeners for those UI elements.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final AppModel modelInstance = AppModel.getInstance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserv_three);

        //Initialize additional options
        final VehicleInsurance vi = new VehicleInsurance();
        final SatelliteRadio sr = new SatelliteRadio();
        final GPS gps = new GPS();


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
                if(vehicleBox.isChecked()){
                    modelInstance.addToOptionList(vi);
                    Toast.makeText(ReservThreeActivity.this,
                            modelInstance.getPriceFromOptionList("Vehicle Insurance"), Toast.LENGTH_LONG).show();

                }else{
                    if(modelInstance.isEmptyFromOptionList())
                    {
                        //do nothing empty
                    }
                    else {
                        modelInstance.removeFromOptionList(vi);
                    }
                }
            }
        });

        final CheckBox satelliteBox = (CheckBox) findViewById(R.id.checkBox2);
        satelliteBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(satelliteBox.isChecked()){
                    modelInstance.addToOptionList(sr);
                    Toast.makeText(ReservThreeActivity.this,
                            modelInstance.getPriceFromOptionList("Satellite Radio"), Toast.LENGTH_LONG).show();
                }else{
                    if(modelInstance.isEmptyFromOptionList())
                    {
                        //do nothing empty
                    }
                    else {
                        modelInstance.removeFromOptionList(sr);
                    }
                }
            }
        });

        final CheckBox gpsBox = (CheckBox) findViewById(R.id.checkBox3);
        gpsBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(gpsBox.isChecked()){
                    modelInstance.addToOptionList(gps);
                    Toast.makeText(ReservThreeActivity.this,
                            modelInstance.getPriceFromOptionList("GPS"), Toast.LENGTH_LONG).show();

                }else{
                    if(modelInstance.isEmptyFromOptionList())
                    {
                        //do nothing empty
                    }
                    else {
                        modelInstance.removeFromOptionList(gps);
                    }
                }
            }
        });












//        //listen for the selection of vehicleInsure radio button, then send data to model based off
//        //  vehicle option
//        RadioButton vehicleInsureButton = (RadioButton) findViewById(R.id.radioButton1);
//        vehicleInsureButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                Toast.makeText(ReservThreeActivity.this,
//                        vi.price, Toast.LENGTH_LONG).show();
//
//            }
//        });
//
//        //listen for the selection of satellite radio button, then send data to model based off
//        //  vehicle option
//        RadioButton satelliteButton = (RadioButton) findViewById(R.id.radioButton2);
//        satelliteButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Toast.makeText(ReservThreeActivity.this,
//                        sr.price, Toast.LENGTH_LONG).show();
//
//            }
//        });
//
//        //listen for the selection of gps radio button, then send data to model based off
//        //  vehicle option
//        RadioButton gpsButton = (RadioButton) findViewById(R.id.radioButton3);
//        gpsButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Toast.makeText(ReservThreeActivity.this,
//                        gps.price, Toast.LENGTH_LONG).show();
//
//            }
//        });



    }
}
