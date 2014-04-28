package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

import utils.JsonUtils;

public class LinkedListCycle2 {
	public static void main(String[] args){
		LinkedListCycle2 sln=new LinkedListCycle2();
		ListNode input=InitUtils.getSinglyList("1,2,3,4,5,6,7,8");
		InitUtils.printSinglyList(input);
		ListNode tail=InitUtils.getTail(input);
		tail.next=input.next.next;
		ListNode output=sln.detectCycle(input);
		System.out.println(output.val);
		//InitUtils.printSinglyList((ListNode)output);
	}
	
	public ListNode detectCycle(ListNode head) {
		if(head==null || head.next==null){
        	return null;
        }
        
        ListNode slow=head;
        ListNode fast=head.next;
        while(true){
        	fast=fast.next;
        	if(fast==null){
        		return null;
        	}
        	fast=fast.next;
        	if(fast==null){
        		return null;
        	}
        	slow=slow.next;
        	if(fast==slow){
        		break;
        	}
        }
        
        fast=head;
        slow=slow.next;
        while(slow!=fast){
        	slow=slow.next;
        	fast=fast.next;
        }
        return fast;
    }
}

