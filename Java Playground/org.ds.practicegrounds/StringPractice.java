public class StringPractice {
    public static void main(String[] args) {
        //I would like to understand different string functions in Java. Please provide code examples that covers all highly used java fucntions.
        String str1 = "Hello, World!";
        String str2 = "Java Programming";   

        // Length of the string
        System.out.println("Length of str1: " + str1.length());

        // Concatenation        
        String concatenated = str1 + " " + str2;
        System.out.println("Concatenated String: " + concatenated);

        // Substring
        String substring = str1.substring(0, 5);
        System.out.println("Substring of str1: " + substring);

        // Replace
        String replaced = str1.replace("World", "Java");
        System.out.println("Replaced String: " + replaced);

        // To Upper Case
        String upperCase = str1.toUpperCase();
        System.out.println("Upper Case: " + upperCase);

        // To Lower Case
        String lowerCase = str1.toLowerCase();
        System.out.println("Lower Case: " + lowerCase);

        // Trim
        String str3 = "   Hello, Java!   ";
        String trimmed = str3.trim();
        System.out.println("Trimmed String: '" + trimmed + "'");

        // Split
        String[] splitArray = str2.split(" ");
        System.out.println("Split String:");
        java.util.Arrays.stream(splitArray).forEach(System.out::println);

        // Contains
        boolean contains = str1.contains("World");
        System.out.println("str1 contains 'World': " + contains);

        // Starts With
        boolean startsWith = str1.startsWith("Hello");
        System.out.println("str1 starts with 'Hello': " + startsWith);

        // Ends With
        boolean endsWith = str1.endsWith("!");
        System.out.println("str1 ends with '!': " + endsWith);

        // Index Of
        int indexOf = str1.indexOf("World");
        System.out.println("Index of 'World' in str1: " + indexOf);

        // Last Index Of
        int lastIndexOf = str1.lastIndexOf("o");
        System.out.println("Last index of 'o' in str1: " + lastIndexOf);

        // Equals
        boolean equals = str1.equals(str2);
        System.out.println("str1 equals str2: " + equals);

        // Equals Ignore Case
        boolean equalsIgnoreCase = str1.equalsIgnoreCase("hello, world!");
        System.out.println("str1 equals 'hello, world!' ignoring case: " + equalsIgnoreCase);

        // Format
        String formatted = String.format("The length of str1 is: %d", str1.length());
        System.out.println(formatted);

        //Write a Reverse String function
        String reversed = new StringBuilder(str1).reverse().toString();
        System.out.println("Reversed String: " + reversed);

        //Write a function to check if a string is a palindrome. Documents Space and Time Complexity.
        //Also Write functions for Anagram and Pangram. 
        //before each function write details of the function and its space and time complexity.

        String palindrome = "A man a plan a canal Panama";
        boolean isPalindrome = isPalindrome(palindrome);
        System.out.println("Is the string a palindrome? " + isPalindrome);  

        //Write Test Cases for Negative and Edge Cases for the above functions.
        String notPalindrome = "Hello, World!";
        boolean isNotPalindrome = isPalindrome(notPalindrome);
        System.out.println("Is the string a palindrome? " + isNotPalindrome);

        // Edge Case: Empty String
        String emptyString = "";
        boolean isEmptyPalindrome = isPalindrome(emptyString);
        System.out.println("Is the empty string a palindrome? " + isEmptyPalindrome);

        // Edge Case: Single Character
        String singleChar = "a";
        boolean isSingleCharPalindrome = isPalindrome(singleChar);
        System.out.println("Is the single character string a palindrome? " + isSingleCharPalindrome);

        // Edge Case: String with only spaces
        String spacesOnly = "     ";
        boolean isSpacesOnlyPalindrome = isPalindrome(spacesOnly);
        System.out.println("Is the string with only spaces a palindrome? " + isSpacesOnlyPalindrome);

        //Write Anagram Function, explains the function and its space and time complexity.
        String strA = "listen";
        String strB = "silent";
        boolean isAnagram = isAnagram(strA, strB);
        System.out.println("Are the strings anagrams? " + isAnagram);

        // Negative Test Case for Anagram
        String strC = "hello";
        String strD = "world";
        boolean isNotAnagram = isAnagram(strC, strD);
        System.out.println("Are the strings anagrams? " + isNotAnagram);

        // Edge Case: Anagram with spaces and different cases
        String strE = "Dormitory";
        String strF = "Dirty Room";
        boolean isAnagramWithSpaces = isAnagram(strE, strF);
        System.out.println("Are the strings anagrams (ignoring spaces and case)? " + isAnagramWithSpaces);

        //Edge Case: Anagram with different lengths
        String strG = "abc";
        String strH = "abcd";
        boolean isNotAnagramDifferentLengths = isAnagram(strG, strH);
        System.out.println("Are the strings anagrams (different lengths)? " + isNotAnagramDifferentLengths);

        // Edge Case: Anagram with special characters
        String strI = "A!@#B$%^C&*()";
        String strJ = "C&*()A!@#B$%^";
        boolean isAnagramWithSpecialChars = isAnagram(strI, strJ);
        System.out.println("Are the strings anagrams (ignoring special characters)? " + isAnagramWithSpecialChars);

        // Edge Case: Anagram with empty strings
        String strK = "";
        String strL = "";
        boolean isAnagramEmptyStrings = isAnagram(strK, strL);
        System.out.println("Are the empty strings anagrams? " + isAnagramEmptyStrings);     

        //Edge Case: Anagram with one empty string
        String strM = "abc";
        String strN = "";
        boolean isNotAnagramOneEmpty = isAnagram(strM, strN);
        System.out.println("Are the strings anagrams (one empty string)? " + isNotAnagramOneEmpty);     

        //Edge Case: Anagram with Duplicate Characters
        String strO = "aabbcc";
        String strP = "abcabc";
        boolean isAnagramWithDuplicates = isAnagram(strO, strP);
        System.out.println("Are the strings anagrams (with duplicate characters)? " + isAnagramWithDuplicates);   
        
        //Edge Case: Anagram with Unicode Characters
        String strQ = "résumé";
        String strR = "sérumé";
        boolean isAnagramWithUnicode = isAnagram(strQ, strR);
        System.out.println("Are the strings anagrams (with Unicode characters)? " + isAnagramWithUnicode);

        //Create a Pangram Function, explains the function and its space and time complexity.
        //INcludes Test Cases for Negative and Edge Cases for the above functions.

        String pangram = "The quick brown fox jumps over the lazy dog";
        boolean isPangram = isPangram(pangram);
        System.out.println("Is the string a pangram? " + isPangram);

        // Negative Test Case for Pangram
        String notPangram = "Hello, World!";
        boolean isNotPangram = isPangram(notPangram);
        System.out.println("Is the string a pangram? " + isNotPangram);

        // Edge Case: Pangram with missing letters
        String missingLettersPangram = "The quick brown fox jumps over the lazy";
        boolean isMissingLettersPangram = isPangram(missingLettersPangram);
        System.out.println("Is the string a pangram? " + isMissingLettersPangram);

        // Edge Case: Pangram with uppercase letters
        String uppercasePangram = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";
        boolean isUppercasePangram = isPangram(uppercasePangram);
        System.out.println("Is the string a pangram? " + isUppercasePangram);

        // Edge Case: Pangram with special characters
        String specialCharsPangram = "The quick brown fox jumps over the lazy dog!@#$%^&*()";
        boolean isSpecialCharsPangram = isPangram(specialCharsPangram);
        System.out.println("Is the string a pangram? " + isSpecialCharsPangram);

    
        // Edge Case: Pangram with numbers
        String numbersPangram = "The quick brown fox jumps over the lazy dog 1234567890";
        boolean isNumbersPangram = isPangram(numbersPangram);
        System.out.println("Is the string a pangram? " + isNumbersPangram);    
        
        // longestSubstringWithoutRepeatingCharacters Test Cases
        String testString1 = "abcabcbb";
        int longest1 = longestSubstringWithoutRepeatingCharacters(testString1);
        System.out.println("Longest substring without repeating characters in '" + testString1 + "': " + longest1);
    }

    private static boolean isPangram(String pangram) {
        // Function to check if a string is a pangram
        // A pangram is a sentence that contains every letter of the alphabet at least once.
        //Explains How it works: We create a boolean array of size 26 to track the presence of each letter in the alphabet. 
        // We iterate through the string, marking the presence of each letter.
        //  Finally, we check if all letters are present.
        // Time Complexity: O(n), where n is the length of the string. We traverse the string once to check for all letters.
        // Space Complexity: O(1), because we use a fixed-size boolean array to track the presence of each letter.
        boolean[] alphabet = new boolean[26];
        int index = 0;
        for (char c : pangram.toCharArray()) {
            if (Character.isLetter(c)) {
                index = Character.toLowerCase(c) - 'a';
                alphabet[index] = true;
            }
        }
        for (boolean present : alphabet) {
            if (!present) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindrome(String palindrome) {
        // Function to check if a string is a palindrome
        // A palindrome is a string that reads the same backward as forward, ignoring spaces,
        // punctuation and case sensitivity.
        // Time Complexity: O(n), where n is the length of the string. We traverse the string once
        // to clean it and reverse it.
        // Space Complexity: O(n), because StringBuilder creates a reversed copy of the cleaned string.
        String cleaned = palindrome.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }

    private static boolean isAnagram(String first, String second) {
        // Function to check if two strings are anagrams of each other.
        // Anagrams contain the same characters in different order, ignoring spaces and case.
        // Time Complexity: O(n + m + k), where n and m are the lengths of the two strings and k is the
        // size of the character set (constant for ASCII). We normalize both strings, sort them, and compare.
        // Space Complexity: O(n + m), because we store normalized copies of both strings.
        String normalizedFirst = first.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String normalizedSecond = second.replaceAll("[^a-zA-Z]", "").toLowerCase();

        if (normalizedFirst.length() != normalizedSecond.length()) {
            return false;
        }

        char[] firstChars = normalizedFirst.toCharArray();
        char[] secondChars = normalizedSecond.toCharArray();
        java.util.Arrays.sort(firstChars);
        java.util.Arrays.sort(secondChars);
        return java.util.Arrays.equals(firstChars, secondChars);
    }

    // Implement a function Longest Substring Without Repeating Characters function, 
    // explains the function step-by-step and its space and time complexity.
    // Write Test Cases for Negative and Edge Cases for the above function.
    // Function to find the length of the longest substring without repeating characters.
    private static int longestSubstringWithoutRepeatingCharacters(String s) {
        // This function uses a sliding window approach to find the longest substring without repeating characters.
        // We maintain a set to track the characters in the current window and two pointers to define the window.
        // Time Complexity: O(n), where n is the length of the string. We traverse the string once with the right pointer and at most once with the left pointer.
        // Space Complexity: O(min(m, n)), where m is the size of the character set and n is the length of the string. In the worst case, we may store all characters in the current window.
        // Step-by-step Explanation:
        // 1. We initialize a HashSet to store the characters in the current window,
        // and two pointers (left and right) to define the current window.
        // 2. We iterate through the string with the right pointer. For each character,
        //  we check if it is already in the set. If it is, we remove characters from the left pointer until we remove the duplicate character.
        // 3. We add the current character to the set and update the maximum length of the substring found so far.
        java.util.Set<Character> charSet = new java.util.HashSet<>();
        int left = 0;
        int maxLength = 0;  
        for (int right = 0; right < s.length(); right++) {
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

    






    
}
