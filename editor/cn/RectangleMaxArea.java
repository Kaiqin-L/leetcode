package Main.leetcode.editor.cn;

import java.util.Scanner;

public class RectangleMaxArea {
	//给定柱高和柱宽两个数组，输入为"[1,2,3,4,2],[3,7,4,8,9]"，求能找出的最大矩形面积
	static int find(int[] weights, int[] heights){
		int area = 0;
		int len = weights.length;
		for(int i = 0; i < len; i++){
			//以i为分界向左向右找所能扩大的范围
			int left = i;
			while(left > 0 && heights[left - 1] > heights[left]){
				left--;
			}

			int right = i;
			while(right < len - 1 && heights[right + 1] > heights[right]){
				right++;
			}

			//找到宽度
			int width = 0;
			for(int j = left; j <= right; j++){
				width += weights[j];
			}

			area = Math.max(area, width*heights[i]);

		}
		return area;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int len  = s.length();
		int boundary = s.indexOf(']');
		String width0 = s.substring(1, boundary);
		String height0 = s.substring(boundary + 3, len - 1);
		String[] wid = width0.split(",");
		String[] hei = height0.split(",");

		int[] width = new int[wid.length];
		int[] height = new int[hei.length];
		for (int i = 0; i < wid.length; i++){
			width[i] = Integer.parseInt(wid[i]);
			height[i] = Integer.parseInt(hei[i]);
		}

		System.out.println(find(width,height));
	}
}
