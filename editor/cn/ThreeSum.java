//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2532 👎 0


package Main.leetcode.editor.cn;

import java.util.*;

public class ThreeSum{
    public static void main(String[] args){
        Solution solution = new ThreeSum().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
            //时间复杂度为O(n*n*3log3)，空间复杂度为O(n)
//        Set<List<Integer>> res = new HashSet<>();
//        if(nums.length <= 2 || nums == null) return new ArrayList<>(res);
//
//        for(int i = 0; i < nums.length - 2; i++){
//            int target = - nums[i];
//            HashMap<Integer, Integer> map = new HashMap<>();
//            for(int j = i+1; j < nums.length; j++){
//                if(map.containsKey(target - nums[j])){
//                    Integer[] tmp = {nums[i],nums[j], target - nums[j]};
//                    Arrays.sort(tmp);
//                    res.add(Arrays.asList(tmp));
//                }else{
//                    map.put(nums[j], j);
//                }
//            }
//        }
//        return new ArrayList<>(res);

        // 时间复杂度O(n^2)+O(n*logn)，空间复杂度为O(n)
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            int target = - nums[i];
            int j = i + 1; int k = nums.length - 1;
            while(j < k){
                if(nums[j] + nums[k] == target){
                    Integer[] tmp = {nums[i],nums[j], target - nums[j]};
                    res.add(Arrays.asList(tmp));
                    j++; k--;
                }else if(nums[j] + nums[k] > target){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return new ArrayList<>(res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

