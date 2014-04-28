package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

import utils.JsonUtils;

public class LinkedListCycle {
	public static void main(String[] args){
		LinkedListCycle sln=new LinkedListCycle();
		ListNode input=InitUtils.getSinglyList("1,2,3,4,5,6,7,8");
		InitUtils.printSinglyList(input);
		ListNode tail=InitUtils.getTail(input);
		tail.next=tail;
		Object output=sln.hasCycle(input);
		System.out.println(JsonUtils.toJson(output));
		//InitUtils.printSinglyList((ListNode)output);
	}
	
	public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null){
        	return false;
        }
        
        ListNode slow=head;
        ListNode fast=head.next;
        while(true){
        	fast=fast.next;
        	if(fast==null){
        		return false;
        	}
        	fast=fast.next;
        	if(fast==null){
        		return false;
        	}
        	slow=slow.next;
        	if(fast==slow){
        		return true;
        	}
        }
    }
}

