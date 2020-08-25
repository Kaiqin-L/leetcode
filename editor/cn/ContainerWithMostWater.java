//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。 
//
// 
//
// 
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 
//
// 示例： 
//
// 输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
// Related Topics 数组 双指针 
// 👍 1771 👎 0


package Main.leetcode.editor.cn;

import java.util.Map;

public class ContainerWithMostWater{
    public static void main(String[] args){
        Solution solution = new ContainerWithMostWater().new Solution();
        int[] ans = {1,8,6,2,5,4,8,3,7};
        System.out.print(solution.maxArea(ans));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        // 暴力法
//        for(int i = 0; i < height.length; i++){
//            for(int j = i; j < height.length; j++){
//                int cur = Math.min(height[i], height[j])*(j - i);
//                max = max < cur ? cur : max;
//            }
//        }
        //
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            int cur = Math.min(height[right],height[left])*(right - left); // 当前所接水值
            max = cur > max ? cur : max;
            if(height[left] <= height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
