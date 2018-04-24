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
 * The fourth page of the reservation wizard for displaying reservation summary.
 * @author Marco + Ohm
 */
public class ReservFourActivity extends AppCompatActivity {

    //get AppModel instance
    private final AppModel modelInstance = AppModel.getInstance();
    //get the most recent reservation
    private Reservation lastReservation = modelInstance.getCurrentUser().getLastReservation();

    /**
     * On creation of the activity by the user, run this code. Maps the UI elements (view) to the
     * controller and initializes action listeners for those UI elements.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserv_four);

        //map the UI elements to local reference variables
        TextView pickupDate = findViewById(R.id.pickup_date_summary);
        TextView pickupTime = findViewById(R.id.pickup_time_summary);
        TextView pickupLocation = findViewById(R.id.pickup_location_summary);
        TextView dropoffDate = findViewById(R.id.dropoff_date_summary);
        TextView dropoffTime = findViewById(R.id.dropoff_time_summary);
        TextView dropoffLocation = findViewById(R.id.dropoff_location_summary);
        TextView vehicleClass = findViewById(R.id.class_summary);
        TextView optionOne = findViewById(R.id.options1_summary);
        TextView finalRate = findViewById(R.id.rate_summary);
        TextView finalCost = findViewById(R.id.cost_summary);

        //display summary to the user, pulling data from the model and pushing to the view
        pickupDate.setText(lastReservation.getPickUpDate());
        pickupTime.setText(lastReservation.getPickUpTime());
        pickupLocation.setText(lastReservation.getPickUpLocation());
        dropoffDate.setText(lastReservation.getDropOffDate());
        dropoffTime.setText(lastReservation.getDropOffTime());
        dropoffLocation.setText(lastReservation.getDropOffLocation());
        vehicleClass.setText(lastReservation.getReservedCar().getVehicleClass());

        int totalDailyRate = lastReservation.getReservedCar().getPrice();

        //display additional options
        String additionalOptions = "";
        for(AdditionalOptionsAbstract option : lastReservation.getSelectedOptions()) {
            totalDailyRate += option.getPrice();
            additionalOptions += "✓ " + option.getOption() + "\n";
        }
        optionOne.setText(additionalOptions);

        //display daily rate and save it to the reservation
        finalRate.setText(String.valueOf(totalDailyRate));
        lastReservation.setFinalDailyRate(totalDailyRate);

        //format and dropoff dates for calculations coming up next
        SimpleDateFormat format = new SimpleDateFormat("MMM d, yyyy");
        Date fromDate = null;
        Date toDate = null;
        try {
            fromDate = format.parse(lastReservation.getPickUpDate());
            toDate = format.parse(lastReservation.getDropOffDate());
        }  catch (ParseException e) {
            e.printStackTrace();
        }

        //use date information from previous block to calculate total cost, display it to user
        //and save it to the reservation
        int rentalDays = (int)( (toDate.getTime() - fromDate.getTime()) / (1000 * 60 * 60 * 24));
        int finalReservationCost = totalDailyRate * rentalDays;
        finalCost.setText(String.valueOf(finalReservationCost));
        lastReservation.setFinalReservationBill(finalReservationCost);

        //listen for press of NEXT button and go to ReservFiveActivity
        Button nextButton = (Button) findViewById(R.id.reservfour_next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if button is pressed, start the next reservation activity
                Intent intent = new Intent(ReservFourActivity.this, ReservFiveActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
