public class Variable implements Function {
    /**
    * Returns the value associated with the specified argument. This method is called by the implementation of #evaluate ( double ) to evaluate the function at the specified argument.
    * 
    * @param x - the argument to evaluate. This value is ignored.
    * 
    * @return the value associated with the specified argument ; this may be the same as x if the function is evaluated multiple times
    */
    public double value(double x) {
        return x;
    }
    /**
    * Returns the derivative of this function. It is equivalent to the following code : function ( 1 ). derivative ()
    * 
    * 
    * @return the derivative of this function as a Function object with one argument ( 1 ) as the first argument and no
    */
    public Function derivative() {
        return new Number(1);
    }
    /**
    * Returns a string representation of this Point. The string representation is used to compare points in 2D space to determine if they are equal or not.
    * 
    * 
    * @return a string representation of this Point in 2D space to determine if they are equal or not. If the point is equal to a point in 2D space it is returned
    */
    public String toString() {
        return "x";
    }
    /**
    * Returns true if the specified object is equal to this object. This method differs from equals in that it does not throw an exception if the specified object is not an instance of Variable.
    * 
    * @param obj - the object to compare to. Must be an instance of Variable.
    * 
    * @return true if the specified object is equal to this object false otherwise. Note that equals is not case sensitive
    */
    public boolean equals(Object obj) {
        return obj instanceof Variable;
    }
}