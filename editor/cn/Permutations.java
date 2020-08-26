//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 853 👎 0


package Main.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Permutations{
    public static void main(String[] args){
        Solution solution = new Permutations().new Solution();
        int[] nums = {1,2,3};
        List<List<Integer>> res = solution.permute(nums);
        for (List<Integer> ans: res
        ) {
            System.out.printf("%s", ans);
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> tmp = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        for (int num: nums
             ) {
            tmp.add(num);
        }
        dfs(tmp, 0);
        return res;
    }

    private void dfs(ArrayList<Integer> nums, int begin) {
        if(begin == nums.size()){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = begin; i < nums.size(); i++){//遍历，分别以不同的元素打头
            int tmp = nums.get(begin);
            nums.set(begin, nums.get(i));
            nums.set(i, tmp);

            dfs(nums, begin + 1);

            int tmp2 = nums.get(begin);
            nums.set(begin, nums.get(i));
            nums.set(i, tmp2);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
