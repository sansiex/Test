package leetcode;

import java.util.ArrayList;
import java.util.Collections;

import utils.JsonUtils;

public class BinaryTreeZigzagLevelOrderTraversal {
	public static void main(String[] args){
		BinaryTreeZigzagLevelOrderTraversal sln=new BinaryTreeZigzagLevelOrderTraversal();
		TreeNode input=InitUtils.getTree("0_1,1_2");
		long s=System.currentTimeMillis();
		Object output=sln.zigzagLevelOrder(input);
		long e=System.currentTimeMillis();
		System.out.println(e-s+" ms");
		System.out.println(JsonUtils.toJson(output));
	}
	
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {		
		ArrayList<ArrayList<Integer>> list=new ArrayList<>();
		if(root==null){
			return list;
		}
		
		ArrayList<TreeNode> cur=new ArrayList<>();
		ArrayList<TreeNode> next=new ArrayList<>();
		cur.add(root);
		
		
		while(cur.size()>0){
			ArrayList<Integer> vlist=new ArrayList<>();
			
			for(TreeNode n:cur){
				if(n.left!=null){
					next.add(n.left);
				}
				if(n.right!=null){
					next.add(n.right);
				}
				vlist.add(n.val);
			}			
			
			list.add(vlist);
			cur.clear();
			ArrayList<TreeNode> temp=cur;
			cur=next;
			next=temp;
		}
		
		boolean rev=false;
		for(ArrayList<Integer> vlist:list){
			if(rev){
				Collections.reverse(vlist);				
			}
			rev=!rev;
		}		
		
		return list;
    }
}

