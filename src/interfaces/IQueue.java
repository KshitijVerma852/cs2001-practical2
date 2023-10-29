package interfaces;

import common.QueueEmptyException;
import common.QueueFullException;

/**
 * Simple queue interface.
 * 
 */
public interface IQueue {

    /**
     * Adds an element to the end of the queue.
     * 
     * @param element the element to be queued
     * @throws QueueFullException if there is no room in the queue for the new element
     */
    void enqueue(Object element) throws QueueFullException;

    /**
     * Removes the element at the head of the queue.
     * 
     * @return the element removed
     * @throws QueueEmptyException if the queue is empty
     */
    Object dequeue() throws QueueEmptyException;

    /**
     * Returns the number of elements in the queue.
     * @return the number of elements in the queue
     */
    int size();

    /**
     * Checks whether the queue is empty.
     * @return true if the queue is empty
     */
    boolean isEmpty();

    /**
     * Removes all elements from the queue.
     */
    void clear();
}
