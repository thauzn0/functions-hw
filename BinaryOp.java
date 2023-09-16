public class BinaryOp implements Function {
    private Operator operator;
    private Function leftOperand;
    private Function rightOperand;
    public BinaryOp(Operator operator, Function leftOperand, Function rightOperand) {
        this.operator = operator;
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }
    /**
    * Evaluates the expression with the given argument. This is the method that should be called by the user when it is known that the value has been computed.
    * 
    * @param x - the argument to the expression. This is the value that is returned by the #value ( double ) method.
    * 
    * @return the result of the expression's evaluation as a double value according to the expression's operator and
    */
    public double value(double x) {
        double leftValue = leftOperand.value(x);
        double rightValue = rightOperand.value(x);
        // Returns the value of the operator.
        switch (operator) {
            case ADD:
                return leftValue + rightValue;
            case SUBTRACT:
                return leftValue - rightValue;
            case MULTIPLY:
                return leftValue * rightValue;
            case DIVIDE:
                return leftValue / rightValue;
            default:
                throw new UnsupportedOperationException("Unsupported operator: " + operator);
        }
    }
    /**
    * Returns the derivative of this function. This is equivalent to multiplying the left operand and the right operand with the derivative of the right operand.
    * 
    * 
    * @return the derivative of this function as a Function object ( never null ). Note that the derivative may be null
    */
    public Function derivative() {
        Function leftDerivative = leftOperand.derivative();
        Function rightDerivative = rightOperand.derivative();
        // Returns the binary operator that is the same as the operator.
        switch (operator) {
            case ADD:
                return new BinaryOp(Operator.ADD, leftDerivative, rightDerivative);
            case SUBTRACT:
                return new BinaryOp(Operator.SUBTRACT, leftDerivative, rightDerivative);
            case MULTIPLY:
                return new BinaryOp(Operator.ADD,
                        new BinaryOp(Operator.MULTIPLY, leftOperand, rightDerivative),
                        new BinaryOp(Operator.MULTIPLY, leftDerivative, rightOperand));
            case DIVIDE:
                return new BinaryOp(Operator.DIVIDE,
                        new BinaryOp(Operator.SUBTRACT,
                                new BinaryOp(Operator.MULTIPLY, leftDerivative, rightOperand),
                                new BinaryOp(Operator.MULTIPLY, leftOperand, rightDerivative)),
                        new BinaryOp(Operator.MULTIPLY, rightOperand, rightOperand));
            default:
                throw new UnsupportedOperationException("Unsupported operator: " + operator);
        }
    }
    /**
    * Gets the operator associated with this rule. This is used to determine whether or not a rule is part of a multi - rule rule.
    * 
    * 
    * @return the operator associated with this rule or null if there is no operator associated with this rule or if the rule does not have a
    */
    public Operator getOperator() {
        return operator;
    }
    /**
    * Returns the left operand of the function. This is used to determine the type of the function's left operand.
    * 
    * 
    * @return the left operand of the function or null if there is no left operand ( in which case the function is a no - op
    */
    public Function getLeftOperand() {
        return leftOperand;
    }
    /**
    * Returns the right operand of the function. This is used to determine the type of the function and can be overridden by sub - classes that need to know their type.
    * 
    * 
    * @return the right operand of the function or null if there is no right operand to be returned by this sub -
    */
    public Function getRightOperand() {
        return rightOperand;
    }
    /**
    * Returns a string representation of this BinaryOp. The string representation is of the form leftOperand + operator + rightOperand where operator is either Operator. ADD or Operator. UNNECESSARY.
    * 
    * 
    * @return a string representation of this BinaryOp including operator and operands separated by " ( " and " ) "
    */
    public String toString() {
        String leftString = leftOperand.toString();
        String rightString = rightOperand.toString();
        // Returns the string representation of the left operand.
        if (leftOperand instanceof BinaryOp) {
            BinaryOp leftBinaryOp = (BinaryOp) leftOperand;
            // Returns the string representation of the left binary operator.
            if (leftBinaryOp.operator != operator) {
                leftString = "(" + leftString + ")";
            }
        }
        // Returns the string representation of the right operand.
        if (rightOperand instanceof BinaryOp) {
            BinaryOp rightBinaryOp = (BinaryOp) rightOperand;
            // Add the right binary operator to the right string.
            if (rightBinaryOp.operator != operator && rightBinaryOp.operator != Operator.ADD) {
                rightString = "(" + rightString + ")";
            }
        }
        return leftString + " " + operatorToString() + " " + rightString;
    }
    /**
    * Converts the operator to a string. This method is used for debugging purposes only. Do not use in production code.
    * 
    * 
    * @return String representation of the operator ( + - * / etc. ) as defined in RFC 4627.
    */
    private String operatorToString() {
        // Returns the operator of the operator.
        switch (operator) {
            case ADD:
                return "+";
            case SUBTRACT:
                return "-";
            case MULTIPLY:
                return "*";
            case DIVIDE:
                return "/";
            default:
                throw new UnsupportedOperationException("Unsupported operator: " + operator);
        }
    }
    /**
    * Compares this object with another. This is true if and only if both operands are the same. The operator is ignored.
    * 
    * @param obj - the object to compare with this object. May be null.
    * 
    * @return true if the objects are equal false otherwise. Note that this method returns false if obj is null or not an instance of BinaryOp
    */
    public boolean equals(Object obj) {
        // Returns true if the object is a binary operator.
        if (obj instanceof BinaryOp) {
            BinaryOp other = (BinaryOp) obj;
            return operator == other.operator &&
                    leftOperand.equals(other.leftOperand) &&
                    rightOperand.equals(other.rightOperand);
        }
        return false;
    }
}