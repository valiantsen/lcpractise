package main.java.com.valiantsen.ama.oa;

import java.util.Stack;

public class BaseBallScore {


    public int getScore(String[] scores) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (String str : scores) {
            switch (str.charAt(0)) {
                case 'X':
                    if (!stack.isEmpty()) {
                        sum += (stack.peek() * 2);
                        stack.add(stack.peek() * 2);
                    }
                    break;
                case 'Z':
                    if (!stack.isEmpty()) {
                        sum -= stack.pop();
                    }
                    break;
                case '+':
                    if (!stack.isEmpty() && stack.size() > 1) {
                        int first = stack.pop();
                        int second = stack.pop();
                        sum += first;
                        sum += second;
                        stack.add(second);
                        stack.add(first);
                        stack.add(second + first);
                    } else if (stack.size() == 1) {
                        sum += stack.peek();
                        stack.add(stack.peek());
                    }
                    break;
                default:
                    sum += Integer.valueOf(str);
                    stack.add(Integer.valueOf(str));
                    break;

            }
        }

        return sum;
    }

    public static void main(String[] args) {
        String[] s = {"5", "-2", "4", "Z", "X", "9", "+", "+"};
        BaseBallScore b = new BaseBallScore();
        System.out.println(b.getScore(s));
    }
}
