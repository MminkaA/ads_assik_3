import java.util.Hashtable;
import java.util.Random;

public class Main {
    public static Random random = new Random();
    public static void main(String[] args) {
        MyHashTable<MyTestingClass , Students> table =  new MyHashTable<MyTestingClass , Students>();
        BST<Integer, String> bst = new BST<>();
        bst.put(50, "A");
        bst.put(30, "AA");
        bst.put(70, "AAA");
        bst.put(20, "AAAA");
        bst.put(40, "AAAAA");
        bst.put(60, "AAAAAA");
        bst.put(80, "AAAAAAA");
        System.out.println(bst.get(40));
        System.out.println(bst.get(60));
        bst.delete(30);
        System.out.println(bst.contains(30));

        for (Integer key : bst) {
            System.out.println(key + " " + bst.get(key));
        }
    }
    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i < length ; i++) {
            result.append(characters.charAt(random.nextInt(characters.length())));
        }
        return result.toString();
    }

}