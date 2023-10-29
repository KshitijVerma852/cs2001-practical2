package interfaces;

/**
 * This interface represents the double stack object.
 *
 */
public interface IDoubleStack {

    /**
     * Method which returns the first IStack object in the IDoubleStack for subsequent use with {@link IStack} operations.
     * @return the first stack in the double stack
     */
    IStack getFirstStack();

    /**
     * Method which returns the second IStack in the IDoubleStack object for subsequent use with {@link IStack} operations.
     * @return the first stack in the double stack
     */
    IStack getSecondStack();
}
