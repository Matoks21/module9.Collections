package main.java;

public class MyHashMaps {
    public static void main(String[] args) {
        MyHashMap<Integer, String> hashMap = new MyHashMap<>();
        hashMap.put(0, "1");
        hashMap.put(1, "2");
        hashMap.put(2, "3");
        hashMap.put(3, "4");
        hashMap.put(4, "5");
        hashMap.put(5, "6");
        hashMap.put(6, "7");
        hashMap.put(7, "8");
        hashMap.put(8, "9");
        hashMap.put(9, "10");
        hashMap.put(10, "11");
        hashMap.put(11, "12");
        hashMap.put(12, "13");
        hashMap.put(13, "14");
        hashMap.put(14, "15");
        hashMap.put(1, "16");
        hashMap.put(16, "17");
        hashMap.put(17, "18");
        hashMap.put(17, "19");
        System.out.println(hashMap);
        System.out.println("HashMap size : " + hashMap.size());
        System.out.println("Getting the value by key, if the key = 12, the value =" + hashMap.get(12));
        hashMap.remove(2);
        System.out.println(hashMap);
        hashMap.clear();
        System.out.println(hashMap);
    }
}
