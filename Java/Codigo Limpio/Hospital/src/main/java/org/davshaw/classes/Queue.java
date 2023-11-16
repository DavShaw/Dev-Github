package org.davshaw.classes;

public abstract class Queue
{
    protected abstract Boolean isEmpty();

    protected abstract Boolean isFull();

    protected abstract Integer size();

    protected abstract void clear();

    protected abstract void enqueue(Request request);

    protected abstract Request dequeue();
    
    protected abstract void sort();

}
