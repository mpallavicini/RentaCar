package edu.fau.oosd.group9.rentacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * The second page of the reservation wizard.
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

        final AppModel modelInstance = AppModel.getInstance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserv_two);

        //Initialize vehicles
        final CompactVehicle cv = new CompactVehicle();
        final MidSize ms = new MidSize();
        final Crossover co = new Crossover();
        final Suv suv = new Suv();
        final Truck truck = new Truck();


        //listen for press of BACK button and go to ReservOneActivity
        Button backButton = (Button) findViewById(R.id.reservtwo_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if button is pressed, start the reservation activity
                Intent intent = new Intent(ReservTwoActivity.this, ReservOneActivity.class);
                startActivity(intent);
                finish();
            }
        });

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
                else{
                    modelInstance.removeFromCarList();
                    modelInstance.addToCarList(cv);
                }
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
                else{
                    modelInstance.removeFromCarList();
                    modelInstance.addToCarList(ms);
                }
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
                else{
                    modelInstance.removeFromCarList();
                    modelInstance.addToCarList(co);
                }
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
                else{
                    modelInstance.removeFromCarList();
                    modelInstance.addToCarList(suv);
                }
            }
        });

        //listen for the selection of compact radio button, then send data to model based off
        //  vehicle class
        RadioButton truckButton = (RadioButton) findViewById(R.id.radioButton5);
        truckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OPTION_FLAG = 1;
                if(modelInstance.isEmptyFromCarList())
                {
                    modelInstance.addToCarList(truck);
                }
                else{
                    modelInstance.removeFromCarList();
                    modelInstance.addToCarList(truck);
                }
            }
        });
    }

    private void attemptNext() {

        if (OPTION_FLAG == 0)
        {
            Toast.makeText(ReservTwoActivity.this,
                    "Please select an option.", Toast.LENGTH_LONG).show();
        }
        else
        {
            //if button is pressed, start the reservation activity
            Intent intent = new Intent(ReservTwoActivity.this, ReservThreeActivity.class);
            startActivity(intent);
            finish();
        }


    }
}
