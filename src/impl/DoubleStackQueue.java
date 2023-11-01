package impl;

import common.QueueEmptyException;
import common.QueueFullException;
import common.StackEmptyException;
import common.StackOverflowException;
import interfaces.IDoubleStack;
import interfaces.IQueue;

public class DoubleStackQueue implements IQueue {
    private final IDoubleStack queue;
    private final int maxSize;

    public DoubleStackQueue(int size) {
        queue = new DoubleStack(size);
        maxSize = size;
    }

    @Override
    public void enqueue(Object element) throws QueueFullException {
        if (queue.getFirstStack().size() == maxSize) {
            throw new QueueFullException();
        } else {
            try {
                queue.getFirstStack().push(element);
            } catch (StackOverflowException ignored) {
            }
        }
    }

    @Override
    public Object dequeue() throws QueueEmptyException {
        try {
            for (int x = 0; x < queue.getFirstStack().size(); x++) {
                Object element = queue.getFirstStack().pop();
                queue.getSecondStack().push(element);
            }
            Object element = queue.getFirstStack().pop();
            queue.getSecondStack().push(element);
        } catch (StackEmptyException | StackOverflowException ignored) {}
        try {
            return queue.getSecondStack().pop();
        } catch (StackEmptyException ignored) {}
        return null;
    }

    @Override
    public int size() {
        return queue.getFirstStack().size() + queue.getSecondStack().size();
    }

    @Override
    public boolean isEmpty() {
        return queue.getFirstStack().isEmpty();
    }

    @Override
    public void clear() {
        queue.getFirstStack().clear();
        queue.getSecondStack().clear();
    }
}
