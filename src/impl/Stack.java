package impl;

import common.StackEmptyException;
import common.StackOverflowException;
import interfaces.IStack;

public class Stack implements IStack {
    private final Object[] sharedArray;
    private final int maxSize;
    private int numOfElements;
    private final int bottomElementIndex;

    public Stack(Object[] elements, boolean isFirstStack) {
        sharedArray = elements;
        maxSize = elements.length / 2;
        numOfElements = 0;
        bottomElementIndex = isFirstStack ? 0 : maxSize;
    }

    @Override
    public void push(Object element) throws StackOverflowException {
        if (numOfElements == maxSize) {
            throw new StackOverflowException();
        } else {
            sharedArray[numOfElements + bottomElementIndex] = element;
            numOfElements++;
        }
    }

    @Override
    public Object pop() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException();
        } else {
            numOfElements--;
            Object ans = sharedArray[numOfElements + bottomElementIndex];
            sharedArray[numOfElements + bottomElementIndex] = null;
            return ans;
        }
    }

    @Override
    public Object top() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException();
        } else {
            return sharedArray[bottomElementIndex + numOfElements - 1];
        }
    }

    @Override
    public int size() {
        return numOfElements;
    }

    @Override
    public boolean isEmpty() {
        return numOfElements == 0;
    }

    @Override
    public void clear() {
        numOfElements = 0;
    }
}