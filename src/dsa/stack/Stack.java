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
        if (top == -1)
            return true;
        else
            return false;

    }

    @Override
    public Boolean isFull() {
        if (stack.length-1 == top)
            return true;
        else
            return false;

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
        for (Integer i = 0 ;i<top ;i++){
            System.out.printf("%d\t",stack[i]);
        }
    }
}
