package main.java.com.valiantsen.lcpractise.string;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the
 * input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]"
 * are not.
 * 
 * @ClassName: ValidParenthesesE
 * @author zhangyasen
 * @date 2017年6月20日
 */
public class ValidParenthesesE {
    public boolean isValid(String s) {
        if (s == null)
            return false;
        Stack st = new Stack();
        for (char c : s.toCharArray()) {
            switch (c) {
                case ')':
                    if (st.empty())
                        return false;
                    if ((char) st.pop() != '(')
                        return false;
                    break;
                case ']':
                    if (st.empty())
                        return false;
                    if ((char) st.pop() != '[')
                        return false;
                    break;
                case '}':
                    if (st.empty())
                        return false;
                    if ((char) st.pop() != '{')
                        return false;
                    break;
                default:
                    st.push(c);
            }

        }
        return st.empty();
    }
}
