public class MyHashTable<K ,V> {
    private class HashNode<K, V> {
        private final K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    public void increaseCapacity() {
        M = M * 2;
        HashNode<? , ?>[] temp = chainArray;
        chainArray = new HashNode[M];
        for(int i = 0 ; i < temp.length ; i++) {
            if(temp[i] != null) {
                HashNode<? , ?> node = temp[i];
                while(node != null) {
                    put((K) node.key , (V) node.value);
                    node = node.next;
                }
            }
        }
    }


    private HashNode<K, V> []chainArray;
    private int M = 11;
    private int size;

    public void MyHashTable(){
        this.chainArray = (HashNode<K, V>[]) new HashNode[M];
        this.size = 0;
    }
    public void MyHashTable(int M){
        this.M = M;
        this.chainArray = (HashNode<K, V>[]) new HashNode[M];
        this.size = 0;
    }
    public int getM(){
        return this.M;
    }
    private int hash(K key){
        return (key.hashCode() & 0xfffffff) % M;
    }
    public void put(K key , V value) {
        if((double) size / M > 0.25) {
            increaseCapacity();
        }
        int index = hash(key);
        HashNode<K , V> newNode = new HashNode<>(key , value);
        this.chainArray = (HashNode<K, V>[]) new HashNode[M];
        this.size = 0;
        if(chainArray[index] == null) {
            chainArray[index] = newNode;
            size++;
            return;
        }
        else {
            HashNode<? , ?> temp = chainArray[index];
            while(temp.next != null) {
                temp = temp.next;
            }
            temp= temp.next;
            temp = newNode;
            size++;
            return;
        }
    }
    public V remove(K key){
        int ind = hash(key);
        HashNode<K, V> node = chainArray[ind];
        HashNode<K, V> last = null;
        while (node != null){
            if (node.key.equals(key)){
                if (last == null){
                    chainArray[ind] = node.next;
                }
                else{
                    last.next = node.next;
                }
                size--;
                return node.value;
            }
            last = node;
            node = node.next;
        }
        return null;
    }

    public int countElements(int index){
        int count = 0;
        HashNode<?,?> temp = chainArray[index];
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    public boolean contains(V key){
        for (int i = 0; i < M; i++) {
            HashNode<K, V> node = chainArray[i];
            while (node != null){
                if (node.key.equals(key)){
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }
    public K getKey(V value){
        for (int i = 0; i < M; i++) {
            HashNode<K, V> node = chainArray[i];
            while (node != null){
                if (node.value == value){
                    return node.key;
                }
                node = node.next;
            }
        }
        return null;
    }
}