package homework11.removeDuplicates;

import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            nums.add(random.nextInt(20));
        }

        System.out.println(nums);

        Set<Integer> numsSet = new TreeSet<>(nums);

        System.out.println(numsSet);

        System.out.printf("Removed %d duplicates", nums.size() - numsSet.size());
    }
}

