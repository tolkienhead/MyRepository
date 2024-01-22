package mycollection.mymap;
import java.util.Collection;
import java.util.Set;

/**
 * Коллекция "ключ-значение"
 * @param <K> - тип ключа
 * @param <V> - тип значения
 */
public interface CustomMap<K, V> {
    /**
     * Добавление элемента в коллекцию
     */
    public void put(K key, V value);

    /**
     * Получение элемента из коллекции
     */
    public V get(K key);

    /**
     * Получение числа элементов в коллекции
     */
    public int size();

    /**
     * Проверка коллекции на пустоту
     */
    public boolean isEmpty();

    /**
     * Удаление элемента по ключу
     */
    public V remove(K key);

    /**
     * Проверка наличия элемента по ключу
     */
    public boolean containsKey(K key);

    /**
     * Проверка наличия элемента по значению
     */
    public boolean containsValue(V value);

    /**
     * Получение коллекции всех ключей
     */
    public Set <K> keySet();

    /**
     * Получение коллекции всех значений
     */
    public Collection<V> values();

    /**
     * Очищение коллекции
     */
    public void clear();
}
