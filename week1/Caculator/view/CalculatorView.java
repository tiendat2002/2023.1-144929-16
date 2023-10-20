package week1.Caculator.view;

import java.awt.event.ActionListener;
import javax.swing.*;

public class CalculatorView {
  private JTextField firstNumber = new JTextField(10);
  private JLabel additionLabel = new JLabel("+");
  private JTextField secondNumber = new JTextField(10);
  private JButton calculateButton = new JButton("Calculate");
  private JTextField result = new JTextField(10);

  public CalculatorView() {
    JPanel calculatorPanel = new JPanel();
    calculatorPanel.add(firstNumber);
    calculatorPanel.add(additionLabel);
    calculatorPanel.add(secondNumber);
    calculatorPanel.add(calculateButton);
    calculatorPanel.add(result);

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(calculatorPanel);
    frame.pack();
    frame.setVisible(true);
  }

  public int getFirstNumber() {
    return Integer.parseInt(firstNumber.getText());
  }

  public int getSecondNumber() {
    return Integer.parseInt(secondNumber.getText());
  }

  public void setResult(int result) {
    this.result.setText(Integer.toString(result));
  }

  public void addCalculateListener(ActionListener listener) {
    calculateButton.addActionListener(listener);
  }

}
