
/*  Function interface  -  a function that can be evaluated at a given argument and has a derivative 
* @param x - The argument to evaluate. This should be a double but is not checked for validity.

*/
public interface Function {
    /**
    * Returns the value associated with the argument. This method is called by the C ++ compiler to evaluate the function at the given argument.
    * 
    * @param x - The argument to evaluate. This should be a double but is not checked for validity.
    * 
    * @return The value associated with the argument or NaN if the argument is NaN or not in the range [ 0 1 ]
    */
    double value(double x);
    /**
    * Returns the derivative of this function. Note that this function does not have to be defined in terms of the derivatives of its argument.
    * 
    * 
    * @return the derivative of this function or null if there is no derivative in the sense of the argument's
    */
    Function derivative();
}