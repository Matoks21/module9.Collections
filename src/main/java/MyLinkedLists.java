package main.java;

public class MyLinkedLists {
    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        System.out.println("Size LinkedList : " + linkedList.size());
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(8);
        System.out.println(linkedList.getLastNode());
        System.out.println("Size LinkedList : " + linkedList.size());
        System.out.println("Getting the element, if the index = 7,  : " + linkedList.get(7));
        linkedList.remove(0);
        System.out.println(linkedList);
        linkedList.clear();
        System.out.println("Size LinkedList : " + linkedList.size());

    }
}