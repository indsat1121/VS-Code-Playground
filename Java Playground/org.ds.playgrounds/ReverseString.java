/* Time Complexity O(n), Space Complexity O(n) as Object/List/Object*/
public class ReverseString {

    public static void main(String[] args) {
        String s = "Hello";
        StringBuilder result = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            result.append(s.charAt(i));
        }
        System.out.print("ReverseString --> "+ result.toString());

    }

}
