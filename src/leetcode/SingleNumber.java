package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

import utils.JsonUtils;

public class SingleNumber {
	public static void main(String[] args){
		SingleNumber sln=new SingleNumber();
		int[] input={1,1,2,2,3,4,4,5,5,6,6,7,7};
		Object output=sln.singleNumber(input);
		System.out.println(JsonUtils.toJson(output));
		//InitUtils.printSinglyList((ListNode)output);
	}
	
	public int singleNumber(int[] A) {
        int a=0;
        for(int i=0;i<A.length;i++){
            a^=A[i];
        }
        return a;
    }
}

