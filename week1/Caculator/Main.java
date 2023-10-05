package week1.Caculator;

import week1.Caculator.model.CalculatorModel;
import week1.Caculator.view.CalculatorView;
import week1.Caculator.controller.CalculatorController;

public class Main {
  public static void main(String[] args) {
    CalculatorView view = new CalculatorView();
    CalculatorModel model = new CalculatorModel();
    CalculatorController controller = new CalculatorController(view, model);
  }
}
