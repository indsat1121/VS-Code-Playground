import java.util.Arrays;

public class ArrayFunctions {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        System.out.println("array: " + java.util.Arrays.toString(nums));
        System.out.println("length: " + nums.length);                       // size of array
        System.out.println("first element: " + nums[0]);                    // first element
        System.out.println("last element: " + nums[nums.length - 1]);       // last element
        System.out.println("max element: " + findMax(nums));
        System.out.println("Sum of Arrays : " + sumArray(nums));
        reverseArray(nums);
        System.out.println("reverseArray: " + Arrays.toString(nums));
    }
    /* Space O(1), Time O(n)*/
    public static int findMax(int[] nums) {
        int max = nums[0];

        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        return max;
    }

    /* Space O(1), Time O(n)*/
    public static int sumArray(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    /* Space O(1), Time O(n). 
        has O(n) time complexity because it processes each array element at most once.
        If the array has n elements, the loop swaps the first and last, then the second and second-last, and 
        so on.The middle element 3 stays where it is.
        So the loop runs about n / 2 times. But in Big-O notation, we ignore constants,
        Thats why it is O(n).
    
    */
    public static void reverseArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}
