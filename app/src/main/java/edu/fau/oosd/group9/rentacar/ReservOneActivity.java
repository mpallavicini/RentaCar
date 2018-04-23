package edu.fau.oosd.group9.rentacar;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * The first page of the reservation wizard for entering logistics.
 */
public class ReservOneActivity extends AppCompatActivity
        implements DatePickerFragment.DatePickerFragmentListener,
        TimePickerFragment.TimePickerFragmentListener, AdapterView.OnItemSelectedListener {

    //flags for tracking which PICK DATE or PICK TIME buttons are pressed
    private int DATE_DIALOG = 0;
    private int TIME_DIALOG = 0;

    //flag for making sure all options are selected by user
    private int PL_FLAG = 0;
    private int DL_FLAG = 0;
    private int PD_FLAG = 0;
    private int DD_FLAG = 0;
    private int PT_FLAG = 0;
    private int DT_FLAG = 0;

    //references to our two spinner menus
    private Spinner pickupLocation;
    private Spinner dropoffLocation;

    //references to our four PICK DATE or PICK TIME buttons
    private Button pickupDateButton;
    private Button pickupTimeButton;
    private Button dropoffDateButton;
    private Button dropoffTimeButton;

    //references to text fields that hold values updated by timePicker() and datePicker()
    private TextView pickupDate;
    private TextView pickupTime;
    private TextView dropoffDate;
    private TextView dropoffTime;

    //create fragment manager for the date and time picker UI elements
    private FragmentManager fm = getFragmentManager();

    //new reservation
    private Reservation newReservation = new Reservation();
    //get AppModel instance
    private final AppModel modelInstance = AppModel.getInstance();

    /**
     * On creation of the activity by the user, run this code. Maps the UI elements (view) to the
     * controller and initializes action listeners for UI elements.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserv_one);

        //map the spinner menus to the UI elements
        pickupLocation = findViewById(R.id.pickup_location_spinner);
        dropoffLocation = findViewById(R.id.dropoff_location_spinner);

        //map the buttons to the UI elements
        pickupDateButton = findViewById(R.id.pickup_date_button);
        pickupTimeButton = findViewById(R.id.pickup_time_button);
        dropoffDateButton = findViewById(R.id.dropoff_date_button);
        dropoffTimeButton = findViewById(R.id.dropoff_time_button);

        //map the text fields to the UI elements
        pickupDate = findViewById(R.id.pickup_date_view);
        pickupTime = findViewById(R.id.pickup_time_view);
        dropoffDate = findViewById(R.id.dropoff_date_view);
        dropoffTime = findViewById(R.id.dropoff_time_view);

        //listen for tap of a spinner menu option being selected and call onItemSelected()
        pickupLocation.setOnItemSelectedListener(this);
        dropoffLocation.setOnItemSelectedListener(this);

        //listen for press of Pickup Date PICK DATE button and call datePicker()
        pickupDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DATE_DIALOG = 1;
                datePicker();
            }
        });

        //listen for press Pickup Time PICK TIME button and call timePicker()
        pickupTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIME_DIALOG = 1;
                timePicker();
            }
        });

        //listen for press of the Dropoff Date PICK DATE button and call datePicker()
        dropoffDateButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                DATE_DIALOG = 2;
                datePicker();
            }
        }));

        //listen for press of the Dropoff Time PICK TIME button and call timePicker()
        dropoffTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIME_DIALOG = 2;
                timePicker();
            }
        });

        //listen for press of NEXT button and call attemptNext()
        Button nextButton = (Button) findViewById(R.id.reservone_next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptNext();
            }
        });

    }

    /**
     * If called on by its listener, store the user's selected entry from the spinner.
     * @param parent
     * @param v
     * @param position
     * @param id
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (parent.getId()) {
            case R.id.pickup_location_spinner: //store the user's selection for pickup location
                switch (position) {
                    case 0: //no selection
                        PL_FLAG = 0;
                        break;
                    case 1: //Miami, FL
                        newReservation.setPickUpLocation("Miami, FL");
                        PL_FLAG = 1;
                        break;
                    case 2: //Boca Raton, FL
                        newReservation.setPickUpLocation("Boca Raton, FL");
                        PL_FLAG = 1;
                        break;
                    case 3: //Atlanta, GA
                        newReservation.setPickUpLocation("Atlanta, GA");
                        PL_FLAG = 1;
                        break;
                }
                break;
            case R.id.dropoff_location_spinner: //store the user's selection for dropoff location
                switch (position) {
                    case 0: //no selection
                        DL_FLAG = 0;
                        break;
                    case 1: //Miami, FL
                        newReservation.setDropOffLocation("Miami, FL");
                        DL_FLAG = 1;
                        break;
                    case 2: //Boca Raton, FL
                        newReservation.setDropOffLocation("Boca Raton, FL");
                        DL_FLAG = 1;
                        break;
                    case 3: //Atlanta, GA
                        newReservation.setDropOffLocation("Atlanta, GA");
                        DL_FLAG = 1;
                        break;
                }
                break;
        }
    }

    /**
     * If nothing is selected by the user in the spinner menu, do nothing
     * @param parent
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //do nothing
    }

    /**
     * Displays the date picker when called on by a listener
     */
    public void datePicker() {
        DatePickerFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.show(fm, "Pick Date");
    }

    /**
     * Displays the time picker when called on by a listener
     */
    public void timePicker() {
        TimePickerFragment timePickerFragment = new TimePickerFragment();
        timePickerFragment.show(fm, "Pick Time");
    }

    /**
     * When a user selects a date, the date picker calls this method. This method stores the user's
     * input in the reservation model and also updates the view with the selected value.
     * @param year
     * @param month
     * @param day
     */
    @Override
    public void onDateSet(int year, int month, int day) {
        //convert year, month, day to a date object
        Calendar cal = new GregorianCalendar(year, month, day);
        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);

        if (DATE_DIALOG == 1) //if result is coming from first date picker, process pickup date
        {
            PD_FLAG = 1;
            pickupDate.setText(dateFormat.format(cal.getTime()));
            newReservation.setPickUpDate(dateFormat.format(cal.getTime()));
        }
        else if (DATE_DIALOG == 2) //if result is coming from second date picker, process dropoff date
        {
            DD_FLAG = 1;
            dropoffDate.setText(dateFormat.format(cal.getTime()));
            newReservation.setDropOffDate(dateFormat.format(cal.getTime()));
        }
    }

    /**
     * When a user selects a time, the time picker calls this method to return the result.
     * This method stores the user's input in the reservation model and also updates the view
     * with the selected value.
     * @param hour
     * @param minute
     */
    @Override
    public void onTimeSet(int hour, int minute) {
        //convert the hour and minute to a string in 24 hour format
        String timeString = hour +":"+ String.format(Locale.US, "%02d", minute);

        if (TIME_DIALOG == 1) //if result is coming from first time picker, process pickup time
        {
            PT_FLAG = 1;
            pickupTime.setText(timeString);
            newReservation.setPickUpTime(timeString);
        }
        else if (TIME_DIALOG == 2) //if result is coming from second time picker, process dropoff time
        {
            DT_FLAG = 1;
            dropoffTime.setText(timeString);
            newReservation.setDropOffTime(timeString);
        }
    }

    /**
     * Attempts to go to the next activity. Checks to make sure user entered information in all
     * fields. If not, notify the user and don't go to the next activity.
     */
    private void attemptNext() {

        //if a selection hasn't been made, display error toast to user
        if (PL_FLAG == 0)
        {
            Toast.makeText(ReservOneActivity.this,
                    "Please select a pickup location.", Toast.LENGTH_LONG).show();
        }
        else if (DL_FLAG == 0)
        {
            Toast.makeText(ReservOneActivity.this,
                    "Please select a dropoff location.", Toast.LENGTH_LONG).show();
        }
        else if (PD_FLAG == 0)
        {
            Toast.makeText(ReservOneActivity.this,
                    "Please select a pickup date.", Toast.LENGTH_LONG).show();
        }
        else if (DD_FLAG == 0)
        {
            Toast.makeText(ReservOneActivity.this,
                    "Please select a dropoff date.", Toast.LENGTH_LONG).show();
        }
        else if (PT_FLAG == 0)
        {
            Toast.makeText(ReservOneActivity.this,
                    "Please select a pickup time.", Toast.LENGTH_LONG).show();
        }
        else if (DT_FLAG == 0)
        {
            Toast.makeText(ReservOneActivity.this,
                    "Please select a dropoff time.", Toast.LENGTH_LONG).show();
        }
        else //if all selections have been made, save data and go to next activity
        {
            //upload reservation data to model
            modelInstance.addReservationForCurrentUser(newReservation);

            //if button is pressed, start the next reservation activity
            Intent intent = new Intent(ReservOneActivity.this, ReservTwoActivity.class);
            startActivity(intent);
            finish();
        }
    }
}