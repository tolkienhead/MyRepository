package mycollection.mymap;

import java.util.*;

/**
 * Реализация интерфейса CustomMap. Для хранения значений используется массив.
 * В каждой ячейке массива лежит коллекция LinkedList, содержащая объекты типа Node.
 * Объекты Node имееют два поля - для ключа, и для значения.
 * @param <K> - тип ключа.
 * @param <V> - тип значения.
 */
public class CustomHashMap <K, V> implements CustomMap<K, V> {
    static final int TABLE_CAPACITY = 16;
    private Node<K,V> [] table = new Node[TABLE_CAPACITY];

    private int size;


    /**
     * Реализация записи "ключ-значени" в массиве.
     * Первый объект класса попадающий в массив представляет собой
     * заглушку с пустыми значениями полей, кроме поля nodes,
     * где содержится коллекция из объектов Node c ключом и значением.
     * @param <K> - тип ключа.
     * @param <V> - тип значения.
     */
    private class Node<K, V>{
        private K key;
        private V value;

        List <Node<K, V>> nodes;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            nodes = new LinkedList<>();
        }

        /**
         * Создаёт новый объект типа Node c переданными
         * параметрами, и добавляет его в коллекцию nodes
         */
        private void putInNodes(K key, V value){
            nodes.add(new Node<K,V>(key,value));
        }

        /**
         * Передаёт коллекцию nodes
         * @return - LinkedList c записями типа Node
         */
        private List<Node<K, V>> getNodes() {
            return nodes;
        }

        private K getKey() {
            return key;
        }

        private V getValue() {
            return value;
        }

        private void setValue(V value) {
            this.value = value;
        }
    }

    /**
     * Вычисление хэша для получения индекса ячейки в таблице
     * @return - индекс ячейки
     */
    private int hash(K key){
        int hash = 31 * key.hashCode();
        return hash % table.length;
    }

    /**
     * Добавление элемента в HashMap.
     * Если ячейка в массиве не пуста, то ссылка node получает, находящийся в ячейке элемент.
     * Затем ListNodes получает коллекцию LinkedList со всеми записями.
     * Записи проверяются на наличие совпадений с ключом объекта, который мы пытаемся добавить.
     * Если совпадение есть - значение перезаписывается.
     * Если нет - добавляется новая запись.
     * Если ячейка в массиве пуста, создается новый объект заглушка.
     * В объекте создается коллекция LinkedList, куда помещается первая запись
     */
    @Override
    public void put(K key, V value) {
        int index = hash(key);

        if(table[index] != null){
            Node<K,V> node = table[index];
            List<Node<K,V>> ListNodes = node.getNodes();
            for(Node<K,V> n : ListNodes){
                if(n.getKey().equals(key)){
                    n.setValue(value);
                    return;
                }
            }
            node.putInNodes(key,value);
            size++;
        }

        else if(table[index] == null){
            Node<K,V> node = new Node<>(null,null);
            node.putInNodes(key,value);
            table[index] = node;
            size++;
        }
    }

    /**
     * Удаление записи по ключу.
     * @param key - ключ объекта, по которому удаляется запись.
     * @return - возвращает удалённый объект.
     */
    @Override
    public V remove(K key) {
        V temp = null;
        int index = hash(key);
        Node<K, V> node = table[index];

        if(node != null){
            List<Node<K, V>> ListNodes = node.getNodes();
            for(Node<K, V> n : ListNodes){
                if(n.getKey().equals(key)){
                    temp = n.getValue();
                    ListNodes.remove(n);
                    size--;
                    return temp;
                }
            }
        }
        return temp;
    }

    /**
     * Получение записи по ключу.
     * @param key - ключ по которому получается запись.
     * @return - значение искомого объекта
     */
    @Override
    public V get(K key) {
        int index = hash(key);
        Node<K,V> node = table[index];

        if(node != null){
            List <Node<K,V>> ListNodes = node.getNodes();

            for(Node<K,V> n : ListNodes){
                if(n.getKey().equals(key)){
                    return n.getValue();
                }
            }
        }
        return null;
    }

    /**
     * Получение коллекции с ключами всех объектов, находящихся в HashMap
     * @return - коллекция типа HashSet
     */
    @Override
    public Set<K> keySet() {
        Set<K> keyset = new HashSet<>();
        for(int i = 0; i < table.length; i++){
            Node<K,V> node = table[i];
            if(node != null){
                List<Node<K,V>> ListNodes = node.getNodes();
                for (Node<K,V> n : ListNodes){
                    keyset.add(n.getKey());
                }
            }
        }
        return keyset;
    }

    /**
     * Получение значений всех объектов, хранящихся в HashMap
     * @return - коллекция типа LinkedList
     */
    @Override
    public Collection<V> values() {
        Collection<V> values = new LinkedList<>();

        for(int i = 0; i < table.length; i++){
            Node<K,V> node = table[i];
            if(node != null){
                List<Node<K,V>> ListNodes = node.getNodes();
                for (Node<K,V> n : ListNodes){
                    values.add(n.getValue());
                }
            }
        }

        return values;
    }

    /**
     * Проверка на наличие в HashMap переданного значения
     * @param value - искомое значение
     * @return - true или false
     */
    @Override
    public boolean containsValue(V value) {
        for(int i = 0; i < table.length; i++){
            Node<K,V> node = table[i];
            if(node != null){
                List<Node<K,V>> ListNodes = node.getNodes();
                for (Node<K,V> n : ListNodes){
                    if(n.getValue().equals(value)){
                        return true;
                    }
                }
            }
        }

        return false;
    }
    /**
     * Проверка на наличие в HashMap переданного ключа
     * @param key - искомый ключ
     * @return - true или false
     */
    @Override
    public boolean containsKey(K key){
        int index = hash(key);
        Node<K,V> node = table[index];

        if(node != null){
            List <Node<K,V>> ListNodes = node.getNodes();

            for(Node<K,V> o : ListNodes){
                if(o.getKey().equals(key)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Получение размера HashMap
     * @return - размер HashMap
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Проверка HashMap на пустоту
     * @return - true или false
     */
    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * Очистка HashMap, обнуление счётчка размера, и длинны table по умолчанию.
     */
    @Override
    public void clear() {
        table = new Node[TABLE_CAPACITY];
        size = 0;
    }
}
