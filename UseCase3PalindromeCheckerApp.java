import java.util.Scanner;

public class UseCase3PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input text: ");
        String input = scanner.nextLine();
        scanner.close();
        
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
        
        boolean isPalindrome = input.equals(reversed);
        System.out.println("Is it a Palindrome? : " + isPalindrome);
    }
}
