package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import utils.JsonUtils;

public class PartitionList {
	public static void main(String[] args){
		PartitionList sln=new PartitionList();
		ListNode input=InitUtils.getSinglyList("4,5,6,7,7");
		int input2=3;
		long s=System.currentTimeMillis();
		Object output=sln.partition(input,input2);
		//sln.merge(input,5,input2,input2.length);
		long e=System.currentTimeMillis();
		System.out.println(e-s+" ms");
		//System.out.println(JsonUtils.toJson(output));
		InitUtils.printSinglyList((ListNode)output);
	}
	
	public ListNode partition(ListNode head, int x) {
        if(head==null){
        	return null;
        }
        
        ListNode low=null;
        ListNode scan=head;
        if(head.val<x){
        	low=head;
        	while(low.next!=null && low.next.val<x){
        		low=low.next;
        	}
        	if(low.next==null){
        		return head;
        	}
        	scan=low.next;
        }else{
        	while(scan.next!=null && scan.next.val>=x){
        		scan=scan.next;
        	}
        	if(scan.next==null){
        		return head;
        	}else{
        		low=scan.next;
        		scan.next=low.next;
        		low.next=head;
        		head=low;
        	}
        }
        
        while(scan.next!=null){
        	while(scan.next!=null && scan.next.val>=x){
        		scan=scan.next;
        	}
        	if(scan.next==null){
        		return head;
        	}else{
        		ListNode hh=low.next;
        		low.next=scan.next;
        		low=low.next;
        		scan.next=low.next;
        		low.next=hh;
        	}
        }
        
        
        return head;
    }
}

