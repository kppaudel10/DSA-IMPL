package dsa.stack;

public class Stack implements StackOperations<Integer> {
    private Integer top = -1;
   private Integer[] stack;
    @Override
    public void setStackSize(Integer integer) {
        stack = new Integer[integer];
    }

    @Override
    public void push(Integer integer) {
        if (stack.length-1 == top)
            System.out.println("StackOverFlow");
        else
            stack[++top] = integer;

    }

    @Override
    public void pop() {
        if (top == -1){
            System.out.println("StackUnderFlow");
        }else {
            top--;
        }
    }

    @Override
    public Boolean isEmpty() {
        return top == -1;

    }

    @Override
    public Boolean isFull() {
        return stack.length - 1 == top;

    }

    @Override
    public Integer peek() {
        if (top == -1)
            return -1;
        else
        return stack[top];
    }

    @Override
    public void display() {
        for (int i = 0 ;i<top ;i++){
            System.out.printf("%d\t",stack[i]);
        }
    }
}
