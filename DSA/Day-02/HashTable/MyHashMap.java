import java.util.LinkedList;

public class MyHashMap {
 
    static class Node {
        int key, value;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 1000;
    private LinkedList<Node>[] map;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        map = new LinkedList[SIZE];
    }

    private int getIndex(int key) {
        return key % SIZE;
    }

    private Node getNode(int key, int index) {
        if (map[index] == null) return null;
        for (Node node : map[index]) {
            if (node.key == key) return node;
        }
        return null;
    }

    public void put(int key, int value) {
        int index = getIndex(key);
        if (map[index] == null)
            map[index] = new LinkedList<>();

        Node node = getNode(key, index);
        if (node != null) {
            node.value = value; // update
        } else {
            map[index].add(new Node(key, value)); // insert
        }
    }

    public int get(int key) {
        int index = getIndex(key);
        Node node = getNode(key, index);
        return node == null ? -1 : node.value;
    }

    public void remove(int key) {
        int index = getIndex(key);
        if (map[index] == null) return;
        map[index].removeIf(node -> node.key == key);
    }

    public static void main(String[] args) {
        MyHashMap myMap = new MyHashMap();
        myMap.put(1, 100);
        myMap.put(2, 200);
        myMap.put(1001, 999); 

        System.out.println("Get key 1: " + myMap.get(1));     // 100
        System.out.println("Get key 2: " + myMap.get(2));     // 200
        System.out.println("Get key 1001: " + myMap.get(1001)); // 999

        myMap.remove(1);
        System.out.println("After removing key 1: " + myMap.get(1)); // -1
    }
}
