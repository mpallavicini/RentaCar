package edu.fau.oosd.group9.rentacar;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Class for handling input and output from a time picker
 */
public class TimePickerFragment extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {

    private TimePickerFragmentListener listener;

    /**
     * Upon call of the time picker dialog, present it to the user
     * @param savedInstanceState
     * @return the instance of
     */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    /**
     * When user picks time and taps OK, this method listens for that and gets time entered
     * @param view
     * @param hour
     * @param minute
     */
    @Override
    public void onTimeSet(TimePicker view, int hour, int minute) {
        listener.onTimeSet(hour, minute);
    }

    /**
     * This is the method from the DatePicker fragment to implement in the Main Activity
     */
    public interface TimePickerFragmentListener{
        public void onTimeSet(int hour, int minute);
    }

    /**
     * Attaches time picker context
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (TimePickerFragmentListener) context;
    }
}