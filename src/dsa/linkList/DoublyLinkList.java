package dsa.linkList;

import java.util.Collection;

public class DoublyLinkList implements LinkListOperations<Integer> {

    Node head;
    Node tail;

    @Override
    public void add(Integer index, Integer integer) {
        //create new node
        Node newNode = new Node();
        //check head is empty or not
        if (head == null) {
            newNode.data = integer;
            //set head and tail node
            head = tail = newNode;
            head.nextNode = tail;
            head.previousNode = null;
            tail.previousNode = head;
            tail.nextNode = null;
        } else {
            Node tempNode = head;
            if (size()>= index){
                for (Integer i = 0; i < index; i++) {
                    tempNode = tempNode.nextNode;
                }
                //set data in new node
                newNode.data = integer;
                // join new node into that index
                //right node join
                newNode.nextNode = tempNode.nextNode;
                tempNode.nextNode.previousNode = newNode;
                // left node join
                tempNode.nextNode = newNode;
                newNode.previousNode = tempNode;
            }
        }
    }

    @Override
    public void add(Integer integer) {
       //create new node
        Node newNode = new Node();
        //check head is empty or not
        if (head == null) {
            newNode.data = integer;
            //set head and tail node
            newNode.previousNode = null;
            newNode.nextNode = null;
            head = tail = newNode;
        }else {
            //add into last index
            newNode.data = integer;
            tail.nextNode = newNode;
            newNode.nextNode = null;
            newNode.previousNode = tail;
            //assign new tail
            tail = newNode;
        }
    }

    @Override
    public void addAll(Integer index, Collection<Integer> integers) {
        //check given index is valid or not
        if (size() >= index){ //if valid
            Node nodeBeforeIndex;
            Node nodeAfterIndex;
            //find node that is one step before index
            nodeBeforeIndex = head;
            for (Integer i = 0; i<index ;i++){
                nodeBeforeIndex= nodeBeforeIndex.nextNode;
            }
            //find node that is one step after index
            nodeAfterIndex = nodeBeforeIndex.nextNode;
            Node swapNode;
            for (Integer integer : integers){
                swapNode = new Node();
                swapNode.data = integer;
                // add after before node
                swapNode.previousNode = nodeBeforeIndex;
                // assign new before index
                nodeBeforeIndex = swapNode;
            }
            // join middle node
            nodeBeforeIndex.nextNode = nodeAfterIndex;
        }
    }

    @Override
    public void addAll(Collection<Integer> integers) {
            Node newNode;
            for (Integer integer : integers){
               if (head == null){
                   // make node
                   newNode = new Node();
                   newNode.data = integer;
                   newNode.previousNode = null;
                   newNode.nextNode = null;
                   // make new head and tail
                   head = tail = newNode;
               }else {
                   // add items in last
                   newNode = new Node();
                   newNode.data = integer;
                   // add after tail
                   tail.nextNode = newNode;
                   newNode.previousNode = tail;
                   newNode.nextNode = null;
                   //re-assign new tail
                   tail = newNode;
               }

        }
    }

    @Override
    public void AddFirst(Integer integer) {
        //create new node
        Node newNode = new Node();
        newNode.data = integer;
        if (head == null){
            newNode.nextNode = null;
            newNode.previousNode = null;
            head = tail = newNode;

        }else {
            // add new node before head
            head.previousNode = newNode;
            newNode.nextNode = head;
            // re-assign new head
            head = newNode;
        }
    }

    @Override
    public void AddLast(Integer integer) {
        //create new node
        Node newNode = new Node();
        newNode.data = integer;
        if (tail == null){
            newNode.nextNode = null;
            newNode.previousNode = null;
            head = tail = newNode;

        }else {
            // add new node after tail
            tail.nextNode = newNode;
            newNode.previousNode = tail;
            // re-assign new tail
            tail = newNode;
        }
    }

    @Override
    public void clear() {
        //make head and tail null so after that can not access
        head = tail = null;
    }

    @Override
    public Boolean contains(Object o) {
        Boolean result = false;
        if (head != null){
            Node temNode = head;
            while (temNode.nextNode != null){
                if (temNode.data.equals(o)){
                    result = true;
                    break;
                }
                // update temp node
                temNode = temNode.nextNode;
            }
            //also check in tail node
            if (tail.data.equals(o)){
                result = true;
            }
        }
        return result;
    }

    @Override
    public Integer getElement(Integer index) {
        Integer element = null;
        if (size()>= index){
            Node tempNode = head;
            for (Integer i = 0 ; i<index ;i++){
                // swap node
                tempNode = tempNode.nextNode;
            }
            // assign element of that index
            element = tempNode.data;
        }
        return element;
    }

    @Override
    public Integer getFirst() {
        return head != null ? head.data:null;
    }

    @Override
    public Integer getLast() {
        return tail != null ? tail.data : null;
    }

    @Override
    public Integer indexOf(Object o) {
        Integer index = -1;
        Boolean isFound = false;
        Node tempNode = head;
        while (tempNode.nextNode != null){
            index++;
            if (tempNode.data.equals(o)){
                //update is found
                isFound = true;
                break;
            }
        }
        return isFound ? index : -1;
    }

    @Override
    public Integer peekFirst() {
        return head != null ? head.data : null;
    }

    @Override
    public Integer peekLast() {
        return tail != null ? tail.data: null;
    }

    @Override
    public void remove(Integer index) {
        // check index is valid or not
        if (size() >= index){
            //find node for remove
            Node tempNode = head;
            for (Integer i = 0 ; i <= index ; i++){
                tempNode = tempNode.nextNode;
            }
            // skip middle node
            Node middleNode = tempNode.nextNode;
            Node lastJoinNode = middleNode.nextNode;
            tempNode.nextNode = lastJoinNode;
            lastJoinNode.previousNode = tempNode;
        }
    }

    @Override
    public void removeFirst() {
        if (head != null){
            head = head.nextNode;
            head.previousNode = null;
        }
    }

    @Override
    public void removeLast() {
        if (tail != null){
            Node nodeBeforeTail = tail.previousNode;
            // re-assign tail
            tail = nodeBeforeTail;
            tail.nextNode = null;
        }
    }

    @Override
    public Integer size() {
        Integer count = 0;
        if (head !=null){
            Node tempNode = head;
            while (tempNode.nextNode != null){
                count++;
                tempNode = tempNode.nextNode;
            }
            //also count tail
            count++;
        }
        return count;
    }

    @Override
    public void display() {
        Node tempNode = head;
        while (tempNode.nextNode != null){
            System.out.printf("%d\t",tempNode.data);
            // change temp node
            tempNode = tempNode.nextNode;
        }
        // also display tail
        if (head != tail){
            System.out.printf("%d\t",tail.data);
        }
    }

    private class Node {
        Integer data;
        Node previousNode; // store reference of previous node
        Node nextNode;  // store reference of next node
    }
}
