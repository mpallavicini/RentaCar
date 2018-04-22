package edu.fau.oosd.group9.rentacar;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {

    private TimePickerFragmentListener listener;

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

    @Override
    public void onTimeSet(TimePicker view, int hour, int minute) {
        listener.onTimeSet(hour, minute);
    }

    // This is the method from the DatePicker fragment to implement in the Main Activity
    public interface TimePickerFragmentListener{
        public void onTimeSet(int hour, int minute);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (TimePickerFragmentListener) context;
    }
}