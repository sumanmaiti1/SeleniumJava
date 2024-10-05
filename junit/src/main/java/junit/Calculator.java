package junit;


/**
 * This Calculator Class is juts a demo class created for Demomnstrating Junit Turorial
 * It has Normal Arithmathic Operations
 */

public class Calculator {

    double addition(double a, double b) {
        return a+b;
    }

    double subtraction(double a, double b) {
        return a-b;
    }

    double multiplication(double a, double b) {
        return a*b;
    }

    double division(double a, double b) {
        return a/b;
    }

    double power(double a, double b) {
        return Math.pow(a, b);
    }

    double percentage(double a, double b){
        return a*b/100;
    }

}
