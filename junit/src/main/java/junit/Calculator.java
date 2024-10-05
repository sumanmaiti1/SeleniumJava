package junit;


/**
 * This Calculator Class is juts a demo class created for Demomnstrating Junit Turorial
 * It has Normal Arithmathic Operations
 */

public class Calculator {

    public double addition(double a, double b) {
        return a+b;
    }

    public double subtraction(double a, double b) {
        return a-b;
    }

    public double multiplication(double a, double b) {
        return a*b;
    }

    public double division(double a, double b) {
        return a/b;
    }

    public double power(double a, double b) {
        return Math.pow(a, b);
    }

    public double percentage(double a, double b){
        return a*b/100;
    }

}
