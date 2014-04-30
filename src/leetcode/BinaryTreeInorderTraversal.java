package leetcode;

import java.util.ArrayList;
import java.util.Stack;

import utils.JsonUtils;

public class BinaryTreeInorderTraversal {
	public static void main(String[] args){
		BinaryTreeInorderTraversal sln=new BinaryTreeInorderTraversal();
		TreeNode input=InitUtils.getTree("0_3,1_1,2_5,3_0,4_2,5_4,6_6");
		long s=System.currentTimeMillis();
		Object output=sln.inorderTraversal(input);
		long e=System.currentTimeMillis();
		System.out.println(e-s+" ms");
		System.out.println(JsonUtils.toJson(output));
	}
	
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> ret=new ArrayList<Integer>();
		
		Stack<TreeNode> trace=new Stack<>();
		TreeNode left=root;
		while(left!=null){
			trace.push(left);
			left=left.left;
		}
		while(!trace.isEmpty()){
			TreeNode cur=trace.pop();
			ret.add(cur.val);
			
			if(cur.right!=null){
				TreeNode l=cur.right;
				while(l!=null){
					trace.push(l);
					l=l.left;
				}
			}
		}
		
		return ret;
    }
}

