/**
 * The Number class represents a mathematical constant value and provides methods for evaluating its
 * value and derivative.
 */
public class Number implements Function {
    private double value;
    public Number(double value) {
        this.value = value;
    }
    /**
    * Returns the value associated with the specified argument. This method is called by the evaluator to evaluate the function at the specified argument.
    * 
    * @param x - the argument at which the function is evaluated.
    * 
    * @return the value associated with the argument in the function's coordinate
    */
    public double value(double x) {
        return value;
    }
    /**
    * Returns the derivative of this function. This is equivalent to the following code : function. derivative ().
    * 
    * 
    * @return the derivative of this function as a Function object. Note that the derivative may be different from the function returned by this
    */
    public Function derivative() {
        return new Number(0);
    }
    /**
    * Returns a String representation of this object. The result is suitable for use in debugging or other purposes as a log message.
    * 
    * 
    * @return a String representation of this object or null if this object is
    */
    public String toString() {
        return Double.toString(value);
    }
    /**
    * Returns true if this number is equal to the specified object. Two numbers are equal if they have the same value and are both Number#isEqual ( Number ) equal to true.
    * 
    * @param obj - the object to compare with. Must be a Number.
    * 
    * @return true if and only if this number is equal to
    */
    public boolean equals(Object obj) {
        // Returns true if the value of the object is equal to the other number.
        if (obj instanceof Number) {
            Number other = (Number) obj;
            return value == other.value;
        }
        return false;
    }
}