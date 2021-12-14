package homework11.listOfGoods;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ListOfGoods {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("Milk, pack", 2);
        map.put("Eggs, pieces", 10);
        map.put("Bread, loaf", 1);
        map.put("Butter, pack", 2);
        map.put("Water, bottle", 2);
        map.put("Tea, pack", 1);
        map.put("Coffee, box", 1);
        map.put("Cheese, pack", 2);

        Iterator<Integer> iterator = map.values().iterator();
        int sum = 0;
        while (iterator.hasNext()) {
            sum+=iterator.next();
        }
        System.out.println("List of goods: " + map);

        System.out.println("Total number of goods: " + sum);
    }
}
