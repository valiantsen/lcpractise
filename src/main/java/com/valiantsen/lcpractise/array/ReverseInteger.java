/**
 * 
 */
package main.java.com.valiantsen.lcpractise.array;

/**
 * @author zhangyasen
 *
 */
public class ReverseInteger {
	public int reverse(int x) {
		int result =0;
        while(x!=0){
        	int tail = x%10;
        	int m = result*10+tail;
        	if((m-tail)/10!=result){
        		return 0;
        	}
        	result = m;
        }
		
		return result;
    }
	
}
