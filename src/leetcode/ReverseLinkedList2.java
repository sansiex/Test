package leetcode;

import java.util.ArrayList;
import java.util.Stack;

import utils.JsonUtils;

public class ReverseLinkedList2 {
	public static void main(String[] args){
		ReverseLinkedList2 sln=new ReverseLinkedList2();
		ListNode input=InitUtils.getSinglyList("1,2,3,4,5,6");
		long s=System.currentTimeMillis();
		Object output=sln.reverseBetween(input,1,6);
		long e=System.currentTimeMillis();
		System.out.println(e-s+" ms");
		//System.out.println(JsonUtils.toJson(output));
		InitUtils.printSinglyList((ListNode)output);
	}
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(head==null){
			return null;
		}
		ListNode pre=null;
		ListNode b=head;
		ListNode e=b;
		for(int i=0;i<m-1;i++){
			pre=b;
			b=b.next;
		}
		e=b;
		for(int i=0;i<n-m;i++){
			e=e.next;
		}
		
		if(pre!=null){
			pre.next=e;
		}
		
		ListNode next=e.next;
		for(int i=0;i<n-m;i++){
			e.next=b;
			b=b.next;
			e.next.next=next;
			next=e.next;
		}
		
		if(m>1){
			return head;
		}
		return e;
    }
}

