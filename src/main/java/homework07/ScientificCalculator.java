package homework07;
//Test comment
public class ScientificCalculator extends BasicCalculator {

    public double getPow(double base, int index) {
        return Math.pow(base, index);
    }

    public double getSqrt(double radic) {
        return Math.sqrt(radic);
    }

    public double getLog(double val) {
        return Math.log(val);
    }

    public double getLog(double val, double base) {
        return Math.log(val) / Math.log(base);
    }

    public double getSin(double arg) {
        return Math.sin(Math.toRadians(arg));
    }

    public double getCos(double arg) {
        return Math.cos(Math.toRadians(arg));
    }

    public double getTan(double arg) {
        return Math.tan(Math.toRadians(arg));
    }

}
