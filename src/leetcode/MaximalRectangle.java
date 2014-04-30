package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import utils.JsonUtils;

public class MaximalRectangle {
	public static void main(String[] args){
		MaximalRectangle sln=new MaximalRectangle();
//		char[][] input={ {'0','0','1','0'}
//						,{'1','1','1','1'}
//						,{'1','1','1','1'}
//						,{'1','1','1','0'}
//						,{'1','1','0','0'}
//						,{'1','1','1','1'}
//						,{'1','1','1','0'}};
		char[][] input={{'1'}};
		int input2=3;
		long s=System.currentTimeMillis();
		Object output=sln.maximalRectangle(input);
		//sln.merge(input,5,input2,input2.length);
		long e=System.currentTimeMillis();
		System.out.println(e-s+" ms");
		System.out.println(JsonUtils.toJson(output));
	}
	
	public int maximalRectangle(char[][] matrix) {
        final char one='1';
        
        int max=0;
        for(int i=0;i<matrix.length;i++){
        	for(int j=0;j<matrix[0].length;j++){
        		int rb=matrix[0].length;
        		for(int v=i;v<matrix.length;v++){
        			if(matrix[v][j]!=one){
        				break;
        			}
        			
        			for(int h=j;h<matrix[0].length && h<rb;h++){
        				if(matrix[v][h]!=one){
        					rb=h;
        					break;        					
        				}else{
        					int area=(v-i+1)*(h-j+1);
        					if(area>max){
        						max=area;
        						//System.out.println(max+" "+i+" "+j+" "+v+" "+h);
        					}
        				}
        			}
        		}
        	}
        }
        return max;
    }
}

