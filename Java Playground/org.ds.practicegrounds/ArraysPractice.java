

public class ArraysPractice {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        // Print the array
        //Time complexity: O(n)
        //Space complexity: O(1)
        System.out.println("Array elements:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Calculate the sum of the array elements
        //Time complexity: O(n)
        //Space complexity: O(1)
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("Sum of array elements: " + sum);

        // Find the average of the array elements
        //Time complexity: O(n)
        //Space complexity: O(1)
        double average = (double) sum / arr.length;
        System.out.println("Average of array elements: " + average);

        // Find the maximum element in the array
        //Time complexity: O(n)
        //Space complexity: O(1)
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Maximum element in the array: " + max);

        // Find the second largest element in the array
        //Time complexity: O(n)
        //Space complexity: O(1)
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondLargest = max;
                max = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != max) {
                secondLargest = arr[i];
            }
        }
        System.out.println("Second largest element in the array: " + secondLargest);

        // Reverse the array
        //Time complexity: O(n)
        //Space complexity: O(1)
        System.out.println("Reversed array:");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " "); 
        }

        // Sort the array (using bubble sort)
        //Time complexity: O(n^2)
        //Space complexity: O(1)
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;      
                }
            }
        }
        System.out.println("Sorted array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        // Find the index of a specific element (e.g., 3)
        //Time complexity: O(n)
        //Space complexity: O(1)
        int target = 3;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                index = i;
                break;  
            }
        }
        System.out.println("Index of element " + target + ": " + index);
        // Create a new array with double the size and copy the elements
        //Time complexity: O(n)
        //Space complexity: O(n)
        int[] newArr = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        System.out.println("New array with double the size:");
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + " ");  
        }

        // Find the frequency of each element in the array
        //Time complexity: O(n^2)
        //Space complexity: O(1)
        System.out.println("Frequency of each element in the array:");
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;    
                }
            }
            System.out.println(arr[i] + ": " + count);
        }
        // Find the common elements between two arrays
        //Time complexity: O(n^2)
        //Space complexity: O(1)
        int[] arr2 = {3, 4, 5, 6, 7};
        System.out.println("Common elements between arr and arr2:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr[i] == arr2[j]) {
                    System.out.print(arr[i] + " ");
                    break;
                }
            }
        }

        //Reverse the array in place
        //Time complexity: O(n)
        //Space complexity: O(1)
        Integer[] arrObj = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrObj[i] = arr[i];
        }
        java.util.Collections.reverse(java.util.Arrays.asList(arrObj));
        System.out.println("Reversed array in place:");
        for (int num : arrObj) {
            System.out.print(num + " "); 
        }
    }

}
