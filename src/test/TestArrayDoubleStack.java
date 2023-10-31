package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import common.StackEmptyException;
import common.StackOverflowException;
import impl.Factory;
import interfaces.IFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import common.AbstractFactoryClient;
import interfaces.IDoubleStack;

/**
 * Tests array collection implementation.
 */
public class TestArrayDoubleStack extends AbstractFactoryClient {

    private static final int DEFAULT_MAX_SIZE = 10;

    /**
     * Tests that the factory constructs a non-null double stack.
     */
    @Test
    public void factoryReturnsNonNullDoubleStackObject() {
        IDoubleStack doubleStack1 = getFactory().makeDoubleStack(DEFAULT_MAX_SIZE);
        assertNotNull(doubleStack1, "Failure: IFactory.makeDoubleStack returns null, expected non-null object");
    }

    @Test
    public void checksIfTheFirstStackCanHoldOneValue() throws StackOverflowException, StackEmptyException {
        IDoubleStack doubleStack = getFactory().makeDoubleStack(DEFAULT_MAX_SIZE);
        doubleStack.getFirstStack().push(3);
        assertEquals(3, doubleStack.getFirstStack().pop());
    }

    @Test
    public void checksIfTheTopPropertyWorks() throws StackEmptyException, StackOverflowException {
        IDoubleStack doubleStack = getFactory().makeDoubleStack(DEFAULT_MAX_SIZE);
        doubleStack.getFirstStack().push(3);
        assertEquals(3, doubleStack.getFirstStack().top());
    }
}
