package main.java.com.valiantsen.lcpractise;

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
		int i=0;
        for(int n:nums){
            if(i==0||n>nums[i-1]){
                nums[i++]=n;
            }
        }
        return i;
    }
	public static void main(String[] args) {
		int[] a = {1,1,2};
		RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();
		System.out.println(obj.removeDuplicates(a));
	}
}
