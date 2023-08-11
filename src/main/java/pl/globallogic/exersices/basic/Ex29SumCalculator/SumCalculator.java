package pl.globallogic.exersices.basic.Ex29SumCalculator;

public class SumCalculator {
    double firstNumber = 0;
    double secondNumber = 0;

    public SumCalculator() {

    }
    public SumCalculator(double firstNumber, double secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public double getAdditionResult() {
        return getFirstNumber() + getSecondNumber();
    }

    public double getSubtractionResult() {
        return  getFirstNumber() - getSecondNumber();
    }
    public double getMultiplicationResult(){
        return getFirstNumber() * getSecondNumber();
    }

    public double getDivisionResult() {
        if (getSecondNumber() == 0) return 0;
        return getSecondNumber() / getFirstNumber();
    }


    public static void main(String[] args) {
        SumCalculator calculator = new SumCalculator();
        calculator.setFirstNumber(5.0);
        calculator.setSecondNumber(4);
        System.out.println("add= " + calculator.getAdditionResult());
        System.out.println("subtract= " + calculator.getSubtractionResult());
        calculator.setFirstNumber(5.25);
        calculator.setSecondNumber(0);
        System.out.println("multiply= " + calculator.getMultiplicationResult());
        System.out.println("divide= " + calculator.getDivisionResult());

    }
}
