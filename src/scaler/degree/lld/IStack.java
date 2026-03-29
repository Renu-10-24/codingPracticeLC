package scaler.degree.lld;

import java.util.EmptyStackException;

interface IStack<T>{
    public T pop() throws EmptyStackException;
    public T peek();
    public boolean isEmpty();
    public void resize();
}