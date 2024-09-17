package ca.georgian.omer.omer_sayir_blue_calculator;

public class CalculatorModel {

    double firstNumber = 0.0;
    double secondNumber = 0.0;
    double result = 0.0;

    boolean firstNumberSet = false;
    boolean secondNumberSet = false;
    boolean operatorSet = false;

    String operator = "";

    public void setFirstNumber(double num) {
        firstNumber = num;
        firstNumberSet = true;
    }

    public void setSecondNumber(double num) {
        secondNumber = num;
        secondNumberSet = true;
    }

    public double getResult() {
        computeResult();
        return result;
    }

    public void computeResult() {
        if (firstNumberSet && secondNumberSet && operatorSet) {
            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "/":
                    result = firstNumber / secondNumber;
                    break;
                case "X":
                    result = firstNumber * secondNumber;
                    break;
            }
        }
    }

    public void clear() {
        setFirstNumber(0.0);
        setSecondNumber(0.0);
        setOperator("");
        firstNumberSet = false;
        secondNumberSet = false;
        operatorSet = false;
    }

    public void setOperator(String op) {
        operator = op;
        operatorSet = true;
    }
}
