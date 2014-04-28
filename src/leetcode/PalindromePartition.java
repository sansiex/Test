package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

import utils.JsonUtils;

public class PalindromePartition {
	public static void main(String[] args){
		PalindromePartition sln=new PalindromePartition();
		String input="aabbaab";
		long s=System.currentTimeMillis();
		Object output=sln.partition(input);
		long e=System.currentTimeMillis();
		System.out.println(e-s+" ms");
		System.out.println(JsonUtils.toJson(output));
	}
	
	public ArrayList<ArrayList<String>> partition(String s) {		
		ArrayList<ArrayList<String>> ret=new ArrayList<ArrayList<String>>();
		if(s==null || s.length()==0){
			return ret;
		}
		
		int len=s.length();
		boolean[][] dp=new boolean[len][len];
		
		for(int i=0;i<len;i++){
			dp[i][i]=true;
		}
		
		for(int i=len-2;i>=0;i--){
			for(int j=i+1;j<len;j++){
				if(i<=j && s.charAt(i)==s.charAt(j)){
					if(i+1>j-1){
						dp[i][j]=true;
					}else if(dp[i+1][j-1]){
						dp[i][j]=true;
					}					
				}
			}
		}
		
		partition(s,0,new ArrayList<String>(), dp, ret);
		InitUtils.print2d(ret);
		return ret;
    }
	
	public void partition(String s, int b,ArrayList<String> inter, boolean[][] dp, ArrayList<ArrayList<String>> ret){
		for(int i=s.length()-1;i>=b;i--){
			if(dp[b][i]){
				ArrayList<String> list=(ArrayList<String>) inter.clone();
				list.add(s.substring(b,i+1));
				if(i==s.length()-1){
					ret.add(list);
				}else{
					partition(s,i+1,list,dp,ret);
				}
			}
		}
	}
}

