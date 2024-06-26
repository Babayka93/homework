public interface ComplexNumber {
    double getRealPart();
    double getImaginaryPart();
    ComplexNumber add(ComplexNumber number);
    ComplexNumber multiply(ComplexNumber number);
    ComplexNumber divide(ComplexNumber number);
}

public class ComplexNumberImpl implements ComplexNumber {
    private double realPart;
    private double imaginaryPart;

    public ComplexNumberImpl(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    @Override
    public double getRealPart() {
        return realPart;
    }

    @Override
    public double getImaginaryPart() {
        return imaginaryPart;
    }

    @Override
    public ComplexNumber add(ComplexNumber number) {
        return new ComplexNumberImpl(realPart + number.getRealPart(),
                imaginaryPart + number.getImaginaryPart());
    }

    @Override
    public ComplexNumber multiply(ComplexNumber number) {
        //(a + bi)(c + di) = (ac - bd) + (ad + bc)i
        double newRealPart = realPart * number.getRealPart() - imaginaryPart * number.getImaginaryPart();
        double newImaginaryPart = realPart * number.getImaginaryPart() + imaginaryPart * number.getRealPart();
        return new ComplexNumberImpl(newRealPart, newImaginaryPart);
    }

    @Override
    public ComplexNumber divide(ComplexNumber number) {
        // ((a+bi)/(c+di)) = ((a+bi)(c-di))/(c^2 + d^2)
        double divisor = number.getRealPart() * number.getRealPart() + number.getImaginaryPart() * number.getImaginaryPart();
        double newRealPart = (realPart * number.getRealPart() + imaginaryPart * number.getImaginaryPart()) / divisor;
        double newImaginaryPart = (imaginaryPart * number.getRealPart() - realPart * number.getImaginaryPart()) / divisor;
        return new ComplexNumberImpl(newRealPart, newImaginaryPart);
    }
}
public class Logger {
    public void log(String message) {
        System.out.println("Logging: " + message);
    }
}
public class ComplexCalculator {
    private Logger logger;

    public ComplexCalculator(Logger logger) {
        this.logger = logger;
    }

    public ComplexNumber add(ComplexNumber num1, ComplexNumber num2) {
        logger.log("Adding complex numbers");
        return num1.add(num2);
    }

    public ComplexNumber multiply(ComplexNumber num1, ComplexNumber num2) {
        logger.log("Multiplying complex numbers");
        return num1.multiply(num2);
    }

    public ComplexNumber divide(ComplexNumber num1, ComplexNumber num2) {
        logger.log("Dividing complex numbers");
        return num1.divide(num2);
    }
}git