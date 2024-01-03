package main.java;


public class MyArrayLists {
    public static void main(String[] args) {
        MyArrayList<Integer> arrayList = new MyArrayList<>(new Integer[]{1, 2, 3});
        System.out.println("ArrayList size : "+arrayList.size() + " " + arrayList);
        arrayList.add(11);
        arrayList.add(12);
        arrayList.add(13);
        arrayList.add(90);
        arrayList.add(15);
        arrayList.add(16);
        arrayList.add(11);
        arrayList.add(12);
        System.out.println("ArrayList size : " + arrayList.size() + " " + arrayList);
        arrayList.remove(2);
        System.out.println("ArrayList size :" + arrayList.size() + " " + arrayList);
        arrayList.add(13);
        arrayList.add(14);
        arrayList.add(15);
        arrayList.add(16);
        arrayList.add(14);
        System.out.println(arrayList);
        System.out.println("Element with index=11 , " + arrayList.get(10));
        arrayList.remove(12);
        System.out.println(arrayList);
        System.out.println("Element with index=11 ,  " + arrayList.get(11));
        arrayList.size();
        System.out.println("ArrayList size :" + arrayList.size());
        arrayList.clear();
        System.out.println(arrayList);
        System.out.println("ArrayList size :" + arrayList.size());
        arrayList.add(13);
        arrayList.add(14);
        arrayList.add(15);
        arrayList.add(16);
        System.out.println(arrayList);
        System.out.println("ArrayList size :" + arrayList.size());
    }
}