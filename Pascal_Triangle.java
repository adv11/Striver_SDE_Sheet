package StriverSDE_Sheet;

import java.util.ArrayList;
import java.util.Scanner;

public class Pascal_Triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows:");
        int n = sc.nextInt();

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=1 ; i<=n ; i++){
            int p = 1;
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=1 ; j<=i ; j++){
                temp.add(p);
                p = p * (i-j)/j;
            }
            ans.add(temp);
        }
        System.out.println(ans);
    }
}
