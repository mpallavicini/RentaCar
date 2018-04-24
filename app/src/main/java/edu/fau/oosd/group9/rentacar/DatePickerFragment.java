package edu.fau.oosd.group9.rentacar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Class for handling input and output from a date picker
 * @author Marco
 */
public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    private DatePickerFragmentListener listener;

    /**
     * Upon call of the date picker dialog, present it to the user
     * @param savedInstanceState
     * @return the instance of
     */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    /**
     * When user picks date and taps OK, this method listens for that and gets date entered
     * @param view
     * @param year
     * @param month
     * @param day
     */
    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        listener.onDateSet(year, month, day);
    }

    /**
     * This is the method from the DatePicker fragment to implement in the Main Activity
     */

    public interface DatePickerFragmentListener{
        public void onDateSet(int year, int month, int day);
    }

    /**
     * Attaches date picker context
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (DatePickerFragmentListener) context;
    }
}