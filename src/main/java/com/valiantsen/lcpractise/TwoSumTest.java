package main.java.com.valiantsen.lcpractise;

public class TwoSumTest {
	
	    public int[] twoSum(int[] nums, int target) {
	    	int[] result = new int[2];
	        
	    	if(nums==null || nums.length<=1){
	    		return result;
	    	}
	    	for(int i=0;i<nums.length;i++){
	    		if(nums[i]>=target){
	    			continue;
	    		}
	    		for(int j=i+1;j<nums.length;j++){
	    			if(nums[j]>=target){
		    			continue;
		    		}
	    			if(nums[i]+nums[j]==target){
	    				result[0]=i;
	    				result[1] =j;
	    				return result;
	    			}
	    		}
	    	}
	    	return result;
	    }
	    
public static void main(String[] args) {
	System.out.println(1234);
}

}


