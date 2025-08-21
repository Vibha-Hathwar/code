/*Given an array arr[] of integers and an integer k, select k elements from the array such that the minimum absolute difference between any two of the selected 
elements is maximized. Return this maximum possible minimum difference.

Input: arr[] = [1, 4, 9, 0, 2, 13, 3], k = 4
Output: 4
Explanation: Selecting 0, 4, 9, 13 will result in minimum difference of 4, which is the largest minimum difference possible.*/

class Solution {
    
     public boolean isPossible(int[] arr, int k, int mid) {
        int count = 1; 
        int last = arr[0];

        for (int i = 1; i < arr.length; i++) 
        {
            if (arr[i] - last >= mid) 
            {
                count++;
                last = arr[i];
            }
            if (count >= k) 
                return true; 
        }
        return false;
    }
    
    public int maxMinDiff(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int low = 0;
        int high = arr[arr.length - 1] - arr[0];
        int ans = 0;

        while (low <= high) 
        {
            int mid = low + (high - low) / 2;
            if (isPossible(arr, k, mid))
            {
                ans = mid;
                low = mid + 1;
            } 
            else
                high = mid - 1;
        }
        return ans;
    }
}
/*This is a classic greedy + binary search problem, similar to "Aggressive cows" from competitive programming.*/

/*we greedily pick the first element, and then keep picking the next available element that is at least d away from the last chosen one. If we can pick at least k elements,
 then distance d is possible. Otherwise, it’s too large.
This allows us to apply Binary Search on the answer (d):
The minimum possible distance is 0.
The maximum possible distance is (arr[n-1] - arr[0]).
We binary search on d, and for each candidate distance, check if it’s feasible using the greedy method.*/

/*Approach : 
Sort the array so that distances can be checked in order.
Use binary search on the answer d between 1 (as we already initialized res to 0) and (arr[n-1] - arr[0]).
For each mid value m:
Try to greedily pick elements with at least m spacing.
If we can select at least k elements → m is feasible, try a bigger distance.
Otherwise, try a smaller distance.
Return the largest feasible d*/
