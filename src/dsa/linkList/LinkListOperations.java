package dsa.linkList;

import java.util.Collection;

public interface LinkListOperations<E>{

    void add(Integer index,E e);

    void add(E e);

    void addAll(Integer index, Collection<E> eCollection);

    void addAll(Collection<E> eCollection);

    void AddFirst(E e);

    void AddLast(E e);

    void clear();

    Boolean contains(Object o);

    E getElement(Integer index);

    E getFirst();

    E getLast();

    Integer indexOf(Object o);

    E peekFirst();

    E peekLast();

    void remove(Integer index);

    void removeFirst();

    void removeLast();

    Integer size();

    void display();
}
