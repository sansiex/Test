package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

import utils.JsonUtils;

public class PalindromePartition2 {
	public static void main(String[] args){
		PalindromePartition2 sln=new PalindromePartition2();
		String input="fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi";
		long s=System.currentTimeMillis();
		Object output=sln.minCut(input);
		long e=System.currentTimeMillis();
		System.out.println(e-s+" ms");
		System.out.println(JsonUtils.toJson(output));
	}
	
	public int minCut(String s) {
		if(s==null || s.length()==0){
			return 0;
		}
		
		int len=s.length();
		boolean[][] dp=new boolean[len][len];
		int[] res=new int[len+1];
		
		for (int i = 0; i < len; i++) {
			res[i]=len-1-i;
		}
		
		for(int i=len-2;i>=0;i--){
			for(int j=i;j<len;j++){
				if(s.charAt(i)==s.charAt(j) && (j-i<3 || dp[i+1][j-1])){
					dp[i][j]=true;
					if(j==len-1){
						res[i]=0;
					}else{
						res[i]=Math.min(res[i], 1+res[j+1]);
					}
				}
			}
		}
		
		return res[0];
    }
}

