package homework07;
//Test comment
public class FinancialCalculator extends BasicCalculator{
//Just Senseless Overload of method from Basic Calculator
    @Override
    public double getSum(double num1, double num2) {
        double x = super.getSum(num1, num2);
        System.out.println("This is sum of numbers from Financial Calculator: ");
        return x;
    }
    //Compound Interest calculation
    public double getPercent(int term, double total, double percent) {
        for (int i = 1; i<= term; i++) {
            double x = super.getPercent(total, percent);
            total = total+x;
        }
        return total;
    }


}
