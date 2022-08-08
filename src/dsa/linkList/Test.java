package dsa.linkList;

import java.util.ArrayList;
import java.util.Collection;

public class Test {
    public static void main(String[] args) {
//        SinglyLinkList singlyLinkList = new SinglyLinkList();
        CircularSinglyLinkList circularSinglyLinkList = new CircularSinglyLinkList();

        Collection<Integer> integers = new ArrayList<>();
        integers.add(23);
        integers.add(56);
        integers.add(347);
        integers.add(200);
        integers.add(123);
        circularSinglyLinkList.addAll(integers);

        Collection<Integer> integers1 = new ArrayList<>();
        integers1.add(800);
        integers1.add(900);
        circularSinglyLinkList.addAll(3,integers1);

        circularSinglyLinkList.size();
        circularSinglyLinkList.AddFirst(100);
        circularSinglyLinkList.AddLast(900);
        circularSinglyLinkList.add(45);
        circularSinglyLinkList.add(4,340);
        System.out.println(circularSinglyLinkList.getFirst());
        System.out.println( circularSinglyLinkList.getLast());
        System.out.println(circularSinglyLinkList.peekFirst());
        System.out.println(circularSinglyLinkList.peekLast());
        circularSinglyLinkList.remove(5);
        circularSinglyLinkList.removeLast();
        System.out.println(circularSinglyLinkList.getElement(5));
        System.out.println(circularSinglyLinkList.getLast());
    }
}
