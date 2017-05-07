package main.java.com.valiantsen.lcpractise.array;

public class LongestCommonRefix {

	 public String longestCommonPrefix(String[] strs) {
         String finalResult="";
        if(strs!=null && strs.length>0){
            if(strs.length==1){
                return strs[0];
            }
            for(int i=1;i<strs.length;i++){
               String temp=getLongestCommonPrefixFromTwoString(strs[0],strs[i]);
               if(i==1){
                   finalResult=temp;
                   continue;
               }
               if(temp.length()<finalResult.length()){
                   finalResult=temp;
               }
            }
        }
        
        return finalResult;
    }
    
    public String getLongestCommonPrefixFromTwoString(String a,String b){
        if("".equals(a)||"".equals(b)){
            return "";
        }
        String result="";
        for(int i=0;i<a.length();i++){
            if(i+1>b.length()){
                break;
            }
            if(a.substring(0,i+1).equals(b.substring(0,i+1))){
                result = a.substring(0,i+1);
            }
        }
        return result;
    }
}
