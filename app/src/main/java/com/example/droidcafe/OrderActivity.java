package com.example.droidcafe;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private static final String TAG_ACTIVITY =
            OrderActivity.class.getSimpleName();

    public void displayToast(String message) { Toast.makeText(getApplicationContext(),
            message,
            Toast.LENGTH_SHORT).show();
    }

    public void onRadioButtonClicked(View view) {
        // Check if the button is now checked
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.sameday:
                if (checked) {
                    // Same day service
                    displayToast(getString(R.string.chosen) + " " + getString(R.string.same_day_messenger_service));
                }
                break;

            case R.id.nextday:
                if (checked) {
                    // Next day delivery
                    displayToast(getString(R.string.chosen) + " " + getString(R.string.next_day_ground_delivery));
                }
                break;

            case R.id.pickup:
                if (checked) {
                    // Pick up
                    displayToast(getString(R.string.chosen) + " " + getString(R.string.pick_up));
                }
                break;

            default:
                // Log if no button was clicked
                Log.d("TAG_ACTIVITY", getString(R.string.nothing_clicked));
                break;
        }
    }

}