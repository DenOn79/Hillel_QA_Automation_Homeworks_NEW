package homework07;
//Test comment
public class BasicCalculator {

    public double getSum(double number1, double number2) {
        return number1 + number2;
    }

    public double getDif(double number1, double number2) {
        return number1 - number2;
    }

    public double getMult(double number1, double number2) {
        return number1 * number2;
    }

    public double getDiv(double number1, double number2) {
        return number1 / number2;
    }

    public double getPercent(double total, double percent) {
        return total/100*percent;
    }

    public double getTotal(double percent, double fraction) {
        return fraction/percent*100;
    }
}
