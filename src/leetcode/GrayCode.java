package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import utils.JsonUtils;

public class GrayCode {
	public static void main(String[] args){
		GrayCode sln=new GrayCode();
		int input=5;
		long s=System.currentTimeMillis();
		Object output=sln.grayCode(input);
		long e=System.currentTimeMillis();
		System.out.println(e-s+" ms");
		//System.out.println(JsonUtils.toJson(output));
	}
	
	public  void recursive(int n, ArrayList<Integer> ret) {
        if(n==1){
        	ret.add(0);
        	ret.add(1);
        }else{
        	recursive(n-1,ret);
        	int inc=(int)Math.pow(2, n-1);
        	for(int i=ret.size()-1;i>-1;i--){
        		ret.add(ret.get(i)+inc);
        	}
        }
    }
	
	public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> ret = new ArrayList<>();
        if(n<1){
        	ret.add(0);
        	return ret;
        }
        
        recursive(n,ret);
		return ret;
    }
}

