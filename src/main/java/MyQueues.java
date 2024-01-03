package main.java;

public class MyQueues {
    public static void main(String[] args) {
        MyQueue<String> stringMyQueue = new MyQueue<>();
        stringMyQueue.add("1");
        stringMyQueue.add("2");
        stringMyQueue.add("3");
        stringMyQueue.add("4");
        stringMyQueue.add("5");
        System.out.println(stringMyQueue);
        System.out.println("Collection size before change : " + stringMyQueue.size());
        System.out.println("First element Queue : " + stringMyQueue.peek());
        stringMyQueue.remove(3);
        System.out.println("Element delete  (index=3), collection size = " + stringMyQueue.size());
        System.out.println(stringMyQueue);
        System.out.println("First element Queue, and deleting  : " + stringMyQueue.poll() + " " + stringMyQueue);
        System.out.println("First element Queue : "+ stringMyQueue.peek());
        stringMyQueue.clear();
        System.out.println("Queue is clean  " + stringMyQueue);

    }

}