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

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * The first page of the reservation wizard.
 */
public class ReservOneActivity extends AppCompatActivity
        implements DatePickerFragment.DatePickerFragmentListener,
        TimePickerFragment.TimePickerFragmentListener, AdapterView.OnItemSelectedListener {

    //flags for tracking which PICK DATE or PICK TIME buttons are pressed
    int DATE_DIALOG = 0;
    int TIME_DIALOG = 0;

    //references to our two spinner menus
    Spinner pickupLocation;
    Spinner dropoffLocation;

    //references to our four PICK DATE or PICK TIME buttons
    Button pickupDateButton;
    Button pickupTimeButton;
    Button dropoffDateButton;
    Button dropoffTimeButton;

    //references to text fields that hold values updated by timePicker() and datePicker()
    TextView pickupDate;
    TextView pickupTime;
    TextView dropoffDate;
    TextView dropoffTime;

    //create fragment manager for the date and time picker UI elements
    FragmentManager fm = getFragmentManager();

    /**
     * On creation of the activity by the user, run this code. Maps the UI elements (view) to the
     * controller and initializes action listners for those UI elements.
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

        //listen for press of BACK button and go to MainMenuActivity
        Button backButton = (Button) findViewById(R.id.reservone_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if button is pressed, start the reservation activity
                Intent intent = new Intent(ReservOneActivity.this, MainMenuActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //listen for press of NEXT button and go to ReservTwoActivity
        Button nextButton = (Button) findViewById(R.id.reservone_next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if button is pressed, start the reservation activity
                Intent intent = new Intent(ReservOneActivity.this, ReservTwoActivity.class);
                startActivity(intent);
                finish();
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

        //TODO: store the user's selection and differentiate between pickup & dropoff
        switch (position) {
            case 0:
                // Whatever you want to happen when the first item gets selected
                break;
            case 1:
                // Whatever you want to happen when the second item gets selected
                break;
            case 2:
                // Whatever you want to happen when the third item gets selected
                break;

        }
    }

    /**
     * If nothing is selected by the user in the spinner menu, do nothing.
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
        Calendar cal = new GregorianCalendar(year, month, day);
        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
        //TODO: store selected dates in model
        if (DATE_DIALOG == 1)
        {
            pickupDate.setText(dateFormat.format(cal.getTime()));
        }
        else if (DATE_DIALOG == 2)
        {
            dropoffDate.setText(dateFormat.format(cal.getTime()));
        }
    }

    /**
     * When a user selects a time, the time picker calls this method. This method stores the user's
     * input in the reservation model and also updates the view with the selected value.
     * @param hour
     * @param minute
     */
    @Override
    public void onTimeSet(int hour, int minute) {
        //TODO: store selected times in model
        String timeString = hour +":"+ minute;
        if (TIME_DIALOG == 1)
        {
            pickupTime.setText(timeString);
        }
        else if (TIME_DIALOG == 2)
        {
            dropoffTime.setText(timeString);
        }
    }
}