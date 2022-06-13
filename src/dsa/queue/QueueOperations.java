package dsa.queue;

public interface QueueOperations<T> {
    void enqueue(T t);

    void dequeue();

    Boolean isEmpty();

    Boolean isFull();

    void display(T[] t);

    T getFont();

    T getRear();

    void playLoop();

}
