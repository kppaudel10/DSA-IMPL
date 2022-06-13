package dsa.queue;

import java.util.Scanner;

public class Queue implements QueueOperations<Integer>{

    private Integer[] queue;
    //set queue size
    Queue(Integer queueSize){
        this.queue = new Integer[queueSize];
    }
    Queue(){

    }
    private Integer font = 0;

    private Integer rear = -1;

    @Override
    public void enqueue(Integer integer) {
        if (font == 0){
            rear +=1;
        }
        //check queue is full or not
        if (isFull()){
            System.out.println("Queue is full");
        }else {
            queue[font++] = integer;
        }
    }

    @Override
    public void dequeue() {
        //check queue is empty or not
        if (isEmpty()){
            System.out.println("Queue is empty");
        }else {
            rear ++;
        }
    }

    @Override
    public Boolean isEmpty() {
        if (font < 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Boolean isFull() {
        if (font == queue.length -1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void display(Integer[] t) {
        for(Integer integer : t){
            System.out.printf("%d\t",integer);
        }
    }

    @Override
    public Integer getFont() {
        if (!isEmpty()){
            return queue[font -1];
        }else {
            return null;
        }
    }

    @Override
    public Integer getRear() {
        if (!isEmpty()){
            return queue[rear];
        }else {
            return null;
        }
    }

    @Override
    public void playLoop() {
        Integer choice = 0;
        Integer queueSize = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Queue Size");
        queueSize = scanner.nextInt();;
        this.queue =new  Integer[queueSize];
        while (choice != 8){
            System.out.println("\nChoose following Operations");
            System.out.println("1.Enqueue");
            System.out.println("2.Queue");
            System.out.println("3.IsFull");
            System.out.println("4.IsEmpty");
            System.out.println("5.GetFont");
            System.out.println("6.GetRear");
            System.out.println("7.Display");
            System.out.println("8.Exit");
            System.out.printf("Choice:\t");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.printf("Enter value:\t");
                    Integer value = scanner.nextInt();
                    enqueue(value);
                    break;
                case 2 :
                    dequeue();
                    break;
                case 3:
                    System.out.println(isFull());
                    break;
                case 4:
                    System.out.println(isEmpty());
                    break;
                case 5:
                    System.out.println("Font Value: "+getFont());
                    break;
                case 6:
                    System.out.println("Rear Value: "+ getRear());
                    break;
                case 7:
                    display(queue);
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
