package main.java.com.valiantsen.lcpractise.array;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
 * @ClassName: KthLargestElementInAnArrayM
 * @author zhangyasen
 * @date 2017年9月24日
 */
public class KthLargestElementInAnArrayM {
    //heap
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for(int n:nums){
            if(queue.size()<k){
            queue.add(n);
            }else{
                if(queue.peek()<n){
                    queue.poll();
                    queue.add(n);
                }
            }
        }
        return queue.peek();
    }
    
    //selection algorithm
    public int findKthLargestQ(int[] nums, int k) {
        return partition(nums,0,nums.length-1,k);
    }
    private int partition(int[] nums,int left,int right,int k){
        if(left==right) return nums[left];
        int pivot = nums[left];
        int i=left,j=right;
        while(i<j){
            while(i<j &&nums[j]>=pivot){
                j--;
            }
            if(i<j &&nums[j]<pivot){
                nums[i] = nums[j];
   
            }
            while(i<j && nums[i]<=pivot){
                i++;
            }
            if(i<j && nums[i]>pivot){
                    nums[j] = nums[i];
            }
            
        }
        nums[j] = pivot;
        int now = nums.length-j;
        if(now ==k) return nums[j];
        else if(now >k) return partition(nums,j+1,right,k);
        else return partition(nums,left,j-1,k);
    }
    
    public int findKthLargestRandom(int[] nums, int k) {
        Random random = new Random();
       return partitionRandom(nums,0,nums.length-1,k,random);
   }
   private int partitionRandom(int[] nums,int left,int right,int k,Random random){
       if(left==right) return nums[left];
       int index = random.nextInt(right)%(right-left+1)+left;
       int temp = nums[left];
        nums[left] = nums[index];
       nums[index]=temp;
       int pivot = nums[left];
       int i=left,j=right;
       while(i<j){
           while(i<j &&nums[j]>=pivot){
               j--;
           }
           if(i<j &&nums[j]<pivot){
               nums[i] = nums[j];
  
           }
           while(i<j && nums[i]<=pivot){
               i++;
           }
           if(i<j && nums[i]>pivot){
                   nums[j] = nums[i];
           }
           
       }
       nums[j] = pivot;
       int now = nums.length-j;
       if(now ==k) return nums[j];
       else if(now >k) return partitionRandom(nums,j+1,right,k,random);
       else return partitionRandom(nums,left,j-1,k,random);
   }
    public static void main(String[] args) {
        KthLargestElementInAnArrayM m = new KthLargestElementInAnArrayM();
        int[] array = {99,99};
        System.out.println(m.findKthLargestQ(array, 1));
    }
}
