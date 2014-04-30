package leetcode;

import java.util.ArrayList;
import java.util.Collections;

import utils.JsonUtils;

public class ValidateBinarySearchTree {
	public static void main(String[] args){
		ValidateBinarySearchTree sln=new ValidateBinarySearchTree();
		TreeNode input=InitUtils.getTree("0_2,1_1,2_3");
		long s=System.currentTimeMillis();
		Object output=sln.isValidBST(input);
		long e=System.currentTimeMillis();
		System.out.println(e-s+" ms");
		System.out.println(JsonUtils.toJson(output));
	}
	
	public boolean inorder(TreeNode root,int min,int max){
		if(root==null){
			return true;
		}
		
		if(root.val>=max || root.val<=min){
			return false;
		}
		
		boolean l=inorder(root.left,min,root.val);
		boolean r=inorder(root.right,root.val,max);
		return l&&r;
	}
	
	public boolean isValidBST(TreeNode root) {
        return inorder(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
}

