package leetcode;

import java.util.ArrayList;
import java.util.Stack;

import utils.JsonUtils;

public class BinaryTreePreorderTraversal {
	public static void main(String[] args){
		BinaryTreePreorderTraversal sln=new BinaryTreePreorderTraversal();
		TreeNode input=InitUtils.getTree("0_0,1_1,2_2,3_3,4_4,6_5,13_6");
		//InitUtils.printSinglyList(input);
		Object output=sln.preorderTraversal(input);
		System.out.println(JsonUtils.toJson(output));
		//InitUtils.printSinglyList((ListNode)output);
	}
	
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> ret=new ArrayList<Integer>();
		if(root==null){
			return ret;
		}
        
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
        	TreeNode r=stack.pop();
        	ret.add(r.val);
        	if(r.right!=null){
        		stack.push(r.right);
        	}
        	if(r.left!=null){
        		stack.push(r.left);
        	}
        }
        return ret;
    }
}

