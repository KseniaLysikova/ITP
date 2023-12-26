import java.util.concurrent.ConcurrentHashMap;

public class SalesTracker {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        int sum = 0;
        int max = -1;
        String mostPopular = "";
        String[] products = {"Молоко", "Хлеб", "Творог", "Шоколад", "Картофель"};
        int[] number = {40, 35, 12, 29, 70};
        for (int i = 0; i < products.length; i++) {
            map.put(products[i], number[i]);
        }
        System.out.println("Список проданных товаров:");
        for (String product : map.keySet()) {
            if (map.get(product) > max) {
                max = map.get(product);
                mostPopular = product;
            }
            System.out.println(product + ": " + map.get(product));
        }
        for (int num : map.values()) {
            sum += num;
        }
        System.out.println("Общая сумма: " + sum);
        System.out.println("Самый популярный: " + mostPopular + ", " + max);
    }
}
