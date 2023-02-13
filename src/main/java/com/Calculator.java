package com;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Calculator {
    @FXML
    private TextField textField;

    private String firstNumber = "";
    private String currentNumber = "";
    private String calculatingType;

    public void selectZero(){
        if(!currentNumber.equals(""))
            addNumber("0");
    }
    public void selectOne(){addNumber("1");}

    public void selectTwo(){addNumber("2");}

    public void selectThree(){addNumber("3");}

    public void selectFour(){addNumber("4");}

    public void selectFive(){addNumber("5");}

    public void selectSix(){addNumber("6");}

    public void selectSeven(){addNumber("7");}

    public void selectEight(){addNumber("8");}

    public void selectNine(){addNumber("9");}

    public void selectBackspace() {
        if(!currentNumber.equals("")) {
            currentNumber = currentNumber.substring(0, currentNumber.length()-1);
            updateTextField();
        }
    }

    public void selectClear() {
        currentNumber = "";
        updateTextField();
    }

    public void selectResult() {
        double firstNumberInt = Double.parseDouble(firstNumber);
        double secondNumberInt = Double.parseDouble(currentNumber);
        double calculatedNumber = 0;
        switch(calculatingType) {
            case "+" -> {
                calculatedNumber = firstNumberInt + secondNumberInt;
                textField.setText(String.valueOf(calculatedNumber));
            }
            case "-" -> {
                calculatedNumber = firstNumberInt - secondNumberInt;
                textField.setText(String.valueOf(calculatedNumber));
            }
            case "*" -> {
                calculatedNumber = firstNumberInt * secondNumberInt;
                textField.setText(String.valueOf(calculatedNumber));
            }
            case "/" -> {
                calculatedNumber = firstNumberInt / secondNumberInt;
                textField.setText(String.valueOf(calculatedNumber));
            }
        }
        currentNumber = String.valueOf(calculatedNumber);
    }



    public void selectClearAll(){
        currentNumber = "";
        firstNumber = "";
        textField.setText("");
    }
    public void selectDivide(){setCalculation("/");}

    public void selectSqrt(){
        if(!currentNumber.contains("-")) {
            Double currentNumberDouble = Double.parseDouble(currentNumber);
            currentNumberDouble = Math.sqrt(currentNumberDouble);
            currentNumber = String.valueOf(currentNumberDouble);
            updateTextField();
        }
    }
    public void selectMultiply(){setCalculation("*");}

    public void selectSquare(){
        Double currentNumberDouble = Double.parseDouble(currentNumber);
        currentNumberDouble = currentNumberDouble * currentNumberDouble;
        currentNumber = String.valueOf(currentNumberDouble);
        updateTextField();
    }

    public void selectSub(){setCalculation("-");}

    public void selectInvert(){
        if(!currentNumber.equals("")) {
            Double currentNumberDouble = Double.parseDouble(currentNumber);
            currentNumberDouble = 1 / currentNumberDouble;
            currentNumber = String.valueOf(currentNumberDouble);
            updateTextField();
        }
    }
    public void selectSum(){setCalculation("+");}

    public void selectChangeSign(){
        if(!currentNumber.contains("-")) {
            currentNumber = "-" + currentNumber;
        }
        else {
            double currentNumberDouble = Double.parseDouble(currentNumber);
            currentNumberDouble = currentNumberDouble * (-1);
            currentNumber = String.valueOf(currentNumberDouble);
        }
        updateTextField();
    }

    public void selectDot() {
        if(!currentNumber.contains(".")) {
            if (currentNumber.equals(""))
                currentNumber += "0.";
            else
                currentNumber += ".";
            updateTextField();
        }
    }

    private void updateTextField() {
        textField.setText(currentNumber);
    }

    private void addNumber(String number) {
        currentNumber += number;
        updateTextField();
    }

    private void setCalculation(String calculatingType) {
        this.calculatingType = calculatingType;
        if(!currentNumber.equals("")) {
            firstNumber = currentNumber;
            currentNumber = "";
        }
        else if(currentNumber.equals("") && firstNumber.equals(""))
            firstNumber = "0";
    }
}