package org.example;

public class Main {
    public static void main(String[] args) {
        // Palindrom testi
        System.out.println(isPalindrome(-1221)); // true
        System.out.println(isPalindrome(707));   // true
        System.out.println(isPalindrome(11212)); // false

        // Mükemmel sayı testi
        System.out.println(isPerfectNumber(6));   // true
        System.out.println(isPerfectNumber(28));  // true
        System.out.println(isPerfectNumber(5));   // false
        System.out.println(isPerfectNumber(-1));  // false

        // Sayıyı kelimelere dökme testi
        System.out.println(numberToWords(123));   // One Two Three
        System.out.println(numberToWords(1010));  // One Zero One Zero
        System.out.println(numberToWords(-12));   // Invalid Value
    }

    public static boolean isPalindrome(int number) {
        int original = Math.abs(number);
        int reversed = 0;
        int temp = original;

        while (temp > 0) {
            int digit = temp % 10;
            reversed = reversed * 10 + digit;
            temp /= 10;
        }

        return original == reversed;
    }

    public static boolean isPerfectNumber(int number) {
        if (number < 1) {
            return false;
        }

        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        return sum == number;
    }

    public static String numberToWords(int number) {
        if (number < 0) {
            return "Invalid Value";
        }

        String[] words = {"Zero", "One", "Two", "Three", "Four", "Five",
                "Six", "Seven", "Eight", "Nine"};

        int reversed = 0;
        int temp = number;
        int digitCount = 0;

        while (temp > 0) {
            reversed = reversed * 10 + (temp % 10);
            temp /= 10;
            digitCount++;
        }

        // Özel durum: sayı 0 ise
        if (number == 0) {
            return "Zero";
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < digitCount; i++) {
            int digit = reversed % 10;
            result.append(words[digit]);
            if (i < digitCount - 1) {
                result.append(" ");
            }
            reversed /= 10;
        }

        return result.toString();
    }
}
