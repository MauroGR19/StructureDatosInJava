package co.edu.unaula.dataStructure.recursion;

public class RecursiveFactorial {

    // To Fill



    private final int ONE = 1, ZERO = 0;
    private int number;
    private int result;
    private String massage;

    public String getMassage() {
        return massage;
    }

    private boolean isNegative(int num){
        return num < ZERO;
    }

    private boolean isInteger(String num){
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException ex){
            return false;
        }
    }

    private int calFactorial(int num){
        if (num == ZERO){
            return ONE;
        }

        return num * calFactorial(num - ONE);

    }

    public RecursiveFactorial factorial(String num){
        try {
            if (!isInteger(num)){
                massage = "Debe ingrasar un numero entero";
                return this;
            }
            number = Integer.parseInt(num);
            if (isNegative(number)) {
                massage = "No se puede calcular el factorial de un negativo";
                return this;
            }
            result =  calFactorial(number);
            massage = "El factorial de: " + number +" es: " + result;
            return this;
        } catch (Exception ex){
            throw ex;
        }
    }

}
