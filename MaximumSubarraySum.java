    public class MaximumSubarraySum {
    
        //Maximum subarray sum
        public static int maxSubarraySum(int[] A, int K) {
            int N = A.length;
            
            //Calculate sum of the entire array A
            int totalSum = 0;
            for (int i = 0; i < N; i++) {
                totalSum += A[i];
            }
    
            //Kadane's algorithm to find maximum subarray sum in a single copy of A
            int maxEndingHere = A[0];
            int maxSoFar = A[0];
            for (int i = 1; i < N; i++) {
                maxEndingHere = Math.max(A[i], maxEndingHere + A[i]);
                maxSoFar = Math.max(maxSoFar, maxEndingHere);
            }
    
            //Find the best prefix sum of A
            int prefixSum = A[0];
            int maxPrefix = A[0];
            for (int i = 1; i < N; i++) {
                prefixSum += A[i];
                maxPrefix = Math.max(maxPrefix, prefixSum);
            }
    
            //Find the best suffix sum of A
            int suffixSum = A[N - 1];
            int maxSuffix = A[N - 1];
            for (int i = N - 2; i >= 0; i--) {
                suffixSum += A[i];
                maxSuffix = Math.max(maxSuffix, suffixSum);
            }
    
            //Determine result based on the value of K
            if (K == 1) {
                return maxSoFar;
            }
    
            int result = maxSoFar; //The best sum in a single copy of A
    
            if (K > 1) {
                //Best sum across the boundary of two copies of A
                result = Math.max(result, maxSuffix + maxPrefix);
                
                //Best sum if we take multiple full copies of A
                if (K > 2) {
                    result = Math.max(result, maxSuffix + (K - 2) * totalSum + maxPrefix);
                }
            }
    
            return result;
        }
    
        public static void main(String[] args) {
            int[] A = {1, 2};
            int K = 3;
    
            int result = maxSubarraySum(A, K);
            System.out.println("Maximum subarray sum: " + result);
        }
    }