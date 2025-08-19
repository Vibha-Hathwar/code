/*
You are given an array arr[]. For each element at index i (0-based indexing), find the farthest index j to the right (i.e., j > i) such that arr[j] < arr[i]. 
If no such index exists for a given position, return -1 for that index. Return the resulting array of answers.
Examples:
Input: arr[] = [2, 5, 1, 3, 2]
Output: [2, 4, -1, 4, -1]
Examples:
Input: arr[] = [2, 3, 5, 4, 1] 
Output: [4, 4, 4, 4, -1]
*/

class Solution {
    public static int binS(int[] arr,int[]max, int arri,int low){
        int high=arr.length-1;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[max[mid]]<arri)
            {
                ans=mid;
                low=mid+1;
            }
            else
                high=mid-1;
        }
        return ans;
    }
    public ArrayList<Integer> farMin(int[] arr) {
        int n=arr.length;
        int [] max=new int[n];
        max[n-1]=n-1;
        for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[max[i+1]])
                max[i]=i;
            else
                max[i]=max[i+1];
        }
        /*For each index i, max[i] stores the index of the smallest element from i to the end.
        If arr = [2, 5, 1, 3, 2], then:
        max[] = [2, 2, 2, 4, 4]
        */
        ArrayList<Integer>ans= new ArrayList<>();
        for(int i=0;i<n;i++)
            ans.add(binS(arr,max,arr[i],i));
        return ans;
        
        /*max[] building: O(n)
        For each i, binary search: O(log n)
        Total: O(n log n)*/
    }
}
