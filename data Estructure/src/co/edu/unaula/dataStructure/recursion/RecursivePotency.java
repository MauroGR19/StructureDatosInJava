package co.edu.unaula.dataStructure.recursion;



public class RecursivePotency {

    // pay




    private final int ONE = 1, ZERO = 0;
    private double result;
    private String massage;

    public String getMassage() {
        return massage;
    }

    private boolean isInteger(String num){
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException ex){
            return false;
        }
    }

    private boolean isNumeric(String num){
        try {
            Double.parseDouble(num);
            return true;
        } catch (NumberFormatException ex){
            return false;
        }
    }

    private double calPotency(double base, double exponent){
        try {
            if (exponent == ZERO){
                return ONE;
            }
            else if (exponent < ZERO){
                return calPotency(base,exponent + ONE)/base;
            }
            else {
                return base * calPotency(base, exponent - ONE);
            }
        } catch (Exception ex){
            throw ex;
        }

    }

    public RecursivePotency potency (String base, String exponent){
        try {

            if (!isInteger(exponent)){
                massage = "El numero exponente debe ser entero";
                return this;
            }
            if (!isNumeric(base)){
                massage = "La base debe ser un numero";
                return this;
            }

            result = calPotency(Double.parseDouble(base),Double.parseDouble(exponent));
            massage = "El resultado de: " + base + " ^ " + exponent + " es: " + result;
            return this;
        } catch (Exception ex){
            throw ex;
        }
    }



}
