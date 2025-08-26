//Minimum days to make M bouquets of size k

/*You have a row of flowers, where each flower blooms after a specific day. The array arr[] represents the blooming schedule: arr[i] is the day the flower at position i will bloom.
 To create a bouquet, you need to collect k adjacent bloomed flowers. Each flower can only be used in one bouquet.
Your goal is to find the minimum number of days required to make exactly m bouquets. If it is not possible to make m bouquets with the given arrangement, return -1.

Examples:
Input: m = 2, k = 3, arr[] = [5, 5, 5, 5, 10, 5, 5]
Output: 10
Explanation: We need 2 bouquets and each bouquet should have 3 flowers, After day 5: [x, x, x, x, _, x, x], we can make one bouquet of the first three flowers that bloomed, 
but cannot make another bouquet. After day 10: [x, x, x, x, x, x, x], Now we can make two bouquets, taking 3 adjacent flowers in one bouquet.

Examples:
Input: m = 3, k = 2, arr[] = [1, 10, 3, 10, 2]
Output: -1
Explanation: As 3 bouquets each having 2 flowers are needed, that means we need 6 flowers. But there are only 5 flowers so it is impossible to get the needed bouquets therefore -1
 will be returned.*/

class Solution {
    
    private static boolean canMakeBouquets(int[] arr, int m, int k, int day) 
    {
        int count = 0, bouquets = 0;
        for (int bloomDay : arr) 
            if (bloomDay <= day) 
            {
                count++;
                if (count == k) 
                {
                    bouquets++;
                    count = 0; 
                }
            } 
            else 
                count = 0; 
        return bouquets >= m;
    }
    
    public int minDaysBloom(int[] arr, int k, int m) {
        // code here
        int n = arr.length;
        if ((long) m * k > n) return -1;
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        for (int day : arr) 
        {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }
        while (left < right) 
        {
            int mid = left + (right - left) / 2;
            if (canMakeBouquets(arr, m, k, mid))
                right = mid; 
            else
                left = mid + 1; 
        }
        return left;
    }
}


/*Binary Search Setup: We perform binary search on the day value (from 0 to a maximum possible day, say 1e9+1). For each mid-value (candidate day), we check if it's
 possible to form at least m bouquets of size k by that day.
*/

/*
1.  Check if m * k exceeds the total flowers. If yes, return -1.
2.  Initialize low = 0 and high = 1e9+1 (upper bound for days).
3.  While low <= high:
    -  Compute mid = low + (high - low)/2.
    - Check feasibility for mid using helper function help:
      *  Traverse the array, counting consecutive blooms (flowers <= mid).
      *  Whenever consecutive count reaches k, increment bouquet count and reset consecutive counter.
    -  If feasible (bouquets >= m), set ans = mid and search left (high = mid-1).
    -  Else, search right (low = mid+1).
4.  Return ans.*/
