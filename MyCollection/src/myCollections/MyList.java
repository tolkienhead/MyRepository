package myCollections;
import java.util.Collection;

public interface MyList <T> extends Iterable{
    boolean add(T ob);
    boolean addAll(Collection <? extends T> collection);
    boolean update(int index, T ob);
    T get(int index);
    boolean remove(T ob);
    boolean remove(int index);
    int size();

    public static <T extends Comparable<? super T>> void sort(MyList<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = list.size() - 1; j > i; j--) {
                int comp = list.get(j - 1).compareTo(list.get(j));
                if (comp > 0) {
                    T tmp = list.get(j - 1);
                    list.update(j - 1, list.get(j));
                    list.update(j, tmp);
                }
            }
        }
    }
}
