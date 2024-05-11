import java.util.Hashtable;
import java.util.Random;

public class Main{
    public static Random rand = new Random();
    public static void main(String[] args){
        MyHashTable<MyTestingClass, Students> table = new MyHashTable<MyTestingClass, Students>();
//        for (int i = 1; i < 10000; i++) {
//            String value = "value_";
//            MyTestingClass key = new MyTestingClass("key_" + random.nextInt(100));
//            jobTable.put(key, value);
//        }
//        for(int i =0;i<jobTable.getM();i++) {
//            System.out.println(jobTable.countElements(i));
//        }
    BST<Integer, String> bst = new BST<>();
        bst.put(50, "A");
        bst.put(30, "AA");
        bst.put(70, "AAA");
        bst.put(20, "AAAA");
        bst.put(40, "AAAAA");
        bst.put(60, "AAAAAA");
        bst.put(80, "AAAAAAA");

        System.out.println("Value for key 40: " + bst.get(40));
        System.out.println("Value for key 60: " + bst.get(60));

        bst.delete(30);
        System.out.println("Contains key 30: " + bst.get(Integer.valueOf(30)));

        for (Integer key : bst){
            System.out.println("Key: " + key + " Value: " + bst.get(key));
            System.out.println(bst.size(bst.getNode(key)));
        }
        Integer key = null;
        System.out.println("Size of root node: " + bst.size(bst.getNode(key)));
    }
    public static String randomString(int length){
        String charachters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            result.append(charachters.charAt(rand.nextInt(charachters.length())));
        }
        return result.toString();
    }
}