package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

import utils.JsonUtils;

public class ConvertSortedListToBinarySearchTree {
	public static void main(String[] args){
		ConvertSortedListToBinarySearchTree sln=new ConvertSortedListToBinarySearchTree();
		ListNode input=InitUtils.getSinglyList("0,1,2");
		long s=System.currentTimeMillis();
		Object output=sln.sortedListToBST(input);
		long e=System.currentTimeMillis();
		System.out.println(e-s+" ms");
		System.out.println(JsonUtils.toJson(output));
	}
	
	public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
        	return null;
        }
		ListNode slow=head;
		ListNode fast=head.next;
		ListNode pre=null;
		while(fast!=null){
			pre=slow;
			slow=slow.next;
			fast=fast.next;
			if(fast!=null){
				fast=fast.next;
			}
		}
		TreeNode root=new TreeNode(slow.val);
		if(pre!=null){
			pre.next=null;			
			root.left=sortedListToBST(head);
			pre.next=slow;
		}else{
			root.left=null;
		}
		
		root.right=sortedListToBST(slow.next);
		return root;
    }
}

