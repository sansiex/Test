package leetcode;

import java.util.ArrayList;
import java.util.Collection;

import utils.JsonUtils;

public class InitUtils {
	public static ListNode getSinglyList(String input){
		String[] nums=input.split(",");
		if(nums.length<1){
			return null;
		}
		
		ListNode head=new ListNode(Integer.valueOf(nums[0]));
		ListNode cur=head;
		for(int i=1;i<nums.length;i++){
			ListNode n=new ListNode(Integer.valueOf(nums[i]));
			cur.next=n;
			cur=cur.next;
		}
		return head;
	}
	
	public static void printSinglyList(ListNode head){
		ListNode cur=head;
		while(cur!=null){
			System.out.print(cur.val+",");
			cur=cur.next;
		}
		System.out.println();
	}
	
	public static ListNode getTail(ListNode head){
		if(head==null){
			return null;
		}
		ListNode cur=head;
		while(cur.next!=null){
			cur=cur.next;
		}
		return cur;
	}
	
	public static TreeNode getTree(String input){
		ArrayList<TreeNode> list=new ArrayList<>(100);
		String[] t=input.split(",");
		for(int i=0;i<t.length;i++){
			String[] ns=t[i].split("_");
			int p=Integer.valueOf(ns[0]);
			int val=Integer.valueOf(ns[1]);
			TreeNode node=new TreeNode(val);
			while(p>=list.size()){
				list.add(null);
			}
			list.set(p, node);
		}
		
		for(int i=0;i<list.size();i++){
			TreeNode n=list.get(i);
			if(n!=null){
				if(i*2+1<list.size()){
					n.left=list.get(i*2+1);
				}
				if((i+1)*2<list.size()){
					n.right=list.get((i+1)*2);
				}
				
			}
		}
		return list.get(0);
	}
	
	public static void print2d(Object[] m){
		System.out.println("==============================");
		for(Object o:m){
			JsonUtils.toJson(o);
		}
	}
	
	public static void print2d(Collection m){
		System.out.println("==============================");
		for(Object o:m){
			JsonUtils.toJson(o);
		}
	}
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

/**
 * Definition for a point.
 */
class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

/**
 * Definition for binary tree
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


