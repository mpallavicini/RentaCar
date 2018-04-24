package edu.fau.oosd.group9.rentacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Activity for Viewing a Reservation's Summary
 * @author Ohm
 */
public class ViewReservationActivity extends AppCompatActivity {

    //references to text fields that hold values updated by timePicker() and datePicker()
    private TextView pickupLocation;
    private TextView dropoffLocation;
    private TextView pickupDate;
    private TextView pickupTime;
    private TextView dropoffDate;
    private TextView dropoffTime;
    private TextView vehicleClass;
    private TextView additionalOptions;
    private TextView dailyRate;
    private TextView reservationCost;

    //get AppModel instance
    private final AppModel modelInstance = AppModel.getInstance();
    //get current logged in user
    private final UserProfile currentUser = modelInstance.getCurrentUser();
    private ArrayList<Reservation> existingReservations = currentUser.getUserReservations();
    private Reservation reservationToView;

    /**
     * On creation of the activity by the user, run this code. Maps the UI elements (view) to the
     * controller and initializes action listeners for those UI elements.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_reservation);

        //map the text fields to the UI elements
        pickupLocation = findViewById(R.id.view_reserv_pickup_loc);
        dropoffLocation = findViewById(R.id.view_reserv_dropoff_loc);
        pickupDate = findViewById(R.id.view_reserv_pickup_date);
        pickupTime = findViewById(R.id.view_reserv_pickup_time);
        dropoffDate = findViewById(R.id.view_reserv_dropoff_date);
        dropoffTime = findViewById(R.id.view_reserv_dropoff_time);
        vehicleClass = findViewById(R.id.view_reserv_vehicle_class);
        additionalOptions = findViewById(R.id.view_reserv_add_options);
        dailyRate = findViewById(R.id.view_reserv_daily_rate);
        reservationCost = findViewById(R.id.view_reserv_total_cost);

        Intent i = getIntent();
        Bundle b = i.getBundleExtra("activityBdl");
        String reserveIDToEdit = b.getString("SELECTED_RESERVATION");
        final Integer reservationIx = Integer.parseInt(reserveIDToEdit);

        loadSelectedReservation(reservationIx);

        //listen for press of CANCEL button and go back to Settings
        Button backButton = (Button) findViewById(R.id.view_reserv_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if button is pressed, go to Settings activity
                Intent intent = new Intent(ViewReservationActivity.this, ManageReservationsActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    /**
     * Loads all data of the selected reservations into all the UI elements of the View
     * @param reservationIndex index of the reservation selected by the user
     */
    private void loadSelectedReservation(int reservationIndex) {

        reservationToView = existingReservations.get(reservationIndex);

        //get all details of the selected reservation and display it
        //on the corresponding TextViews
        pickupDate.setText(reservationToView.getPickUpDate());
        pickupTime.setText(reservationToView.getPickUpTime());
        pickupLocation.setText(reservationToView.getPickUpLocation());
        dropoffDate.setText(reservationToView.getDropOffDate());
        dropoffTime.setText(reservationToView.getDropOffTime());
        dropoffLocation.setText(reservationToView.getDropOffLocation());
        vehicleClass.setText(reservationToView.getReservedCar().getVehicleClass());
        String additionalOptionsString = "";
        for(AdditionalOptionsAbstract option : reservationToView.getSelectedOptions()) {
            additionalOptionsString += "✓ " + option.getOption() + "\n";
        }
        additionalOptions.setText(additionalOptionsString);
        dailyRate.setText(String.valueOf(reservationToView.getFinalDailyRate()));
        reservationCost.setText(String.valueOf(reservationToView.getFinalReservationBill()));
    }
}