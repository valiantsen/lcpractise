/**
 * 
 */
package main.java.com.valiantsen.lcpractise.array;

/**
 * @author zhangyasen
 *
 */
public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
	       int low=0,high = nums.length-1;
			 while(low<=high){
			 	int mid = (low+high)/2;
			 	if(nums[mid]==target){
			 	return mid;
			 	}else if(nums[mid]>target){
			 		high=mid-1;
			 	}else {
			 		low=mid+1;
			 	}
			 }
			 return low;
	    }
	
	public static void main(String[] args) {
		int m=1;
		int n=2;
		System.out.println(m=n==2?m:0);
		System.out.println(m);
	}
}
