//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// 👍 98 👎 0


package Main.leetcode.editor.cn;

import java.util.Arrays;

public class ErChaSouSuoShuDeHouXuBianLiXuLieLcof{
    public static void main(String[] args){
        Solution solution = new ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
        int[] nums = {1, 2, 3, 4, 5};
        boolean out = solution.verifyPostorder(nums);
        System.out.println(out);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder.length <= 1) return true;
        return helper(postorder, 0, postorder.length - 1);
    }

        private boolean helper(int[] postorder, int start, int end) {
        if(start >= end) return true;

        int root = postorder[end];
        //找到左右子树的分界线，如果使用另一个变量bound来代表分界线的话，注意不要把左子树划分为右子树。也就是说要注意bound不往前走的情况
        int i;
        for(i = start; i < end; i++){
            if(postorder[i] > root){
                break;
            }
        }

        //如果右子树中有值小于root，则为不合格
        for(int j = i; j < end; j++){
            if(postorder[j] < root){
                return false;
            }
        }

        // 分解问题
        return  helper(postorder, start, i - 1)&&helper(postorder, i, end - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
