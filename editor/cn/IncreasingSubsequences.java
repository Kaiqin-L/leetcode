//给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。 
//
// 示例: 
//
// 
//输入: [4, 6, 7, 7]
//输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7
//]] 
//
// 说明: 
//
// 
// 给定数组的长度不会超过15。 
// 数组中的整数范围是 [-100,100]。 
// 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。 
// 
// Related Topics 深度优先搜索 
// 👍 167 👎 0


package Main.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class IncreasingSubsequences{
    public static void main(String[] args){
        Solution solution = new IncreasingSubsequences().new Solution();
        int[] nums = {4,6,7,7};
        List<List<Integer>> res = solution.findSubsequences(nums);
        for (List<Integer> ans: res
             ) {
            System.out.printf("%s", ans);
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums, 0, Integer.MIN_VALUE);
        return res;
    }

    private void dfs(int[] nums, int index, int minValue) {
        if(index == nums.length){
            if(tmp.size() >= 2){
                res.add(new ArrayList<>(tmp));
            }
            return;
        }

        if(nums[index] >= minValue){
            tmp.add(nums[index]);
            dfs(nums, index + 1, nums[index]); // 选index上的元素
            tmp.remove(tmp.size() - 1);
        }
        if(nums[index] != minValue)  // 为什么加了这个条件就去重了？
            dfs(nums, index + 1, minValue);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
