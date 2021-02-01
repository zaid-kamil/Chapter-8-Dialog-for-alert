package digi.chapter8dialogforalert;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button btnDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnAlert = findViewById(R.id.btnAlert);
        btnAlert.setOnClickListener(v -> {
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
            alertBuilder.setTitle("Alert");
            alertBuilder.setMessage("Click OK to continue, or Cancel to stop:");
            alertBuilder.setPositiveButton("OK", (dialogInterface, i) -> {
                Snackbar.make(btnAlert, "You pressed ok", Snackbar.LENGTH_SHORT).show();
            });
            alertBuilder.setNegativeButton("Cancel", (dialogInterface, i) -> {
                Snackbar.make(btnAlert, "you pressed cancel", Snackbar.LENGTH_SHORT).show();
            });
            alertBuilder.show();
        });

        btnDate = findViewById(R.id.btnDate);
        btnDate.setOnClickListener(view -> {
            DialogFragment datePicker = new DatePickerFragment();
            datePicker.show(getSupportFragmentManager(), "DatePicker");
        });
    }

    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (month_string + "/" + day_string + "/" + year_string);
        Snackbar.make(btnDate,dateMessage, Snackbar.LENGTH_LONG).show();
    }
}