import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
        view.addListener(new CalculatorListener());
    }

    private class CalculatorListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = view.getUserInput();
            if (e.getSource() instanceof JButton) {
                String buttonText = ((JButton) e.getSource()).getText();
                if (buttonText.matches("[0-9]")) {
                    userInput += buttonText;
                    view.setUserInput(userInput);
                } else if (buttonText.equals("+") || buttonText.equals("-") || buttonText.equals("*") || buttonText.equals("/")) {
                    if (!userInput.isEmpty()) {
                        model.setCurrentInput(Double.parseDouble(userInput));
                        model.setOperator(buttonText);
                        view.clearInput();
                    }
                } else if (buttonText.equals("=")) {
                    if (!userInput.isEmpty()) {
                        try {
                            model.setCurrentInput(Double.parseDouble(userInput));
                            model.performOperation();
                            view.setUserInput(Double.toString(model.getResult()));
                        } catch (NumberFormatException ex) {
                            view.showError("Nhập không hợp lệ");
                        } catch (ArithmeticException ex) {
                            view.showError(ex.getMessage());
                        }
                    }
                } else if (buttonText.equals("C")) {
                    model.setResult(0);
                    model.setOperator(null);
                    view.clearInput();
                }
            }
        }
    }
}