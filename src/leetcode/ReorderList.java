package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

import utils.JsonUtils;

public class ReorderList {
	public static void main(String[] args){
		ReorderList sln=new ReorderList();
		ListNode input=InitUtils.getSinglyList("1,2,3,4,5,6,7,8");
		InitUtils.printSinglyList(input);
		//Object output=sln.reorderList(input);
		sln.reorderList(input);
		//System.out.println(JsonUtils.toJson(input));
		InitUtils.printSinglyList((ListNode)input);
	}
	
	public void reorderList(ListNode head) {
        if(head==null || head.next==null){
        	return;
        }
        
        ListNode slow=head;
        ListNode fast=head;
        while(true){
        	fast=fast.next;
        	if(fast==null){
        		break;
        	}
        	fast=fast.next;
        	if(fast==null){
        		break;
        	}
        	slow=slow.next;
        }
        ListNode mid=slow.next;
        slow.next=null;
        fast=reverseSinglyList(mid);
        slow=head;
        while(fast!=null){
        	ListNode t=fast;
        	fast=fast.next;
        	t.next=slow.next;
        	slow.next=t;
        	slow=t.next;
        }
    }
	
	public ListNode reverseSinglyList(ListNode head){
		if(head==null || head.next==null){
			return head;
		}
		
		ListNode cur=head.next;
		ListNode pre=head;
		head.next=null;
		while(cur!=null){
			ListNode t=cur;
			cur=cur.next;
			t.next=pre;
			pre=t;
		}
		return pre;
	}
}

