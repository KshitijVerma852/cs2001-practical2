package test;

import common.StackEmptyException;
import common.StackOverflowException;
import impl.Factory;
import interfaces.IFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import common.AbstractFactoryClient;
import interfaces.IDoubleStack;

import static org.junit.jupiter.api.Assertions.*;

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

    public void checksIfTheSecondStackCanHoldOneValue() throws StackOverflowException, StackEmptyException {
        IDoubleStack doubleStack = getFactory().makeDoubleStack(DEFAULT_MAX_SIZE);
        doubleStack.getSecondStack().push(3);
        assertEquals(3, doubleStack.getSecondStack().pop());
    }

    public void checksIfTheFirstStackCanHoldMultipleValues() throws StackOverflowException, StackEmptyException {
        IDoubleStack doubleStack = getFactory().makeDoubleStack(DEFAULT_MAX_SIZE);
        doubleStack.getFirstStack().push(5);
        doubleStack.getFirstStack().push(2);
        doubleStack.getFirstStack().push(8);
        assertEquals(8, doubleStack.getFirstStack().pop());
    }

    public void checksIfTheSecondStackCanHoldMultipleValues() throws StackOverflowException, StackEmptyException {
        IDoubleStack doubleStack = getFactory().makeDoubleStack(DEFAULT_MAX_SIZE);
        doubleStack.getSecondStack().push(5);
        doubleStack.getSecondStack().push(2);
        doubleStack.getSecondStack().push(8);
        assertEquals(8, doubleStack.getFirstStack().pop());
    }

    @Test
    public void checksIfTheTopMethodWorksWithOneObjectForFirstStack() throws StackEmptyException, StackOverflowException {
        IDoubleStack doubleStack = getFactory().makeDoubleStack(DEFAULT_MAX_SIZE);
        doubleStack.getFirstStack().push(3);
        assertEquals(3, doubleStack.getFirstStack().top());
    }

    @Test
    public void checksIfTheTopMethodWorksWithMultipleObjectsForFirstStack() throws StackEmptyException, StackOverflowException {
        IDoubleStack doubleStack = getFactory().makeDoubleStack(DEFAULT_MAX_SIZE);
        doubleStack.getFirstStack().push(5);
        doubleStack.getFirstStack().push(2);
        doubleStack.getFirstStack().push(8);
        assertEquals(8, doubleStack.getFirstStack().top());
    }

    @Test
    public void checksIfTheTopMethodWorksWithOneObjectForSecondStack() throws StackOverflowException, StackEmptyException {
        IDoubleStack doubleStack = getFactory().makeDoubleStack(DEFAULT_MAX_SIZE);
        doubleStack.getSecondStack().push(3);
        assertEquals(3, doubleStack.getSecondStack().top());
    }

    @Test
    public void checksIfTheTopMethodWorksWithMultipleObjectsForSecondStack() throws StackEmptyException, StackOverflowException {
        IDoubleStack doubleStack = getFactory().makeDoubleStack(DEFAULT_MAX_SIZE);
        doubleStack.getSecondStack().push(5);
        doubleStack.getSecondStack().push(2);
        doubleStack.getSecondStack().push(8);
        assertEquals(8, doubleStack.getSecondStack().top());
    }

    @Test
    public void checksIfTheSizeMethodWorksWithZeroObjectForFirstStack() {
        IDoubleStack doubleStack = getFactory().makeDoubleStack(DEFAULT_MAX_SIZE);
        assertEquals(0, doubleStack.getFirstStack().size());
    }

    @Test
    public void checksIfTheSizeMethodWorksWithZeroObjectForSecondStack() {
        IDoubleStack doubleStack = getFactory().makeDoubleStack(DEFAULT_MAX_SIZE);
        assertEquals(0, doubleStack.getSecondStack().size());
    }

    @Test
    public void checksIfTheSizeMethodWorksWithMultipleObjectsForFirstStack() throws StackOverflowException {
        IDoubleStack doubleStack = getFactory().makeDoubleStack(DEFAULT_MAX_SIZE);
        doubleStack.getFirstStack().push(5);
        doubleStack.getFirstStack().push(2);
        doubleStack.getFirstStack().push(8);
        assertEquals(3, doubleStack.getFirstStack().size());
    }

    @Test
    public void checksIfTheSizeMethodWorksWithMultipleObjectsForSecondStack() throws StackOverflowException {
        IDoubleStack doubleStack = getFactory().makeDoubleStack(DEFAULT_MAX_SIZE);
        doubleStack.getSecondStack().push(5);
        doubleStack.getSecondStack().push(2);
        doubleStack.getSecondStack().push(8);
        assertEquals(3, doubleStack.getSecondStack().size());
    }

    @Test
    public void checksIfTheIsEmptyMethodWorksWithZeroObjectsForFirstStack() {
        IDoubleStack doubleStack = getFactory().makeDoubleStack(DEFAULT_MAX_SIZE);
        assertTrue(doubleStack.getFirstStack().isEmpty());
    }

    @Test
    public void checksIfTheIsEmptyMethodWorksWithZeroObjectsForSecondStack() {
        IDoubleStack doubleStack = getFactory().makeDoubleStack(DEFAULT_MAX_SIZE);
        assertTrue(doubleStack.getSecondStack().isEmpty());
    }

    @Test
    public void checksIfTheIsEmptyMethodWorksWithMultipleObjectsForFirstStack() throws StackOverflowException {
        IDoubleStack doubleStack = getFactory().makeDoubleStack(DEFAULT_MAX_SIZE);
        doubleStack.getFirstStack().push(5);
        doubleStack.getFirstStack().push(2);
        doubleStack.getFirstStack().push(8);
        assertFalse(doubleStack.getFirstStack().isEmpty());
    }

    @Test
    public void checksIfTheIsEmptyMethodWorksWithMultipleObjectsForSecondStack() throws StackOverflowException {
        IDoubleStack doubleStack = getFactory().makeDoubleStack(DEFAULT_MAX_SIZE);
        doubleStack.getSecondStack().push(5);
        doubleStack.getSecondStack().push(2);
        doubleStack.getSecondStack().push(8);
        assertFalse(doubleStack.getSecondStack().isEmpty());
    }

    @Test
    public void checksIfTheClearMethodWorksWithZeroObjectsForFirstStack() {
        IDoubleStack doubleStack = getFactory().makeDoubleStack(DEFAULT_MAX_SIZE);
        doubleStack.getFirstStack().clear();
        assertTrue(doubleStack.getFirstStack().isEmpty());
    }

    @Test
    public void checksIfTheClearMethodWorksWithMultipleObjectsForFirstStack() throws StackOverflowException {
        IDoubleStack doubleStack = getFactory().makeDoubleStack(DEFAULT_MAX_SIZE);
        doubleStack.getFirstStack().push(5);
        doubleStack.getFirstStack().push(2);
        doubleStack.getFirstStack().push(8);
        doubleStack.getFirstStack().clear();
        assertTrue(doubleStack.getFirstStack().isEmpty());
    }

    @Test
    public void checksIfTheClearMethodWorksWithZeroObjectsForSecondStack() {
        IDoubleStack doubleStack = getFactory().makeDoubleStack(DEFAULT_MAX_SIZE);
        doubleStack.getSecondStack().clear();
        assertTrue(doubleStack.getSecondStack().isEmpty());
    }

    @Test
    public void checksIfTheClearMethodWorksWithMultipleObjectsForSecondStack() throws StackOverflowException {
        IDoubleStack doubleStack = getFactory().makeDoubleStack(DEFAULT_MAX_SIZE);
        doubleStack.getSecondStack().push(5);
        doubleStack.getSecondStack().push(2);
        doubleStack.getSecondStack().push(8);
        doubleStack.getSecondStack().clear();
        assertTrue(doubleStack.getSecondStack().isEmpty());
    }
    // TODO: add test cases that throw the exceptions.
}
