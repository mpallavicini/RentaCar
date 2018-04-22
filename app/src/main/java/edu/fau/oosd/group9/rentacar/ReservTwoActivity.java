package edu.fau.oosd.group9.rentacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class ReservTwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserv_two);

        //listen for press of BACK button and go to ReservOneActivity
        Button backButton = (Button) findViewById(R.id.reservtwo_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if button is pressed, start the reservation activity
                Intent intent = new Intent(ReservTwoActivity.this, ReservOneActivity.class);
                startActivity(intent);
                finish();
            }
        });

/*        //listen for press of NEXT button and go to ReservTwoActivity
        Button nextButton = (Button) findViewById(R.id.reservtwo_next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if button is pressed, start the reservation activity
                Intent intent = new Intent(ReservTwoActivity.this, ReservThreeActivity.class);
                startActivity(intent);
                finish();
            }
        });*/

        RadioButton compactButton = (RadioButton) findViewById(R.id.radioButton1);
        compactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
