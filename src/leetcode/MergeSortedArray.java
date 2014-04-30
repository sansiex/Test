package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import utils.JsonUtils;

public class MergeSortedArray {
	public static void main(String[] args){
		MergeSortedArray sln=new MergeSortedArray();
		int[] input={1,3,4,5,6,0,0,0,0,0,0,0,0,0};
		int[] input2={1,2,4,5,6,6,6,6,6};
		long s=System.currentTimeMillis();
		//Object output=sln.merge(input);
		sln.merge(input,5,input2,input2.length);
		long e=System.currentTimeMillis();
		System.out.println(e-s+" ms");
		//System.out.println(JsonUtils.toJson(output));
		System.out.println(JsonUtils.toJson(input));
	}
	
	public void merge(int A[], int m, int B[], int n) {
        int ai=m-1;
        int bi=n-1;
        int i=A.length-1;
		while(i>-1 && ai>-1 && bi>-1){
        	if(A[ai]>B[bi]){        		
        		A[i]=A[ai];
        		ai--;
        		i--;
        	}else{        		
        		A[i]=B[bi];
        		bi--;
        		i--;
        	}
        }
		if(bi>-1){
			for(;bi>-1;bi--){
				A[i--]=B[bi];
			}
		}
    }
}

