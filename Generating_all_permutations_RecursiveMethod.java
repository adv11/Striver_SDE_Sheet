package Java_pepcoding;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Generating_all_permutations_RecursiveMethod {
    // Brute Force
    // TC = O(n! * n)
    // SC = O(n) + (n)
    public static void bruteForce(int[] nums, List<Integer> ds, List<List<Integer>> ans, boolean[] freq){
        if(ds.size() == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0 ; i<nums.length ; i++){
            if(!freq[i]){
                freq[i] = true;
                ds.add(nums[i]);
                bruteForce(nums, ds, ans, freq);
                ds.remove(ds.size()-1);
                freq[i] = false;
            }
        }
    }
    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds =new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        bruteForce(nums, ds, ans, freq);
        return ans;
    }


    // Optimised Approach :
    // TC = O(n! * n)
    // SC = O(1)
    public static void optimised(int index, int[] nums, List<List<Integer>> ans){
        if(index == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i=0 ; i< nums.length ; i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index ; i<nums.length ; i++){
            swap(i, index, nums);
            optimised(index+1, nums, ans);
            swap(i, index, nums);
        }
    }
    public static void swap(int i, int j, int[] nums){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public static List<List<Integer>> permute_optimised(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        optimised(0, nums, ans);
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements:");
        int n = sc.nextInt();
        System.out.println("Enter elements of the array:");
        int[] array = new int[n];
        for(int i=0 ; i<n ; i++){
            array[i] = sc.nextInt();
        }
//        System.out.println(permute(array));
        System.out.println(permute_optimised(array));
    }
}
