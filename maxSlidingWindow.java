//Leetcode - https://leetcode.com/problems/sliding-window-maximum/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        int n = nums.length;
        Deque<Integer> dq = new LinkedList<>();
        int arr[] = new int[n-k+1];
        dq.add(0);
        int j=0;
        for(int i=1; i<k;i++)
        {
            
                while(!dq.isEmpty() && nums[i] >= nums[dq.getLast()])
                {
                    dq.removeLast();
                }
                dq.addLast(i);
            
        }
        arr[j] = nums[dq.getFirst()];
        j++;
        for(int i=k;i<nums.length;i++)
        {
            while(!dq.isEmpty() && dq.getFirst()<=i-k)
            {
                dq.removeFirst();
            }

            while(!dq.isEmpty() && nums[i] >= nums[dq.getLast()])
                {
                    dq.removeLast();
                }
                dq.addLast(i);
                arr[j] = nums[dq.getFirst()];j++;

        } return arr;
    }
}
