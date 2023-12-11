package myCollections;
import java.util.Iterator;

public class MyIterator<T> implements Iterator {
    private int index = 0;
    private int count;
    T [] val;

    MyIterator(T [] val, int count){
        this.count = count;
        this.val = val;
    }

    @Override
    public boolean hasNext() {
        return index < count;
    }

    @Override
    public T next() {
        return val[index++];
    }
}
