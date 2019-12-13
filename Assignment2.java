import javax.swing.*;

/**
 * A calculator program that can do simple mathematics
 * All of the calculations are done by the @calculations.java
 *
 * Has been tried so that even if the user inputs letters
 * Or divides by zero, the program won't crash
 * Author @ Felix Hoglund
 **/

public class Assignment2 {
    public static void main(String[] args) {

        //Declaring variables for later use
        double input;
        double sum;
        double num1, num2;
        boolean repeat = true;
        boolean wrongInput = true;

        //While case that checks if the user still wants to use the program
        while (repeat) {
            //Modifying the text on the buttons
            Object[] options = {"\u002b", "\u002d", "\u002a", "\u002f", "Quit"};

            //Creating the panel for inputs
            JPanel panel = new JPanel();
            panel.add(new JLabel("Enter two numbers: xx xx"));
            JTextField textField = new JTextField(10);
            panel.add(textField);


            //User chooses button
            input = JOptionPane.showOptionDialog(null, panel, "Calculations",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);

            //Exits the program if user presses quit
            if (input == 4)
                System.exit(0);

            //Saving the numbers written and parsing them later
            String inputNum = textField.getText();
            String tempNum1 = inputNum.substring(0, inputNum.indexOf(" "));
            String tempNum2 = inputNum.substring(inputNum.indexOf(" "));


            //Try catch function for finding if the user put in the wrong number
            //Or if user inputs a letter
            while (wrongInput) {
                try {
                    num1 = Double.parseDouble(tempNum1);
                    num2 = Double.parseDouble(tempNum2);
                    wrongInput = false;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error, not a number");
                    input = JOptionPane.showOptionDialog(null, panel, "Calculations",
                            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
                    inputNum = textField.getText();
                    tempNum1 = inputNum.substring(0, inputNum.indexOf(" "));
                    tempNum2 = inputNum.substring(inputNum.indexOf(" "));
                }
            }

            //Parsing the numbers
            num1 = Double.parseDouble(tempNum1);
            num2 = Double.parseDouble(tempNum2);

            //If cases that checks what kind of button is used
            if (input == 0) {
                sum = Calculations.addition(num1, num2);
                JOptionPane.showMessageDialog(null, num1 + " + " + num2 + " = " + sum);
            } else if (input == 1) {
                sum = Calculations.subtraction(num1, num2);
                JOptionPane.showMessageDialog(null, num1 + " - " + num2 + " = " + sum);
            } else if (input == 2) {
                sum = Calculations.multiplication(num1, num2);
                JOptionPane.showMessageDialog(null, num1 + " * " + num2 + " = " + sum);
            } else {
                sum = Calculations.divide(num1, num2);
                JOptionPane.showMessageDialog(null, num1 + " / " + num2 + " = " + sum);
            }

        }
    }
}