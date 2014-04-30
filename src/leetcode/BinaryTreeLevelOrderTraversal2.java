package leetcode;

import java.util.ArrayList;
import java.util.Collections;

import utils.JsonUtils;

public class BinaryTreeLevelOrderTraversal2 {
	public static void main(String[] args){
		BinaryTreeLevelOrderTraversal2 sln=new BinaryTreeLevelOrderTraversal2();
		TreeNode input=InitUtils.getTree("0_0,1_1,2_2,3_3,4_4,6_5,13_6");
		long s=System.currentTimeMillis();
		Object output=sln.levelOrderBottom(input);
		long e=System.currentTimeMillis();
		System.out.println(e-s+" ms");
		System.out.println(JsonUtils.toJson(output));
	}
	
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {		
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
		
		Collections.reverse(list);
		return list;
    }
}

