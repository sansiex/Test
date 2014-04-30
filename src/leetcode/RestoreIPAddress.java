package leetcode;

import java.util.ArrayList;
import java.util.Stack;

import utils.JsonUtils;

public class RestoreIPAddress {
	public static void main(String[] args){
		RestoreIPAddress sln=new RestoreIPAddress();
		String input="0000";
		long s=System.currentTimeMillis();
		Object output=sln.restoreIpAddresses(input);
		long e=System.currentTimeMillis();
		System.out.println(e-s+" ms");
		System.out.println(JsonUtils.toJson(output));
	}
	
	public ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> ret=new ArrayList<String>();
		if(s==null || s.length()<4){
			return ret;
		}
    	for(int i=1;i<4;i++){
    		int start=0;
    		String ip1=s.substring(start,start+i);
    		if(Integer.parseInt(ip1)>255 || (ip1.startsWith("0") && i!=1)){
    			continue;
    		}else if(s.length()-start-i<3 || s.length()-start-i>9){
    			continue;
    		}else{
    			start+=i;
    			for(int j=1;j<4;j++){
    				if(start+j>s.length()){
    					continue;
    				}
    				String ip2=s.substring(start,start+j);
    	    		if(Integer.parseInt(ip2)>255 || (ip2.startsWith("0") && j!=1)){
    	    			continue;
    	    		}else if(s.length()-start-j<2 || s.length()-start-j>6){
    	    			continue;
    	    		}else{
    	    			start+=j;
    	    			for(int k=1;k<4;k++){
    	    				if(start+k>s.length()){
    	    					continue;
    	    				}
    	    				String ip3=s.substring(start,start+k);    	    				
    	    	    		if(Integer.parseInt(ip3)>255 || (ip3.startsWith("0") && k!=1)){
    	    	    			continue;
    	    	    		}else if(s.length()-start-k<1 || s.length()-start-k>3){
    	    	    			continue;
    	    	    		}else{
    	    	    			String ip4=s.substring(start+k, s.length());
    	    	    			if(Integer.parseInt(ip4)>255 || (ip4.startsWith("0") && ip4.length()!=1)){
    	    	    				continue;
    	    	    			}
    	    	    			ret.add(ip1+"."+ip2+"."+ip3+"."+ip4);
    	    	    		}
    	    			}
    	    			start-=j;
    	    		}
    			}
    		}
    	} 
    	return ret;
    }
}

