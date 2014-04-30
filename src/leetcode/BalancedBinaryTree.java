package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

import utils.JsonUtils;

public class BalancedBinaryTree {
	public static void main(String[] args){
		BalancedBinaryTree sln=new BalancedBinaryTree();
		TreeNode input=InitUtils.getTree("0_1,1_2,2_3,3_0,5_0,6_5,7_1");
		long s=System.currentTimeMillis();
		Object output=sln.isBalanced(input);
		long e=System.currentTimeMillis();
		System.out.println(e-s+" ms");
		System.out.println(JsonUtils.toJson(output));
	}
	
	public int recursive(TreeNode root) {
        if(root==null){
        	return 0;
        }
        
        int lh=recursive(root.left);
        int rh=recursive(root.right);
        if(lh<0 || rh<0 || Math.abs(lh-rh)>1){
        	return -1;
        }
        return Math.max(lh, rh)+1;
    }
	
	public boolean isBalanced(TreeNode root) {
        int ret=recursive(root);
        if(ret<0){
        	return false;
        }
        return true;
    }
}

