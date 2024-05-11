import java.util.Iterator;
public class MyArrayList<T extends  Comparable<T>> implements MyList<T>{
    private Object[] arr;
    private int length = 0;
    private static final int DEFAULT_CAPACITY = 10;


    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        arr = new Object[initialCapacity];
    }

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
        length = 0;
    }


    private void increaseCapacity() {
        Object[] temp = new Object[arr.length * 2];
        System.arraycopy(arr, 0, temp, 0, arr.length);
        arr = temp;
    }


    private void checkCap(int index) {
        if(index < 0|| index >= length)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + length);
    }

    @Override
    public void add(T item) {
        if (length == arr.length) {
            increaseCapacity();
        }
        arr[length++] = item;
    }

    @Override
    public void set(int index, T item) {
        checkCap(index);
        arr[index] = item;
    }

    @Override
    public void add(int index, T item) {
        checkCap(index);
        if (length == arr.length) {
            increaseCapacity();
        }
        System.arraycopy(arr, index, arr, index + 1, length - index);
        arr[index] = item;
        length++;
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        checkCap(index);
        return (T) arr[index];
    }

    @Override
    public T getFirst() {
        if(length == 0){
            throw new IndexOutOfBoundsException("List is empty");
        }
        return (T) arr[0];
    }

    @Override
    public T getLast() {
        if(length == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        return (T) arr[length - 1];
    }




    @Override
    public void remove(int index) {
        checkCap(index);

        int numMoved = length - index - 1;
        if (numMoved > 0) {
            System.arraycopy(arr, index + 1, arr, index, numMoved);
        }
        arr[--length] = null;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(length - 1);
    }

    @Override
    public void sort() {
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length-1-i; j++) {
                if (((Comparable)arr[j]).compareTo(arr[j+1]) > 0) {
                    Object temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < length; i++) {
            if (arr[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = length - 1; i >= 0; i--) {
            if (arr[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] temp = new Object[length];
        System.arraycopy(arr, 0, temp, 0, length);
        return temp;
    }

    @Override
    public void clear() {
        arr = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return length;
    }


    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    public class MyIterator implements Iterator<T> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < length;
        }

        @Override
        public T next() {
            return (T) arr[index++];
        }
    }
}