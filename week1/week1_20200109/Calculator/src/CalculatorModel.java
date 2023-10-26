public class CalculatorModel {
    private double result;
    private double currentInput;
    private String operator;

    public void performOperation() {
        if (operator != null) {
            switch (operator) {
                case "+":
                    result += currentInput;
                    break;
                case "-":
                    result -= currentInput;
                    break;
                case "*":
                    result *= currentInput;
                    break;
                case "/":
                    if (currentInput != 0) {
                        result /= currentInput;
                    } else {
                        throw new ArithmeticException("Không thể chia cho 0");
                    }
                    break;
                default:
                    throw new UnsupportedOperationException("Phép toán không hợp lệ");
            }
        } else {
            result = currentInput;
        }
    }

    public double getResult() {
        return result;
    }

    public void setCurrentInput(double currentInput) {
        this.currentInput = currentInput;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setResult(int i) {
        this.result = result;
    }
}