package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import utils.JsonUtils;

public class Subset2 {
	public static void main(String[] args){
		Subset2 sln=new Subset2();
		int[] input={-1,1,2};
		long s=System.currentTimeMillis();
		Object output=sln.subsetsWithDup(input);
		long e=System.currentTimeMillis();
		System.out.println(e-s+" ms");
		System.out.println(JsonUtils.toJson(output));
	}
	
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int n:num){
        	Integer c=map.get(n);
        	if(c==null){
        		map.put(n, 1);
        	}else{
        		map.put(n, c+1);
        	}
        }
        
        ArrayList<int[]> order=new ArrayList<>();
        for(int k:map.keySet()){
        	order.add(new int[]{k,map.get(k)});
        }
        
        Collections.sort(order, new Comparator(){

			@Override
			public int compare(Object o1, Object o2) {
				int[] v1=(int[]) o1;
				int[] v2=(int[]) o2;
				return v1[0]-v2[0];
			}
        	
        });
        
        ArrayList<ArrayList<Integer>> ret=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> set=new ArrayList<>();
        ret.add(set);
        for(int[] v:order){
        	ArrayList<ArrayList<Integer>> temp=new  ArrayList<> ();
        	for(ArrayList<Integer> s:ret){
        		for(int i=1;i<=v[1];i++){
        			ArrayList<Integer> ns=(ArrayList<Integer>) s.clone();
        			for(int j=0;j<i;j++){
        				ns.add(v[0]);
        			}
        			temp.add(ns);
        		}
        	}
        	ret.addAll(temp);
        }
        return ret;
    }
}

