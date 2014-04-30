package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import utils.JsonUtils;

public class Solution {
	public static void main(String[] args){
		Solution sln=new Solution();
		int[] input=new int[10000];
		for(int i=0;i<input.length;i++){
			input[i]=i;
		}
		//int[] input={0,9};
		int input2=3;
		long s=System.currentTimeMillis();
		Object output=sln.largestRectangleArea(input);
		//sln.merge(input,5,input2,input2.length);
		long e=System.currentTimeMillis();
		System.out.println(e-s+" ms");
		System.out.println(JsonUtils.toJson(output));
	}
	
	public int largestRectangleArea(int[] height) {
		int max=0;
        for(int i=0;i<height.length;i++){
        	if(i>0 && height[i]<=height[i-1]){
        		continue;
        	}
        	int ceil=height[i];
        	for(int j=i;j<height.length;j++){
        		if(height[j]<ceil){
        			ceil=height[j];        			
        		}
        		int area=(j-i+1)*ceil;
        		if(area>max){
        			max=area;
        		}else if((height.length-i)*ceil<=max){
        			break;
        		}
        	}
        }
        return max;
    }
}

