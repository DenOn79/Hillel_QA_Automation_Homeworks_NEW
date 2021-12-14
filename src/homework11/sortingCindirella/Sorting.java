package homework11.sortingCindirella;

import java.util.*;

public class Sorting {
    public static void main(String[] args) {
        Set<Integer> nums = new TreeSet<>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            nums.add(random.nextInt(500));
        }

        List<Integer> divOnTwo = new ArrayList<>();
        List<Integer> divOnThree = new ArrayList<>();
        List<Integer> notDiv = new ArrayList<>();
        for (int j : nums) {
            if (j%2 == 0){
                divOnTwo.add(j);}
            if (j%3 == 0){
                divOnThree.add(j);}
            if ((j%2 != 0) && (j%3 != 0)){
                notDiv.add(j);
            }
        }

        System.out.println(nums);
        System.out.println(divOnTwo);
        System.out.println(divOnThree);
        System.out.println(notDiv);
    }
}
