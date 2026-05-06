public class StringFunctions {
    public static void main(String[] args) {
        String s = "hello world";

        System.out.println("length: " + s.length());                       // 11
        System.out.println("charAt(0): " + s.charAt(0));                   // 'h'
        System.out.println("substring(0, 5): " + s.substring(0, 5));       // "hello"
        System.out.println("toUpperCase: " + s.toUpperCase());            // "HELLO WORLD"
        System.out.println("toLowerCase: " + s.toLowerCase());            // "hello world"
        System.out.println("contains(\"world\"): " + s.contains("world")); // true
        System.out.println("indexOf(\"o\"): " + s.indexOf("o"));         // 4
        System.out.println("replace: " + s.replace("world", "Java"));    // "hello Java"
        System.out.println("split: " + java.util.Arrays.toString(s.split(" "))); // ["hello", "world"]
        System.out.println("trim: " + s.trim());                          // removes leading/trailing spaces
        System.out.println("equals(\"hello\"): " + s.equals("hello"));    // compare content
        System.out.println(isPalindrome(s));
    }

    /*Time: O(n) and Space O(1) */
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
