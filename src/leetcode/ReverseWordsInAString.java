package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

import utils.JsonUtils;

public class ReverseWordsInAString {
	public static void main(String[] args){
		ReverseWordsInAString sln=new ReverseWordsInAString();
		String input="t  h e";
		long s=System.currentTimeMillis();
		Object output=sln.reverseWords(input);
		long e=System.currentTimeMillis();
		System.out.println(e-s+" ms");
		System.out.println(JsonUtils.toJson(output));
	}
	
    public String reverseWords(String s) {
    	if(s==null){
    		return null;
    	}
    	StringBuilder sb=new StringBuilder();
    	s=s.trim();
    	int b=s.length()-1;
    	for(int i=s.length()-1;i>-1;i--){
    		if(s.charAt(i)==' ' || i==0){    			
    			sb.append(s.substring(i==0?0:i+1, b+1));
    			if(i!=0){
    				sb.append(" ");
    			}
    			b=i;
    			while(b>-1 && s.charAt(b)==' '){
    				b--;
    				i=b+1;
    			}
    		}
    	}
    	return sb.toString();
    }
}

