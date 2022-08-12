package dsa;

import dsa.linkList.DoublyLinkList;

public class Test {
    public static void main(String[] args) {
        DoublyLinkList doublyLinkList = new DoublyLinkList();
        doublyLinkList.add(23);
        doublyLinkList.add(245);
        doublyLinkList.add(45);
        doublyLinkList.add(1,400);
        doublyLinkList.add(34);
    }
}
