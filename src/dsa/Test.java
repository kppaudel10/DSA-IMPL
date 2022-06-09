package dsa;

import dsa.stack.Stack;

public class Test {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.setStackSize(4);
        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());
        stack.push(23);
        stack.push(245);
        stack.display();
    }
}
