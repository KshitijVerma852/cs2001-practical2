package interfaces;


/**
 * Interface for a factory allowing the other interfaces to be instantiated without knowing the implementation classes.
 *
 */
public interface IFactory {

    /**
     * Creates an instance of {@link IDoubleStack}.
     * @param maxSize the maximum size that is shared over both stacks in this double stack
     * @return the double stack
     */
    IDoubleStack makeDoubleStack(int maxSize);


    /**
     * This method creates a DoubleStack-based Queue which conforms with the {@link IQueue} interface.
     * @param maxSize the maximum size of DoubleStack-based queue
     * @return the queue
     */
    IQueue makeDoubleStackQueue(int maxSize);


}
