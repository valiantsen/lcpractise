package main.java.com.valiantsen.ama.onsite;

/**
 * 给你一个数组【1，0，1,0,1,0】，1 代表陆地，0代表水，你每次可以+1，-1 后者+n(n是 INPUT PARAMETER), 判断能否从数组的START POINT 到数组的尾端。
 * 
 * @ClassName: GoToTheEndInWater
 * @author zhangyasen
 * @date 2017年10月14日
 */
public class GoToTheEndInWater {

    public boolean reachEnd(int[] nums, int k) {
        boolean[] visited = new boolean[nums.length];
        return canReachFromThisPoint(0, k, nums, visited);
    }

    private boolean canReachFromThisPoint(int i, int k, int[] nums, boolean[] visited) {
        if (i > -1 && i < nums.length && !visited[i] && nums[i] != 0) {
            if (i == nums.length - 1) {
                return true;
            }
            visited[i] = true;

            if (canReachFromThisPoint(i + 1, k, nums, visited) || canReachFromThisPoint(i - 1, k, nums, visited)
                    || canReachFromThisPoint(i + k, k, nums, visited)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 0, 1, 1, 0};
        GoToTheEndInWater a = new GoToTheEndInWater();
        System.out.println(a.reachEnd(nums, 2));
    }
}
