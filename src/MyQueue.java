import java.util.LinkedList;

public class MyQueue<T extends Comparable<T>> {
    private LinkedList<T> queue = new LinkedList<T>();
    public MyQueue() {
        return;
    }
    public T front(){
        return queue.get(0);
    }
    public T back(){
        return queue.get(queue.size()-1);
    }
    public T dequeue(){
        T item = queue.get(0);
        queue.remove(0);
        return item;
    }
    public void enqueue(T item){
        queue.add(item);
    }
    public boolean isEmpty(){
        return queue.size() == 0;
    }
    public int size(){
        return queue.size();
    }
    public void clear(){
        queue.clear();
    }
}
