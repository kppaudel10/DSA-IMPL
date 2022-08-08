package dsa.linkList;

import java.util.Collection;

public class SinglyLinkList implements LinkListOperations<Integer> {

    /*
   make node for link list
    */
    private class Node {
        Integer data; //value
        Node nextNode; //next node
    }

    Node head;
    Node tail;

    @Override
    public void add(Integer index, Integer integer) {
        //set data
        Node node = new Node();
        node.data = integer;
        // if head is null then set head and tail to current node
        if (isHeadNodeEmpty()) {
            head = tail = node;
            node.nextNode = null;
        } else {
            Node tempNode = head;
            for (Integer i = 0; i < index - 1; i++) {
                tempNode = tempNode.nextNode;
            }
            //temp node next has another node
            Node nextNode;
            if (tempNode.nextNode != null) {
                nextNode = tempNode.nextNode;
                tempNode.nextNode = node;
                //add link to the next node
                node.nextNode = nextNode;
            } else {
                tempNode.nextNode = node;
                node.nextNode = null;
                tail = node;
            }

        }
    }

    @Override
    public void add(Integer integer) {
        //create new node
        Node node = new Node();
        //set data
        node.data = integer;
        node.nextNode = null;
        //for first insert
        if (isHeadNodeEmpty()) {
            //set head and tail
            head = tail = node;
        } else {
            // join into tail
            tail.nextNode = node;
            //change tail node
            tail = node;
        }
    }

    @Override
    public void addAll(Integer index, Collection<Integer> integers) {
        if (size() >= index){
            Node swapNode = head;
            for (Integer i = 0;i<index-1;i++){
                swapNode = swapNode.nextNode;
            }
            // get middle node
            Node middleNode = swapNode.nextNode;
            //add each node one by one to swap node
            Node newNode;
            for (Integer data : integers){
                newNode = new Node();
                newNode.data = data;
              swapNode.nextNode = newNode;
              swapNode = newNode;
            }
            // join rest of node
            swapNode.nextNode = middleNode;
        }
    }

    @Override
    public void addAll(Collection<Integer> integers) {
        //make numbers of node based on collection
        for (Integer i : integers) {
            if (tail == null) {
                Node node = new Node();
                node.data = i;
                //set into head and tail
                head = tail = node;
            } else {
                Node node = new Node();
                node.data = i;
                node.nextNode = null;
                //set it to tail next node
                tail.nextNode = node;
                // change tail node
                tail = node;
            }
        }
    }

    @Override
    public void AddFirst(Integer integer) {
        Node node = new Node();
        node.data = integer;
        node.nextNode = null;
        //check head is null or not
        if (isHeadNodeEmpty()) {
            head = tail = node;
        } else {
            // set before head
            node.nextNode = head;
            // change head
            head = node;
        }
    }

    @Override
    public void AddLast(Integer integer) {
        // check head is null or not
        Node node = new Node();
        node.data = integer;
        node.nextNode = null;
        if (head == null) {
            head = tail = node;
        } else {
            tail.nextNode = node;
            //changes tail
            tail = node;
        }
    }

    @Override
    public void clear() {
        //make tail and head to null
        head = tail = null;
    }

    @Override
    public Boolean contains(Object o) {
        Integer integer = (Integer) o;
        Boolean result = false;

        Node tempNode = head;
        while (tempNode.nextNode != null) {
            if (tempNode.data == integer) {
                result = true;
            }
            tempNode = tempNode.nextNode;
        }
        return result;
    }

    @Override
    public Integer getElement(Integer index) {
        Integer integer = null;
        if (head != null) {
            Node tempNode = head;
            for (Integer i = 0; i < index; i++) {
                tempNode = tempNode.nextNode;
            }
            integer = tempNode.data;
        }
        return integer;
    }

    @Override
    public Integer getFirst() {
        Integer firstValue = null;
        if (head != null){
            firstValue = head.data;
        }
        return firstValue;
    }

    @Override
    public Integer getLast() {
        Integer lastValue = null;
        if (tail !=null){
            lastValue = tail.data;
        }
        return lastValue;
    }

    @Override
    public Integer indexOf(Object o) {
        Integer index = -1;
        if (head != null){
            Integer count = 0;
            Node tempNode = head;
            while (tempNode.nextNode !=null){
                if (tempNode.data == o){
                    index = count;
                }
                count++;
                tempNode = tempNode.nextNode;
            }
        }
        return index;
    }

    @Override
    public Integer peekFirst() {
        Integer firstValue = null;
        if (head != null){
            firstValue = head.data;
        }
        return firstValue;
    }

    @Override
    public Integer peekLast() {
        Integer lastValue = null;
        if (tail != null){
            lastValue = tail.data;
        }
        return lastValue;
    }

    @Override
    public void remove(Integer index) {
        //check that index is valid or not
        Integer size = size();
        if (index < size){
            Integer count =0;
            Node tempNode = head;
            while (count < index-1){
                count++;
                tempNode = tempNode.nextNode;
            }
            Node needConnectNode = tempNode.nextNode.nextNode;
            tempNode.nextNode = needConnectNode; 
        }
    }

    @Override
    public void removeFirst() {
        if (head != null){
            head = head.nextNode;
        }
    }

    @Override
    public void removeLast() {
        if (tail.nextNode != null){
            Node tempNode = head;
            while (tempNode.nextNode != null){
                tempNode = tempNode.nextNode;
            }
            //change tail
            tail = tempNode;
            tail.nextNode = null;
        }
    }

    @Override
    public Integer size() {
        Integer size = 0;
        if (head != null){
            Node tempNode = head;
            while (tempNode.nextNode !=null){
                size++;
                tempNode = tempNode.nextNode;
            }
        }
        return size;
    }

    private Boolean isHeadNodeEmpty(){
        if (head == null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void display() {
        System.out.println("Choose Operations:");
        System.out.println("1-> ");
    }
}
