package main.java.com.valiantsen.lcpractise.array;

public class LongestCommonRefix2 {
	 public String longestCommonPrefix(String[] strs) {
         if(strs.length==0){
        	 return "";
         }
         return longestCommonPrefix(strs, 0, strs.length-1);
    }
	 
	 public String longestCommonPrefix(String[] strs,int start,int end){
		 if(start==end){
			 return strs[start];
		 }else{
		 int mid = (start+end)/2;
			String left= longestCommonPrefix(strs,start,mid);
			String right =  longestCommonPrefix(strs, mid+1, end);
		 return getLongestCommonPrefixFromTwoString(left,right);
		 }
		 
	 }
    
    public String getLongestCommonPrefixFromTwoString(String left,String right){
         int min = Math.min(left.length(), right.length());
         int i=0;
        for(;i<min;i++){
        	if(left.charAt(i)!=right.charAt(i)){
        		break;
        	}
        }
        return left.substring(0, i);
    }
}
