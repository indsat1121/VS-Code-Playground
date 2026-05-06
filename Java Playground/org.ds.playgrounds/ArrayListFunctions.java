import java.util.ArrayList;

public class ArrayListFunctions {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        names.add("Indraneel");
        names.add("Amit");

        System.out.println("names: " + names);
        System.out.println("get(0): " + names.get(0));                  // "Indraneel"

        names.set(1, "Rahul");                                         // replace index 1
        System.out.println("after set(1, \"Rahul\"): " + names);

        names.remove(0);                                                // remove by index
        System.out.println("after remove(0): " + names);

        System.out.println("size: " + names.size());                    // list size
        System.out.println("contains(\"Rahul\"): " + names.contains("Rahul")); // true
        System.out.println("isEmpty: " + names.isEmpty());              // false

        System.out.println("printNames:");
        printNames(names);

        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(6);

        System.out.println("nums: " + nums);
        System.out.println("even numbers: " + getEvenNumbers(nums));
    }

    /* O(n) Time and O(1) Space*/
    public static void printNames(ArrayList<String> names) {
        for (String name : names) {
            System.out.println(name);
        }
    }
    /* O(n) Time and O(n) Space*/
    public static ArrayList<Integer> getEvenNumbers(ArrayList<Integer> nums) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int num : nums) {
            if (num % 2 == 0) {
                result.add(num);
            }
        }

        return result;
    }
}
