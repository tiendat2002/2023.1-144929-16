package week1.Caculator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import week1.Caculator.model.CalculatorModel;
import week1.Caculator.view.CalculatorView;

public class CalculatorController {
  private CalculatorView view;
  private CalculatorModel model;

  public CalculatorController(CalculatorView view, CalculatorModel model) {
    this.view = view;
    this.model = model;

    this.view.addCalculateListener(new CalculateListener());
  }

  class CalculateListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      int firstNumber = view.getFirstNumber();
      int secondNumber = view.getSecondNumber();

      model.add(firstNumber, secondNumber);

      view.setResult(model.getResult());
    }
  }
}
