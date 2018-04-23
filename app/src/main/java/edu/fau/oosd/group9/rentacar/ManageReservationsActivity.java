package edu.fau.oosd.group9.rentacar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ManageReservationsActivity extends AppCompatActivity {

    //get AppModel instance
    private final AppModel modelInstance = AppModel.getInstance();
    //get current logged in user
    private final UserProfile currentUser = modelInstance.getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservations);

        ArrayList<Reservation> existingReservations = currentUser.getUserReservations();
        addRadioButtons(existingReservations);
    }

    public void addRadioButtons(ArrayList<Reservation> listOfReservations) {

        for (int row = 0; row < 1; row++) {
            RadioGroup ll = new RadioGroup(this);
            ll.setOrientation(LinearLayout.VERTICAL);

            int i = 0;
            for (Reservation aReservation : listOfReservations) {
                RadioButton radio_btn = new RadioButton(this);
                radio_btn.setId((row * 2) + i);
                String textToDisplay = aReservation.getPickUpDate() + " @ "
                        + aReservation.getPickUpTime() + " from " + aReservation.getPickUpLocation();
                radio_btn.setText(textToDisplay);
                ll.addView(radio_btn);
                i += 1;
            }
            ((ViewGroup) findViewById(R.id.radiogroup)).addView(ll);
        }
    }
}
