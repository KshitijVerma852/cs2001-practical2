package impl;

import common.StackOverflowException;
import interfaces.IDoubleStack;
import interfaces.IStack;

public class DoubleStack implements IDoubleStack {
    IStack firstStack;
    IStack secondStack;

    public DoubleStack(int maxSize) {
        Object[] elements = new Object[maxSize];
        firstStack = new Stack(elements, true);
        secondStack = new Stack(elements, false);
    }

    @Override
    public IStack getFirstStack() {
        return firstStack;
    }

    @Override
    public IStack getSecondStack() {
        return secondStack;
    }
}
