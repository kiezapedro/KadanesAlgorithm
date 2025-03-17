import java.util.Scanner;

public class LargestSum {
    // Main method- Entry point of the program
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scn = new Scanner(System.in);

        // Ask the user for the size of the array
        System.out.print("Enter the number of elements in the array: ");
        int n = scn.nextInt();

        // Create an integer array to store the elements
        int[] a = new int[n];

        // Prompt the user to enter the array elements
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt(); // Store each input value in the array

        }
        // Calculate and print the maximum contiguous sum
        System.out.println("Maximum contigous sum is " + maxSubArraySum(a));
    }

    // Method to calculate the maximum of a contiguous subarray using Kadane's
    // algorithm
    static int maxSubArraySum(int a[]) {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
        // Loop through the array to calculate the maxmimum contiguous sum
        for (int i = 0; i < size; i++) {
            max_ending_here = max_ending_here + a[i];

            // Update the maximum sum if necessary
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;

            // Reset the sume if it becomes negative
            if (max_ending_here < 0)
                max_ending_here = 0;

        }
        return max_so_far;
    }
}