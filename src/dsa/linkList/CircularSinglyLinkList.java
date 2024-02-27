package dsa.linkList;

import java.util.Collection;

public class CircularSinglyLinkList implements LinkListOperations<Integer>{

    private class Node{
        Integer data;

        Node nextNode;
    }

    Node head = null;

    Node  tail = null;
    @Override
    public void add(Integer index, Integer integer) {
        Node newNode = new Node();
        if (head == null){
            //assign value to node
            newNode.data = integer;
            newNode.nextNode = null;
            //first time head and tail value
            head=tail= newNode;
            // make circular node
            tail.nextNode = head;
        }else {
            Node tempNode = head;
            for (Integer i = 0;i<index;i++){
                tempNode = tempNode.nextNode;
            }
            newNode.data = integer;
            //set temp node for current node
            tempNode.nextNode = newNode;
            //join node
            newNode.nextNode = tempNode.nextNode.nextNode;
        }
    }

    @Override
    public void add(Integer integer) {
        Node newNode = new Node();
        if (head == null){
            //set newNode data
            newNode.data = integer;
            head = tail = newNode;
            //make circular
            tail.nextNode = head;
        }
        else {
            //add last to newNode
            newNode.data = integer;
            //add newNode after last newNode (tail Node)
            tail.nextNode = newNode;
            // make circular link by joining new newNode and head Node
            newNode.nextNode = head;
        }
    }

    @Override
    public void addAll(Integer index, Collection<Integer> integers) {
        if (isValidIndex(index)){
            Node tempNode = head;
            for (Integer i = 0;i<index-1 ;i++){
                tempNode = tempNode.nextNode;
            }
            // let middle node after tempNode
            Node middleNode = tempNode.nextNode;
            //let's add all node from collection
            Node newNode ;
            for (Integer data : integers){
                newNode = new Node();
                newNode.data = data;
                tempNode.nextNode = newNode;
                tempNode = tempNode.nextNode;
            }
            // last node tempNode to middle
            tempNode.nextNode = middleNode;
        }
     }

    @Override
    public void addAll(Collection<Integer> integers) {
        //add all newNode at last of tail node
        Node newNode;
        for (Integer data : integers){
            //create newNode one by one
            newNode = new Node();
            //assign data
            newNode.data = data;
            if (head == null){
                //make head and tail newNode with new newNode
                head = tail = newNode;
                tail.nextNode = head;
            }else {
                // add after tail head
                tail.nextNode = newNode;
                tail = newNode;
                //make circular (join to head)
                newNode.nextNode = head;
            }
        }
    }

    @Override
    public void AddFirst(Integer integer) {
        Node newNode = new Node();
        newNode.data = integer;
        if (head == null){
            //assign new all 
            head = tail = newNode;
            // make circle
            tail.nextNode = head;
        }else {
            //make new node as head
            newNode.nextNode = head;
            head = newNode;
            tail.nextNode = head;
        }
    }

    @Override
    public void AddLast(Integer integer) {
        Node newNode = new Node();
        newNode.data = integer;
        if (tail == null){
            head = tail = newNode;
            tail.nextNode = head;
        }else {
            tail.nextNode = newNode;
            newNode.nextNode = head;
            tail = newNode;
        }
    }

    @Override
    public void clear() {
        head = tail = null;
    }

    @Override
    public Boolean contains(Object o) {
        Integer data = 0;
        Boolean result = false;
        if (head != null){
            Node swapNode = head;
            while (swapNode.nextNode != head){
                if (swapNode.data == data){
                    result = true;
                    break;
                }
                swapNode = swapNode.nextNode;
            }
        }
        return result;
    }

    @Override
    public Integer getElement(Integer index) {
        if (isValidIndex(index)){
            Node swapNode = head;
            for (Integer i = 0 ;i < index ;i++){
                swapNode = swapNode.nextNode;
            }
            return swapNode.data;
        }
        return null;
    }

    @Override
    public Integer getFirst() {
        if (head != null){
            return head.data;
        }else {
            return null;
        }
    }

    @Override
    public Integer getLast() {
        if (tail !=null){
            return tail.data;
        }else {
            return null;
        }
    }

    @Override
    public Integer indexOf(Object o) {
        return null;
    }

    @Override
    public Integer peekFirst() {
        if (head != null){
            return head.data;
        }else {
            return null;
        }
    }

    @Override
    public Integer peekLast() {
        if (tail !=null){
            return tail.data;
        }else {
            return null;
        }
    }

    @Override
    public void remove(Integer index) {
        if (Boolean.TRUE.equals(isValidIndex(index))){
            // make temp node
            Node tempNode = head;
            for (int i = 0;i < index ; i++){
                tempNode = tempNode.nextNode;
            }
            // skip one index(middle)
            Node middleNode = tempNode.nextNode;
            tempNode.nextNode = middleNode.nextNode;
        }
    }

    @Override
    public void removeFirst() {
        if (head !=null){
            // assign new head
            head = head.nextNode;
            // make new join
            tail.nextNode = head;
        }
    }

    @Override
    public void removeLast() {
        if (tail != null){
            Node temp = head;
            while (temp.nextNode != null){
                temp = temp.nextNode;
            }
            // make new tail as temp node (one before tail node is temp)
            tail = temp;
            // make re join to head
            tail.nextNode = head;
        }
    }

    @Override
    public Integer size() {
        if (head == null){
            return 0;
        }else {
            Integer count = 0;
            Node temp = head;
            while (temp.nextNode != tail){
                count++;
                temp = temp.nextNode;
            }
            return count + 1; // temp does not count tail so add 1
        }
    }

    @Override
    public void display() {

    }

    private Boolean isValidIndex(Integer index){
        if (size() >= index){
            return Boolean.TRUE;
        }else {
            return Boolean.FALSE;
        }
    }
}
