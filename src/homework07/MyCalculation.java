package homework07;
//Test comment
public class MyCalculation {
    public static void main(String[] args) {

        BasicCalculator basicCalculator = new BasicCalculator();
        System.out.println(basicCalculator.getSum(5, 7));

        System.out.println(basicCalculator.getMult(4, 6));

        ScientificCalculator scientCalculator = new ScientificCalculator();
        System.out.println(scientCalculator.getSum(120, 250));

        System.out.println(scientCalculator.getLog(64, 2));

        System.out.println(scientCalculator.getTotal(7,14));

        FinancialCalculator finCalculator = new FinancialCalculator();
        System.out.println(finCalculator.getPercent(6, 100, 2));

        System.out.println(finCalculator.getSum(700, 800));
    }
}
