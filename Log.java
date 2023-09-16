public class Log implements Function {
    private Function operand;
    public Log(Function operand) {
        this.operand = operand;
    }
    /**
    * Returns the value of this function evaluated at x. This is equivalent to Math#log ( Math. log ( x ))
    * 
    * @param x - the argument to the function
    * 
    * @return the value of this function evaluated at x as a double with precision in the range 0. 0 -
    */
    public double value(double x) {
        return Math.log(operand.value(x));
    }
    /**
    * Returns the derivative of this function. The derivative is computed as follows : x / y where x and y are the operands.
    * 
    * 
    * @return the derivative of this function as a Function object ( never null ). This function can be used in combination with #add ( Function )
    */
    public Function derivative() {
        return new BinaryOp(Operator.DIVIDE,
                operand.derivative(),
                operand);
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
    * Returns a string representation of this expression. This method is useful for debugging purposes as opposed to being called directly by code that knows how to evaluate expressions.
    * 
    * 
    * @return a string representation of this expression in human readable form e. g. exp ( x ) where x is a
    */
    public String toString() {
        String operandString = operand.toString();
        // Append the operand to the operandString.
        if (operand instanceof BinaryOp) {
            operandString = "(" + operandString + ")";
        }
        return "Exp[" + operandString + "]";
    }
    /**
    * Returns true if this Log is equal to the specified object. Two Log objects are equal if they have the same operand and are equal according to Log#equals ( Object )
    * 
    * @param obj - the object to compare to
    * 
    * @return true if and only if obj is a Log and both Log objects are equal according to Log#equals
    */
    public boolean equals(Object obj) {
        // Returns true if the object is a Log object.
        if (obj instanceof Log) {
            Log other = (Log) obj;
            return operand.equals(other.operand);
        }
        return false;
    }
}