package ca.georgian.omer.omer_sayir_blue_calculator;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    boolean acceptingDigits = true;
    boolean startNewNumber = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void buttonClicked(android.view.View view) {

        // Which button is pressed
        Button button = (Button) view;
        String buttonText = button.getText().toString();

        // change display text
        String displayText = (String) ((TextView) findViewById(R.id.numberDisplay)).getText();
        TextView numberDisplay = (TextView) findViewById(R.id.numberDisplay);

        if (buttonText.equals("C")) {
            numberDisplay.setText("0");
            return;
        } else if (Character.isDigit(buttonText.charAt(0))) {
            if (displayText.equals("0")) {
                numberDisplay.setText(buttonText);
            } else {
                numberDisplay.setText(displayText + buttonText);
            }
        }
    }
}