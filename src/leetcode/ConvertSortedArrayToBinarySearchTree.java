package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

import utils.JsonUtils;

public class ConvertSortedArrayToBinarySearchTree {
	public static void main(String[] args){
		ConvertSortedArrayToBinarySearchTree sln=new ConvertSortedArrayToBinarySearchTree();
		int[] input={0,1,2,3,4,5,6,7};
		long s=System.currentTimeMillis();
		Object output=sln.sortedArrayToBST(input);
		long e=System.currentTimeMillis();
		System.out.println(e-s+" ms");
		System.out.println(JsonUtils.toJson(output));
	}
	
	public TreeNode sortedArrayToBST(int[] num,int s,int e) {
		if(num==null || s>e){
        	return null;
        }
		int m=(s+e)/2;
		TreeNode root=new TreeNode(num[m]);
		root.left=sortedArrayToBST(num,s,m-1);
		root.right=sortedArrayToBST(num,m+1,e);
		return root;
	}
	
	public TreeNode sortedArrayToBST(int[] num) {
		return sortedArrayToBST(num,0,num.length-1);
    }
}

