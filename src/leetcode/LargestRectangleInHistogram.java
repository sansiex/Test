package leetcode;

import java.util.Stack;

import utils.JsonUtils;

public class LargestRectangleInHistogram {
	public static void main(String[] args){
		LargestRectangleInHistogram sln=new LargestRectangleInHistogram();
		int[] input=new int[3000000];
		for(int i=0;i<input.length;i++){
			input[i]=i;
		}
		//int[] input={5,2};
		int input2=3;
		long s=System.currentTimeMillis();
		Object output=sln.largestRectangleArea(input);
		//sln.merge(input,5,input2,input2.length);
		long e=System.currentTimeMillis();
		System.out.println(e-s+" ms");
		System.out.println(JsonUtils.toJson(output));
	}
	
	public int largestRectangleArea(int[] height) {
		Stack<Integer> stk=new Stack<>();
		int max=0;
		for(int i=0;i<height.length;i++){
			if(stk.isEmpty() || height[stk.peek()]<=height[i]){
				stk.push(i);
			}else{
				int h=stk.pop();
				int area = 0;
				if(stk.isEmpty()){
					area=height[h]*(i);
				}else{
					area=height[h]*(i-stk.peek()-1);
				}
				max=Math.max(area, max);
				i--;
			}
		}
		
		while(!stk.isEmpty()){
			int h=stk.pop();
			int width=stk.isEmpty()?height.length:height.length-stk.peek()-1;
			max=Math.max(height[h]*width, max);
		}
		return max;
    }
	
//	public int largestRectangleArea(int[] height) {
//		int max=0;
//        for(int i=0;i<height.length;i++){
//        	if(i>0 && height[i]<=height[i-1]){
//        		continue;
//        	}
//        	int ceil=height[i];
//        	for(int j=i;j<height.length;j++){
//        		if(height[j]<ceil){
//        			ceil=height[j];        			
//        		}
//        		int area=(j-i+1)*ceil;
//        		if(area>max){
//        			max=area;
//        		}else if((height.length-i)*ceil<=max){
//        			break;
//        		}
//        	}
//        }
//        return max;
//    }
}

