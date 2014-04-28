package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

import utils.JsonUtils;

public class SingleNumber2 {
	public static void main(String[] args){
		SingleNumber2 sln=new SingleNumber2();
		int[] input={1,1,2,3,2,3,234235,1,3,2};//,4,4,4,5,5,5,6,6,6,7,7,7};
		Object output=sln.singleNumber(input);
		System.out.println(JsonUtils.toJson(output));
		//InitUtils.printSinglyList((ListNode)output);
	}
	
	public int singleNumber(int[] A) {
        int[] num=new int[3];
        int e=0;
        for(int i=0;i<A.length;i++){
        	for(int j=num.length-1;j>0;j--){
        		num[j] |= num[j-1] & A[i];
        	}
        	num[0] |= A[i];
        	for(int j=0;j<num.length-1;j++){
            	num[j] &= ~num[num.length-1];
            }
        	num[num.length-1]=0;
        }
        
        return num[0];
    }
}

