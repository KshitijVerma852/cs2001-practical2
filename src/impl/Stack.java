package impl;

import common.StackEmptyException;
import common.StackOverflowException;
import interfaces.IStack;

public class Stack implements IStack {
    private final Object[] sharedArray;
    private final int maxSize;
    private int size;
    private final int bottomElementIndex;

    public Stack(Object[] elements, boolean isFirstStack) {
        sharedArray = elements;
        maxSize = elements.length / 2;
        size = 0;
        bottomElementIndex = isFirstStack ? 0 : maxSize;
    }

    @Override
    public void push(Object element) throws StackOverflowException {
        if (size == maxSize) {
            throw new StackOverflowException();
        } else {
            sharedArray[size + bottomElementIndex] = element;
            size++;
        }
    }

    @Override
    public Object pop() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException();
        } else {
            size--;
            Object ans = sharedArray[size + bottomElementIndex];
            sharedArray[size + bottomElementIndex] = null;
            return ans;
        }
    }

    @Override
    public Object top() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException();
        } else {
            return sharedArray[bottomElementIndex + size - 1];
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }
}