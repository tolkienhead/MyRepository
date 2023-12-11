package myCollections;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class MyArrayList<T> implements MyList<T>{
    private T[] val;
    private int count;

    public MyArrayList(){
        count = 0;
        val = (T[]) new Object[10];
    }

    public MyArrayList(int capacity){
        if(capacity < 0){
            throw new IndexOutOfBoundsException();
        }
        count = 0;
        val = (T[]) new Object[capacity];
    }

    public MyArrayList(Collection<? extends T> collection){
        val = (T[]) new Object[collection.size()];
        for(T x : collection){
            add(x);
        }
    }

    @Override
    public boolean add(T ob) {
        if(count == val.length){
            val = Arrays.copyOf(val,val.length + 10);
        }
        val[count++] = ob;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        for(T x : collection){
            this.add(x);
        }
        return true;
    }

    @Override
    public boolean update(int index, T ob) {
        val[index] = ob;
        return true;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index > count - 1){
            throw new IndexOutOfBoundsException();
        }
        return val[index];
    }


    @Override
    public boolean remove(int index) {
        if(index < 0 || index > count - 1){
            throw new IndexOutOfBoundsException();
        }

        T [] temp = (T[]) new Object[val.length];
        int afterIndex = val.length - 1 - index;
        int beforeIndex = 0 + index ;
        System.arraycopy(val, index+1, temp,index,afterIndex);
        if(index != 0){
            System.arraycopy(val, 0, temp,0,beforeIndex);
        }
        val = temp;
        count--;
        return true;
    }

    @Override
    public boolean remove(T ob) {
        int index = 0;
        for(int i = 0; i < count; i++){
            if(val[i] == ob){
                index = i;
            }
        }

        remove(index);
        return true;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Iterator iterator() {
        return new MyIterator(val, count);
    }
}
