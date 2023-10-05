package week1.Caculator.model;

public class CalculatorModel {
  private int result;

  public void add(int num1, int num2) {
    result = num1 + num2;
  }

  public void subtract(int num1, int num2) {
    result = num1 - num2;
  }

  public int getResult() {
    return result;
  }
}
