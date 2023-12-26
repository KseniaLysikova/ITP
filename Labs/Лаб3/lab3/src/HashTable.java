import java.util.LinkedList;


public class HashTable<K,V> {
    private static int size;
    public static int capacity;
    private LinkedList<Entry<K, V>>[] table;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        if (table[index] == null) {
            table[index] = new LinkedList<Entry<K, V>>();
        }
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        table[index].add(new Entry<K, V>(key, value));
        size++;
    }

    public Entry<K, V> get(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> list = table[index];
        if (list.isEmpty()) return null;
        else {
            for (Entry<K, V> entry : list) {

                if (entry.key.equals(key)) {
                    return entry;
                }
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = getIndex(key);
        table[index] = new LinkedList<>();
        for (Entry <K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                table[index].remove(entry);
                size--;
                return;
            }
        }
    }

    public int size() {
        return size;
    }

    public static boolean isEmpty() {
        return size == 0;
    }

    public int getIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % capacity;
    }

    @Override
    public String toString() {
        String s = "";
        for (LinkedList<Entry<K, V>> list : table) {
            if (!list.isEmpty()) {
                for (Entry<K, V> entry : list) {
                    s += "{" + entry.key + ", " + entry.value + "}";
                }
                s += "\n";
            }
        }
        return s;
    }

    public static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + ", " + value + "}";
        }
    }

    private static class Employee {
        private int id;
        private String name;
        private String role;
        private int salary;

        public Employee() {
            this.id = 0;
            this.name = null;
            this.role = null;
            this.salary = 0;
        }

        public Employee(int id, String name, String role, int salary) {
            this.id = id;
            this.name = name;
            this.role = role;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", role='" + role + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    public static void main(String[] args) {
        HashTable<Integer, Employee> table = new HashTable<>(6);
        Employee man = new Employee(12, "Max", "Engineer", 40500);
        Employee man2 = new Employee(13, "Alex", "Engineer", 40500);
        table.put(man.id, man);
        table.put(man2.id, man2);
        System.out.println("Хэш-таблица: "+ table);
        for (int i = man.id; i <= man2.id; i++) {
            if (table.get(i).key == man2.id) {
                System.out.println("Поиск по id:" + table.get(i));
            }
        }
        table.remove(man.id);
        System.out.println("Таблица после удаления man: " + table);
        HashTable<String, Integer> table1 = new HashTable<>(2);
        table1.put("fisrt", 1);
        table1.put("first", 2);
        System.out.println(table1);
    }
}
