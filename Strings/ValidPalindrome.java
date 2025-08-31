import java.util.Scanner;

public class ValidPalindrome{
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                continue;
            }
            str.append(Character.toLowerCase(s.charAt(i)));
        }
        s = str.toString();
        int start = 0;
        int end = s.length()-1;
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the string: ");
            String str = sc.nextLine();
            ValidPalindrome solver = new ValidPalindrome();
            boolean ans = solver.isPalindrome(str);
            System.out.println("Is Palindrome?: " + ans);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}