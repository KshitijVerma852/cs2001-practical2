package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import common.QueueEmptyException;
import common.QueueFullException;
import org.junit.jupiter.api.Test;
import common.AbstractFactoryClient;
import interfaces.IQueue;

/**
 * Tests double stack queue implementation.
 */
public class TestDoubleStackQueue extends AbstractFactoryClient {

    private static final int DEFAULT_MAX_SIZE = 10;

    /**
     * Tests that the factory constructs a non-null object.
     */
    @Test
    public void factoryReturnsNonNullDoubleStackQueue() {
        IQueue queue = getFactory().makeDoubleStackQueue(DEFAULT_MAX_SIZE);
        assertNotNull(queue, "Failure: IFactory.makeDoubleStackQueue returns null, expected non-null object");
    }

    @Test
    public void checksIfTheDequeMethodWorks() throws QueueFullException, QueueEmptyException {
        IQueue queue = getFactory().makeDoubleStackQueue(DEFAULT_MAX_SIZE);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, queue.dequeue());
    }
}
