package ca.georgian.omer.omer_sayir_blue_calculator;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    boolean acceptingDigits = true;
    boolean startNewNumber = true;

    CalculatorModel calculatorModel = new CalculatorModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void buttonClicked(android.view.View view) {

        // Which button is pressed
        Button button = (Button) view;
        String buttonText = button.getText().toString();

        TextView textView = findViewById(R.id.numberDisplay);
        String currentNumber = textView.getText().toString();

        switch (buttonText) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case ".":
                if (startNewNumber) {
                    if (buttonText.equals(".")) {
                        currentNumber = "0.";
                    } else {
                        currentNumber = buttonText;
                    }
                    startNewNumber = false;
                } else {
                    if (buttonText.equals(".") && currentNumber.contains(".")) {
                        break;
                    } else {
                        currentNumber += buttonText;
                    }
                }
                break;
            case "+":
            case "-":
            case "/":
            case "X":
                double firstNumber = Double.parseDouble(currentNumber);
                calculatorModel.setFirstNumber(firstNumber);
                calculatorModel.setOperator(buttonText);
                startNewNumber = true;
                break;
            case "=":
                double secondNumber = Double.parseDouble(currentNumber);
                calculatorModel.setSecondNumber(secondNumber);
                currentNumber = String.valueOf(calculatorModel.getResult());
                startNewNumber = true;
                break;
            case "C":
                currentNumber = "0.";
                calculatorModel.clear();
                startNewNumber = true;

        }
        textView.setText(currentNumber);

    }
}