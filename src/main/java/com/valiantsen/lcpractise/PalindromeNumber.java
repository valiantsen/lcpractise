/**
 * 
 */
package main.java.com.valiantsen.lcpractise;

/**
 * @author zhangyasen
 *
 */
public class PalindromeNumber {
	
public boolean isPalindrome(int x) {
	int result =0;
    int old =x;
    while(x>0){
    	int tail = x%10;
    	int newResult = result*10+tail;
    	if((newResult-tail)/10!=result){
    		return false;
    	}
    	result = newResult;
    	x=x/10;
    }

return old==result;
	 
    }

}
