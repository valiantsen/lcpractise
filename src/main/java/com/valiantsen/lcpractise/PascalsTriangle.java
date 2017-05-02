package main.java.com.valiantsen.lcpractise;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5,
 * Return
 * 
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * 
 * @ClassName: PascalsTriangle
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhangyasen
 * @date 2017年4月29日
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        for(int i=numRows;i>0;i--){
            List<Integer> list =new ArrayList<Integer>();
            resultList.add(list);
            if(i==numRows){
                list.add(1) ;
                continue;
            }
            List<Integer> targerList = resultList.get(numRows-i-1);
            list.add(1);
            for(int m=0,n=m+1;n<targerList.size();m++,n++){
                list.add(targerList.get(m)+targerList.get(n));
            }
            list.add(1);
        }
        
        return resultList;
    }
}
