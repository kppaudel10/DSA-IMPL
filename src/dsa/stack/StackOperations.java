package dsa.stack;

public interface StackOperations<T> {
    void setStackSize(Integer integer);

    void push(T t);

    void pop();

    Boolean isEmpty();

    Boolean isFull();

    T peek();

    void display();
}
