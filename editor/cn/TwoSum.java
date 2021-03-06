//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 8967 👎 0


package Main.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum{
    public static void main(String[] args){
        Solution solution = new TwoSum().new Solution();
        int[] nums = {3,3};
        int target = 6;
        int[] out = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(out));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
private class Solution {
    private int[] twoSum(int[] nums, int target) {
        if(nums.length <= 1) return null;
        int[] res = new int[2];

        //O(n)时间 + O(n)空间(HashMap)
        HashMap<Integer, Integer> mmp = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!mmp.containsKey(target - nums[i])){
                mmp.put(nums[i], i);
            }else{
                res[0] = mmp.get(target - nums[i]); res[1] = i; break;
            }
        }

        //暴力法 O(n^2)时间 + O(1)空间
/*        for(int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == target - nums[j]) {
                    res[0] = i;
                    res[1] = j;
                }
            }*/
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
