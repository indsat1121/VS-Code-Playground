import java.util.HashMap;

public class HashMapFunctions {
    public static void main(String[] args) {
        HashMap<String, Integer> scores = new HashMap<>();

        scores.put("John", 90);
        scores.put("Amit", 85);

        System.out.println("scores: " + scores);
        System.out.println("get(\"John\"): " + scores.get("John"));                 // 90
        System.out.println("containsKey(\"Amit\"): " + scores.containsKey("Amit")); // true
        System.out.println("containsValue(90): " + scores.containsValue(90));        // true

        scores.remove("John");
        System.out.println("after remove(\"John\"): " + scores);
        System.out.println("size: " + scores.size());

        System.out.println("countChars(\"hello\"): " + countChars("hello"));
        System.out.println("countWords: " + countWords("java is fun java is powerful"));

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println("twoSum: " + java.util.Arrays.toString(twoSum(nums, target)));
    }
    /*o(n) Time, o(n) space */
    public static HashMap<Character, Integer> countChars(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        return map;
    }
    /*o(n) Time, o(n) space */
    public static HashMap<String, Integer> countWords(String sentence) {
        HashMap<String, Integer> map = new HashMap<>();

        String[] words = sentence.split(" ");

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        return map;
    }
    /*o(n) Time, o(n) space 
        I use a HashMap to store numbers I have already seen with their index. 
        For each number, I check whether its complement exists. 
        If yes, I return both indices. 
        This avoids a nested loop and improves from O(n²) to O(n).
    */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int needed = target - nums[i];

            if (map.containsKey(needed)) {
                return new int[] {map.get(needed), i};
            }
            //Value and Position
            map.put(nums[i], i);
        }

        return new int[] {};
    }
}
