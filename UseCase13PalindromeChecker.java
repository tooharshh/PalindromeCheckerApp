import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

public class UseCase13PalindromeChecker{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input : ");
        String input = scanner.nextLine();

        // ---- Two-Pointer Algorithm ----
        long startTime1 = System.nanoTime();
        boolean result1 = twoPointerCheck(input);
        long endTime1 = System.nanoTime();
        long duration1 = endTime1 - startTime1;

        // ---- Stack Algorithm ----
        long startTime2 = System.nanoTime();
        boolean result2 = stackCheck(input);
        long endTime2 = System.nanoTime();
        long duration2 = endTime2 - startTime2;

        long startTime3 = System.nanoTime();
        boolean result3 = stringBuilderCheck(input);
        long endTime3 = System.nanoTime();
        long duration3 = endTime3 - startTime3;

        // Display results
        System.out.println("Is Palindrome? : " + result1);
        System.out.println();
        System.out.println("=== Performance Comparison ===");
        System.out.println("Two-Pointer     : " + duration1 + " ns  -> Palindrome: " + result1);
        System.out.println("Stack           : " + duration2 + " ns  -> Palindrome: " + result2);
        System.out.println("StringBuilder   : " + duration3 + " ns  -> Palindrome: " + result3);
        System.out.println();

        // Determine fastest
        long minTime = Math.min(duration1, Math.min(duration2, duration3));
        if (minTime == duration1) {
            System.out.println("Fastest Algorithm : Two-Pointer");
        } else if (minTime == duration2) {
            System.out.println("Fastest Algorithm : Stack");
        } else {
            System.out.println("Fastest Algorithm : StringBuilder");
        }

        System.out.println("Execution Time : " + minTime + " ns");

        scanner.close();
    }

    private static boolean twoPointerCheck(String input) {
        int start = 0;
        int end = input.length() - 1;
        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private static boolean stackCheck(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            stack.push(c);
        }
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    private static boolean stringBuilderCheck(String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equals(reversed);
    }
}
