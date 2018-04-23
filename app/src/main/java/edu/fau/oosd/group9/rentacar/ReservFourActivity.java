package edu.fau.oosd.group9.rentacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The fourth page of the reservation wizard.
 */
public class ReservFourActivity extends AppCompatActivity {

    //references to text fields that holds values updated by the controller upon onCreate()
    private TextView pickupDate;
    private TextView pickupTime;
    private TextView pickupLocation;
    private TextView dropoffDate;
    private TextView dropoffTime;
    private TextView dropoffLocation;
    private TextView vehicleClass;
    private TextView optionOne;
    private TextView optionTwo;
    private TextView optionThree;
    private TextView finalRate;
    private TextView finalCost;

    /**
     * On creation of the activity by the user, run this code. Maps the UI elements (view) to the
     * controller and initializes action listeners for those UI elements.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserv_four);

        //get AppModel instance
        final AppModel modelInstance = AppModel.getInstance();
        //get the most recent reservation
        Reservation lastReservation = modelInstance.getCurrentUser().getLastReservation();

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
        pickupDate.setText(lastReservation.getPickUpDate());
        pickupTime.setText(lastReservation.getPickUpTime());
        pickupLocation.setText(lastReservation.getPickUpLocation());
        dropoffDate.setText(lastReservation.getDropOffDate());
        dropoffTime.setText(lastReservation.getDropOffTime());
        dropoffLocation.setText(lastReservation.getDropOffLocation());
        vehicleClass.setText(lastReservation.getReservedCar().getVehicleClass());

        int totalDailyRate = lastReservation.getReservedCar().getPrice();
        for(AdditionalOptionsAbstract option : lastReservation.getSelectedOptions()) {
            totalDailyRate += option.getPrice();
            if(option.getOption() == "Vehicle Insurance") { optionOne.setText("✓ Vehicle Insurance"); }
            else { optionOne.setText("✗ Vehicle Insurance"); }
            if(option.getOption() == "Satellite Radio") { optionTwo.setText("✓ Satellite Radio"); }
            else { optionTwo.setText("✗ Satellite Radio"); }
            if(option.getOption() == "GPS") { optionThree.setText("✓ GPS"); }
            else { optionThree.setText("✗ GPS"); }
        }

        finalRate.setText(String.valueOf(totalDailyRate));

        SimpleDateFormat format = new SimpleDateFormat("MMM d, yyyy");
        Date fromDate = null;
        Date toDate = null;
        try {
            fromDate = format.parse(lastReservation.getPickUpDate());
            toDate = format.parse(lastReservation.getDropOffDate());
        }  catch (ParseException e) {
            e.printStackTrace();
        }
        int rentalDays = (int)( (toDate.getTime() - fromDate.getTime()) / (1000 * 60 * 60 * 24));
        int finalReservationCost = totalDailyRate * rentalDays;
        finalCost.setText(String.valueOf(finalReservationCost));


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
