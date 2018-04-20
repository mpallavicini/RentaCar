package edu.fau.oosd.group9.rentacar;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ReservOneActivity extends AppCompatActivity
        implements DatePickerFragment.DatePickerFragmentListener,
        TimePickerFragment.TimePickerFragmentListener {

    int DATE_DIALOG = 0;
    int TIME_DIALOG = 0;

    Button pickupDateButton;
    Button pickupTimeButton;
    Button dropoffDateButton;
    Button dropoffTimeButton;

    TextView pickupDate;
    TextView pickupTime;
    TextView dropoffDate;
    TextView dropoffTime;

    FragmentManager fm = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserv_one);

        pickupDateButton = findViewById(R.id.pickup_date_button);
        pickupTimeButton = findViewById(R.id.pickup_time_button);
        dropoffDateButton = findViewById(R.id.dropoff_date_button);
        dropoffTimeButton = findViewById(R.id.dropoff_time_button);

        pickupDate = findViewById(R.id.pickup_date_view);
        pickupTime = findViewById(R.id.pickup_time_view);
        dropoffDate = findViewById(R.id.dropoff_date_view);
        dropoffTime = findViewById(R.id.dropoff_time_view);

        pickupDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DATE_DIALOG = 1;
                datePicker();
            }
        });

        pickupTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIME_DIALOG = 1;
                timePicker();
            }
        });

        dropoffDateButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                DATE_DIALOG = 2;
                datePicker();
            }
        }));

        dropoffTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIME_DIALOG = 2;
                timePicker();
            }
        });

        //listen for press of NEXT button
        Button makeReservationButton = (Button) findViewById(R.id.reservone_next);
        makeReservationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if button is pressed, start the reservation activity
                Intent intent = new Intent(ReservOneActivity.this, ReservTwoActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void datePicker() {
        DatePickerFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.show(fm, "Pick Date");
    }

    public void timePicker() {
        TimePickerFragment timePickerFragment = new TimePickerFragment();
        timePickerFragment.show(fm, "Pick Time");
    }

    @Override
    public void onDateSet(int year, int month, int day) {
        Calendar cal = new GregorianCalendar(year, month, day);
        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
        if (DATE_DIALOG == 1)
        {
            pickupDate.setText(dateFormat.format(cal.getTime()));
        }
        else if (DATE_DIALOG == 2)
        {
            dropoffDate.setText(dateFormat.format(cal.getTime()));
        }
    }

    @Override
    public void onTimeSet(int hour, int minute) {
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