import java.util.Arrays;

public class BinarySearchBasics {

    // Iterative binary search on sorted array.
    // Returns index if found, else -1.
    // Time: O(log n), Space: O(1).
    public static int binarySearchIterative(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // Recursive binary search.
    // Time: O(log n), Space: O(log n) recursion stack.
    public static int binarySearchRecursive(int[] arr, int target) {
        return binarySearchRecursive(arr, target, 0, arr.length - 1);
    }

    private static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid + 1, right);
        }
        return binarySearchRecursive(arr, target, left, mid - 1);
    }

    // Interview variant: find first occurrence of target in sorted array with duplicates.
    // Time: O(log n), Space: O(1).
    public static int firstOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int answer = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                answer = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    // Interview variant: find insertion position (lower bound).
    // Returns first index i where arr[i] >= target, or arr.length if none.
    // Time: O(log n), Space: O(1).
    public static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 3, 3, 5, 7, 9, 12};
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("binarySearchIterative(7): " + binarySearchIterative(arr, 7));
        System.out.println("binarySearchRecursive(5): " + binarySearchRecursive(arr, 5));
        System.out.println("firstOccurrence(3): " + firstOccurrence(arr, 3));
        System.out.println("lowerBound(6): " + lowerBound(arr, 6));
    }
}
