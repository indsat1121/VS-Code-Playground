import java.util.ArrayList;
import java.util.HashSet;

public class HashSetFunctions {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(2);                                                   // duplicate ignored

        System.out.println("set: " + set);
        System.out.println("contains(1): " + set.contains(1));        // true

        set.remove(2);
        System.out.println("after remove(2): " + set);
        System.out.println("size: " + set.size());

        int[] numsWithDuplicate = {1, 2, 3, 2};
        int[] numsWithoutDuplicate = {1, 2, 3, 4};

        System.out.println("hasDuplicate([1, 2, 3, 2]): " + hasDuplicate(numsWithDuplicate));
        System.out.println("hasDuplicate([1, 2, 3, 4]): " + hasDuplicate(numsWithoutDuplicate));
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(2);
        nums.add(3);

        System.out.println("removeDuplicates: Source ArrayList : " +nums +" After Removal: " +removeDuplicates(nums)); // [1, 2, 3]
    
    }
    /* Space o(n) and Time o(n) */
    public static boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }

            set.add(num);
        }

        return false;
    }
    /* Space o(n) and Time o(n) */
    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> nums) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
                result.add(num);
            }
        }

        return result;
    }
}


