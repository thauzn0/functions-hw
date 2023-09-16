

// Creates a polynomial that takes a function and a power. The arguments are set in this
/**
 * The Polynomial class implements the Function interface and represents a polynomial function with a
 * given operand and power.
 */

public class Polynomial implements Function {
    private Function operand;
    private double power;
    public Polynomial(Function operand, double power) {
        this.operand = operand;
        this.power = power;
    }
    /**
    * Evaluates the function at the given value. This is equivalent to Math#pow ( double double ) but more efficient for functions that take a double argument
    * 
    * @param x - the value at which to evaluate the function
    * 
    * @return the value of the function at the given value as a double with the same sign as the power of
    */
    public double value(double x) {
        return Math.pow(operand.value(x), power);
    }
    /**
    * Returns the derivative of this function. The derivative is defined as the multiplication of the number and the polynomial with the power of the operand minus one.
    * 
    * 
    * @return the derivation of this function as a function of the operand's derivative as a function of the
    */
    public Function derivative() {
        Function operandDerivative = operand.derivative();
        return new BinaryOp(Operator.MULTIPLY,
                new Number(power),
                new BinaryOp(Operator.MULTIPLY,
                        new Polynomial(operand, power - 1),
                        operandDerivative));
    }
    /**
    * Gets the power of the power bar. This is the amount of power that will be taken by the battery in the unit of millimeters.
    * 
    * 
    * @return the power of the power bar in millimeters or 0 if not set ( for example if the bar is empty
    */
    public double getPower() {
        return power;
    }
    /**
    * Returns the operand of this function. Note that this is a copy of the operand that was passed to #addOperand ( Function ).
    * 
    * 
    * @return the operand of this function or null if there is no operand to be used for this function's
    */
    public Function getOperand() {
        return operand;
    }
    /**
    * Returns a string representation of this Operand. The string representation is suitable for use in error messages such as " Not Equal to 0 ".
    * 
    * 
    * @return a string representation of this Operand and its operand in human readable form e. g. " Not Equal to
    */
    public String toString() {
        String operandString = operand.toString();
        // Append the operand to the operandString.
        if (operand instanceof BinaryOp) {
            operandString = "(" + operandString + ")";
        }
        return operandString + " ^" + power;
    }
    /**
    * Compares this polynomial with another. Two polynomials are equal if they have the same exponent and operand.
    * 
    * @param obj - the object to compare with. Must be an instance of Polynomial.
    * 
    * @return true if the two polynomials are equal false otherwise. This method returns false if obj is null or if obj is not a Polynomial
    */
    public boolean equals(Object obj) {
        // Returns true if the object is a polynomial.
        if (obj instanceof Polynomial) {
            Polynomial other = (Polynomial) obj;
            return power == other.power && operand.equals(other.operand);
        }
        return false;
    }
}