package Main.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Scanner;

public class Lucky_Nums {
	static String is_lucky(int[] nums, int n){
		if(n == 1) return "lucky";
		boolean[] check = new boolean[n - 1];
		for(int i = 0; i < n - 1; i++){
			int cur = nums[i + 1] - nums[i] > 0 ? nums[i + 1] - nums[i] : nums[i] - nums[i + 1];
			if(cur != 0 && cur <= n - 1){
				if(check[cur - 1]){
					return "not lucky";
				}else{
					check[cur - 1] = true;
				}
			}else{
				return "not lucky";
			}
		}
		return "lucky";
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			//int n = Integer.parseInt(sc.nextLine());
			String s = sc.nextLine();
			String[] str = s.split(" ");
			int[] nums = new int[str.length];

			int[] input = new int[str.length - 1];
			for (int i = 0; i < str.length; i++) {
				nums[i] = Integer.parseInt(str[i]);
			}
			int n = nums[0];
			for (int j = 1; j < nums.length; j++) {
				input[j - 1] = nums[j];
			}
			System.out.println(Lucky_Nums.is_lucky(input, n));
		}
	}
}
