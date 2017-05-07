package main.java.com.valiantsen.lcpractise.array;

public class RemoveElement {
	public int removeElement(int[] nums, int val) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){
                count++;
            }else{
                if(count>0){
                    nums[i-count]=nums[i];
                }
            }
        }
        return nums.length-count;
    }
}
