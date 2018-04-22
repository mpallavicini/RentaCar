package edu.fau.oosd.group9.rentacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * The fourth page of the reservation wizard.
 */
public class ReservFourActivity extends AppCompatActivity {

    //references to text fields that holds values updated by the controller upon onCreate()
    TextView pickupDate;
    TextView pickupTime;
    TextView pickupLocation;
    TextView dropoffDate;
    TextView dropoffTime;
    TextView dropoffLocation;
    TextView vehicleClass;
    TextView optionOne;
    TextView optionTwo;
    TextView optionThree;
    TextView finalRate;
    TextView finalCost;

    /**
     * On creation of the activity by the user, run this code. Maps the UI elements (view) to the
     * controller and initializes action listeners for those UI elements.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserv_four);

        //map the UI elements to the local reference variables
        pickupDate = findViewById(R.id.pickup_date_summary);
        pickupTime = findViewById(R.id.pickup_time_summary);
        pickupLocation = findViewById(R.id.pickup_location_summary);
        dropoffDate = findViewById(R.id.dropoff_date_summary);
        dropoffTime = findViewById(R.id.dropoff_time_summary);
        dropoffLocation = findViewById(R.id.dropoff_location_summary);
        vehicleClass = findViewById(R.id.class_summary);
        optionOne = findViewById(R.id.options1_summary);
        optionTwo = findViewById(R.id.options2_summary);
        optionThree = findViewById(R.id.options3_summary);
        finalRate = findViewById(R.id.rate_summary);
        finalCost = findViewById(R.id.cost_summary);

        //display summary to the user, pulling data from the model and pushing to the view
        //TODO: get values from model instead of using string placeholders
        pickupDate.setText("Date PH");
        pickupTime.setText("Time PH");
        pickupLocation.setText("Location PH");
        dropoffDate.setText("Date PH");
        dropoffTime.setText("Time PH");
        dropoffLocation.setText("Location PH");
        vehicleClass.setText("Class PH");
        optionOne.setText("Option PH");
        optionTwo.setText("Option PH");
        optionThree.setText("Option PH");
        finalRate.setText("Rate PH");
        finalCost.setText("Cost PH");


        //listen for press of BACK button and go to ReservThreeActivity
        Button backButton = (Button) findViewById(R.id.reservfour_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if button is pressed, start the reservation activity
                Intent intent = new Intent(ReservFourActivity.this, ReservThreeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //listen for press of NEXT button and go to ReservFiveActivity
        Button nextButton = (Button) findViewById(R.id.reservfour_next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if button is pressed, start the reservation activity
                Intent intent = new Intent(ReservFourActivity.this, ReservFiveActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
