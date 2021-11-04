package Java_pepcoding;
/*
1. You are given a string.
2. You have to print all permutations of the given string iteratively.
Input Format
A String
Output Format
All permutations of the given string(one in a line).
Constraints
1 <= length of string <= 15
Sample Input
abc
Sample Output
abc
bac
cab
acb
bca
cba
*/
import java.util.Scanner;

public class Print_All_Permutations_Of_A_String_Iteratively {
    public static void solution(String str){
        int n = str.length();   // calculating the length of the string
        int f = factorial(n);   // calculating factorial of the length of the string

        for(int i=0 ; i<f ; i++){
            StringBuilder sb = new StringBuilder(str);
            int temp = i;   // we have to divide the factorial one by one by 1,2,3,......n-1

            for(int div=n ; div>=1 ; div--){    // divisors : 1,2,3,......,n-1
                int q = temp / div; // quotient
                int r = temp % div; // remainder
                System.out.print(sb.charAt(r)); // printing charAt(remainder)
                sb.deleteCharAt(r); // after printing delete the charAt(remainder> that's why we used StringBuilder
                temp = q;   // now our quotient is our new temp
            }
            System.out.println();
        }
    }
    public static int factorial(int n){
        int val = 1;
        for(int i=2 ; i<=n ; i++){
            val *= i;
        }
        return val;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter t:");
        int t = sc.nextInt();
        while (t-- > 0){

            System.out.println("Enter string:");
            String s = sc.next();

            solution(s);
        }
    }
}
